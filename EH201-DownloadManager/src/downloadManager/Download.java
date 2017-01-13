package downloadManager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Download extends Thread {
	List<DownloadEventListener> listeners = new ArrayList<DownloadEventListener>();
	URL url; 
	String name;
	int bytesDownloaded = 0;
	String downloadDirectory;
	
	public Download(String url, String downloadDirectory) {
		this.downloadDirectory = downloadDirectory;
		try {
			this.url = new URL(url);
			String[] nameArray = url.split("/");
			this.name = nameArray[nameArray.length-1];
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		/*Download file*/
		InputStream in = null;
		OutputStream out = null;
		try {
			in = this.url.openStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out = new FileOutputStream(this.downloadDirectory+this.name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int c = 0;
		try {
			while ((c=in.read()) != -1) {
				out.write(c);
				bytesDownloaded++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Notify that file is done*/
		for (DownloadEventListener listener : listeners) {
			listener.DownloadFinished(this);
		}	
	}

	public void getStatus() {
		if (bytesDownloaded < 1000000) {
			System.out.println(this.name + ": " + bytesDownloaded/1000 + " kB");
		} else if (bytesDownloaded >= 1000000) {
			System.out.println(this.name + ": " + bytesDownloaded/1000000 + " mB");
		}
		
	}
	
	public void addDownloadListener(DownloadEventListener listener) {
		listeners.add(listener);
	}
	
	public URL getUrl() {
		return this.url;
	}
	
	public String getOutputName() {
		return this.name;
	}
}
