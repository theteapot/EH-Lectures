package downloadManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args) {
		DownloadManager downloadManager = new DownloadManager();
		Executor pool = Executors.newFixedThreadPool(5);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String downloadDirectory = null;
	    
		//If started with argument URL start that download
		if (args != null) {
			
		}
		
		//Get users download directory
	    downloadDirectory = downloadManager.getDownloadDirectory();
	    System.out.println("Download directory: " + downloadDirectory);
	    
	    //Entering main user loop
		while (true) {
			String input = null;
			
			try {
				input = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (input.matches("(http|file)[s]*://.*")) {
				Download download = new Download(input, downloadDirectory);
				pool.execute(download);
				download.addDownloadListener(downloadManager);
				downloadManager.addActiveDownload(download);
			} else if (input.matches("info")) {
				downloadManager.getDownloadStatus();
			} else if (input.matches("exit")) {
				downloadManager.close();
			} else if (input.split(" ")[0].matches("cancel")) {
				int index = Integer.parseInt(input.split(" ")[1]);
				downloadManager.cancelDownload(index);
			}
			
		}
		
	}

}
