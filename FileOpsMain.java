package com.simplilearn.assessment.fsd_assessment_course1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOpsMain {
	
	int selectedOpn = 0;
	util utility = new util();
	String defdir;
	String fileName;
	
	public FileOpsMain(String defaultDir) {
		super();
		this.defdir = defaultDir;
	}
	
	public void fileOp() {
		Scanner fileopchoice = new Scanner(System.in);
		int selectedOption = 0;
		while (selectedOption != 4) {

			utility.clear();
			System.out.println("************** Option 2 : File Operations Selected **************");
			System.out.println("Select from below Options...");
			System.out.println("1. Add file to the directory");
			System.out.println("2. Delete file from the directory");
			System.out.println("3. Search for a file in the directory");
			System.out.println("4. Return to main Menu");
			try {
				selectedOption = fileopchoice.nextInt();

				if (selectedOption < 1 || selectedOption > 4) {
					throw new InvalidOptionException(selectedOption);

				}
			} catch (InvalidOptionException e) {
				System.out.println("Invalid Option Selected...Press Enter to retry");
				fileopchoice.nextLine();
				fileopchoice.nextLine();

			}
			switch (selectedOption) {
			case 1: // Add file to the directory
				addFiles(defdir);
				break;

			case 2: // Delete File from directory
				deleteFile(defdir);
				break;

			case 3: // Search File
				searchFile(defdir);
				break;
			case 4: // Return to main menu
				System.out.println("Going back to main Menu... Press Enter to continue");
				fileopchoice.nextLine();
				fileopchoice.nextLine();
				break;
			}

		}
	}
	
	public void addFiles(String defaultDir) {
		System.out.println("\nEnter File name to be created under ..."+defaultDir);
		Scanner newfileName = new Scanner(System.in);
		fileName = newfileName.next();
		//fileName = defaultDir + "\\" + fileName;
		fileName = defaultDir  + fileName;
		System.out.println("Creating file = " + fileName);
		File newFile = new File(fileName);
		try {
			if (newFile.createNewFile()) {
				System.out.println("\n File successfully Created");
			} else {
				System.out.println("File Already exists. Provide a different filename");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newfileName.nextLine();
		newfileName.nextLine();
	}
	
	public void deleteFile(String defaultDir) {
		System.out.println("Enter File Name to be deleted...");
		Scanner delFilescr = new Scanner(System.in);
		fileName = delFilescr.next();
		fileName = defaultDir  + fileName;
		
		System.out.println("File to be deleted is "+fileName);
				
		File delFile = new File(fileName);
		if (!delFile.exists()) {
			System.out.println("Specified file does not exist. Press Enter to choose again and enter a valid file Name");
			delFilescr.nextLine();
			delFilescr.nextLine();

		} else if (delFile.isDirectory()) {
			System.out.println(
					"Specified filename is a Folder. Cannot delete a folder.. Press Enter to chose again and enter a valid file Name");
			delFilescr.nextLine();
			delFilescr.nextLine();
			return;
		}

		else {
			System.out.println("Deleting File : " + fileName);
			delFile.delete();
			System.out.println("Successfully Deleted File...Press Enter to continue");
			delFilescr.nextLine();
			delFilescr.nextLine();
			return;
		}
	}
	
	public void searchFile(String defaultDir) {
		System.out.println("Enter the file name to search...");
		Scanner srchscanner = new Scanner(System.in);
		fileName = srchscanner.next();
		fileName = defaultDir  + fileName;
		
		System.out.println("Search operation to be carried out for ."+fileName);

		File searchFile = new File(fileName);
		
		if (searchFile.exists()) {
			System.out.println("\n\n File Found !!!");
			srchscanner.nextLine();
			srchscanner.nextLine();
		} else {
			System.out.println("\n\n File not Found.. Press Enter to Continue");
			srchscanner.nextLine();
			srchscanner.nextLine();
		}
	}



}
