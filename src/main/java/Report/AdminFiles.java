package Report;

import java.io.File;

public class AdminFiles {
	
	public static void deleteAllFilesInDirectory(String dir) {
		File directory = new File(dir);
		File[] files = directory.listFiles();
		try {
			
			for (int i = 0; i < files.length; i++) {
				files[i].delete();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	public static void deleteDir(String dir) {
		
		File directory = new File(dir); 
		if (directory.delete()) {
			System.out.println("Eliminacion exitosa de la carpeta" + dir);
		}
		
		
	}
	
}
