package downloadManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Download extends Thread {
	List<DownloadEventListener> listeners = new ArrayList<DownloadEventListener>();
	URL url; 
	String name;
	float bytesDownloaded = 0;
	String downloadDirectory;
	InputStream in = null;
	OutputStream out = null;
	volatile boolean stop = false;
	
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
		System.out.println("Initialised download: " + this.name);
		
	}
	
	public void run() {
		System.out.println("Now starting: " + this.name);
		/*Download file*/
		try {
			in = this.url.openStream();
			out = new FileOutputStream(this.downloadDirectory+this.name);
		} catch (IOException u) {
			// TODO Auto-generated catch block
			u.printStackTrace();
		}
		int c = 0;
		try {
			while ((c=in.read()) != -1 && (!stop)) {
				out.write(c);
				bytesDownloaded++;
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Output stream closed");
		}
		//Deletes partially downloaded file if stopped by exit
		if (stop) {
			System.out.println("Stopped: " + this.name);
			Path downloadPath = Paths.get(this.downloadDirectory, this.name);
			try {
				System.out.println("Deleting: " + downloadPath.toString());
				Files.delete(downloadPath);
				for (DownloadEventListener listener : listeners) {
					listener.DownloadFinished(this);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			/*Notify that file is done*/
			for (DownloadEventListener listener : listeners) {
				listener.DownloadFinished(this);
			}	
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
	
	public void shutDown(){
		this.stop = true;		
	}
}
