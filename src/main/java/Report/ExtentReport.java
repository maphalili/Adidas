package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	ExtentHtmlReporter HtmlReporter;
	ExtentReports reporte;
	String NomRep;
	ExtentTest test;
	
	public ExtentReport ( String NomRepor) {
		NomRep = NomRepor;
		AdminFiles.deleteAllFilesInDirectory("images\\" + NomRepor);
		AdminFiles.deleteDir("/reportesHtml/" + NomRepor + ".html");
		HtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\reportesHtml\\"+ NomRepor +".html");
		reporte = new ExtentReports();
		reporte.attachReporter(HtmlReporter);
		
	}
	
	public void createtest (String nombretest) {
		test = reporte.createTest(nombretest);
	}
		
	
	public void testPassed (String mensaje, String namePhoto) {
		String path = ScreenShot.takeScreenShot(NomRep,namePhoto);
		try {
			test.pass(mensaje,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void testfail(String mensaje, String namePhoto) {
		String path = ScreenShot.takeScreenShot(NomRep,namePhoto);
		try {
			test.fail(mensaje,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void createReporter() {
		reporte.flush();
	}
	
	
}
