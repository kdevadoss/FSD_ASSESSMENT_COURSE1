package com.simplilearn.assessment.fsd_assessment_course1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class PrintAll {
	
	public void showAllfiles(String dir) {
		try {
			File folder = new File(dir);
			File[] listOfFiles = folder.listFiles();
			ArrayList<String> sortedFiles = new ArrayList<String>();

			System.out.println("Folder=" + dir);

			if (listOfFiles == null) {
				throw new InvalidFolderException();
			}

			System.out.println("Number of files=" + listOfFiles.length + "\n");

			// Stored all file names into a String Array List
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					sortedFiles.add(listOfFiles[i].getName() + "(F)");
				} else if (listOfFiles[i].isDirectory()) {
					sortedFiles.add(listOfFiles[i].getName() + "(D)");
				}

			}

			Collections.sort(sortedFiles, String.CASE_INSENSITIVE_ORDER);

			for (int i = 0; i < sortedFiles.size(); i++) {
				System.out.println(sortedFiles.get(i));

			}

		} catch (InvalidFolderException e) {
			System.out.println("\n!!!!!!Invalid Folder OR No files in the Folder!!!!!!");
		}
		//System.out.println("End of method");
	}

 
}
