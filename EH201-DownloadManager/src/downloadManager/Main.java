package downloadManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		DownloadManager downloadManager = new DownloadManager();
		//If started with commandline URL start that download
		if (args != null) {
			
		}
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Get users download directory
	    System.out.print("Enter default downloads directory: ");
	    String downloadDirectory = null;
	    try {
			downloadDirectory = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			String input = null;
			
			try {
				input = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (input.matches("http[s]*://.*")) {
				Download download = new Download(input, downloadDirectory);
				download.addDownloadListener(downloadManager);
				downloadManager.addActiveDownload(download);
				download.start();
			} else if (input.matches("info")) {
				downloadManager.getDownloadStatus();
			} else if (input.matches("exit")) {
				downloadManager.close();
			}
			
		}
		
	}

}
