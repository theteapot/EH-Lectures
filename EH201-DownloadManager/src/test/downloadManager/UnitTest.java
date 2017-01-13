package test.downloadManager;

import org.junit.Assert;
import org.junit.Test;

import downloadManager.Download;

public class UnitTest {
	
	@Test
	public void testFileName() {
		Download testDownload = new Download("http://www.templeos.org/TempleOSCD.ISO", "/home/tkettle/downloads/");
		Assert.assertEquals("TempleOSCD.ISO", testDownload.getOutputName());
		testDownload = new Download("https://download.fedoraproject.org/pub/fedora/linux/releases/25/Spins/i386/iso/Fedora-KDE-Live-i386-25-1.3.iso", "/home/tkettle/downloads/");
		Assert.assertEquals("Fedora-KDE-Live-i386-25-1.3.iso", testDownload.getOutputName());
		
	}

}
