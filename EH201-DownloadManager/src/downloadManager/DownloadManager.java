package downloadManager;

import java.util.ArrayList;

public class DownloadManager implements DownloadEventListener {

	ArrayList<Download> activeDownloads = new ArrayList<Download>();
	
	@Override
	public void DownloadFinished(Download download) {
		System.out.println("Download finished, " + download.getUrl().toString());	
		activeDownloads.remove(download);
	}
	
	public void addActiveDownload(Download download) {
		this.activeDownloads.add(download);
	}
	
	public void getDownloadStatus() {
		for (Download download : activeDownloads) {
			download.getStatus();
		}
	}
	
	public void close() {
		
	}

}
