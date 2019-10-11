package Report;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ScreenShot {

	
	
	public static String takeScreenShot(String NomRep,String NombImag) {
		
		BufferedImage screenShot;
		String dir = "images\\"; 
		
		
		try {
			
			screenShot = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			dir  = dir + NomRep + "\\";
			File directory = new File (dir);
			directory.mkdir();
			File file = new File(dir + NombImag + ".png");
			
			try {
				ImageIO.write(screenShot, "png", file);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return System.getProperty("user.dir") + "\\" + dir + NombImag + ".png";
		
	}
	
}
