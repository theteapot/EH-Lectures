package downloadManager;

import java.io.File;
import java.util.ArrayList;

public class DownloadManager implements DownloadEventListener {

	ArrayList<Download> activeDownloads = new ArrayList<Download>();
	
	@Override
	public void DownloadFinished(Download download) {
		System.out.println("Download finished, " + download.getOutputName());	
		activeDownloads.remove(download);
	}
	
	public String getDownloadDirectory() {
		String homeDirectory = System.getProperty("user.home");
		String[] possibleOptions = {"downloads","Downloads","My Downloads"};
		for (String option : possibleOptions) {
			File possiblePath = new File(homeDirectory + "/" + option);
			if (possiblePath.exists()) {
				return homeDirectory + "/" + option + "/";
			}
		}
		return "No suitable directory found";
	}
	
	public void addActiveDownload(Download download) {
		this.activeDownloads.add(download);
	}
	
	public void getDownloadStatus() {
		int c = 0;
		for (Download download : activeDownloads) {
			System.out.print(c + " -- ");
			download.getStatus();
			c++;
		}
	}
	
	public void close() {
		for (Download download : activeDownloads) {
			download.shutDown();
			System.out.println("Closed: " + download.getOutputName());
		}
	}
	
	public void cancelDownload(int downloadIndex) {
		Download download = activeDownloads.get(downloadIndex);
		download.shutDown();
	}

}
