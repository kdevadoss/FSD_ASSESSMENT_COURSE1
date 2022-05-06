package com.simplilearn.assessment.fsd_assessment_course1;

import java.io.IOException;
import java.util.Scanner;

public class ApplicationMainCls {

	public static void main(String[] args) throws InvalidOptionException {
		// TODO Auto-generated method stub
		Scanner mainSelection = new Scanner(System.in);
		int selectedOption = 0;
		util utility = new util();
		
		while (selectedOption != 3) {
			utility.clear();
			System.out.flush();  

			System.out.println("\t\t******************Welcome to Smart Locker Application******************");
			System.out.println("\t\t*                                      Developed by : Karthick devadoss *");
			System.out.println("\t\t*                                      Date:   02-May-2022 *");
			System.out.println("\t\t************************************************************");
			System.out.println("\n");
			System.out.println("Please select the Option from the below list to Proceed Further...\n");
			System.out.println("1. Print all files in ascending order\n");
			System.out.println("2. File Operations\n");
			System.out.println("3. Close\n");

			try {
				selectedOption = mainSelection.nextInt();

				if (selectedOption < 1 || selectedOption > 3) {
					throw new InvalidOptionException(selectedOption);

				}
			} catch (InvalidOptionException e) {
				System.out.println("Invalid Option Selected...Press Enter to select again");
				mainSelection.nextLine();
				mainSelection.nextLine();

			}
			
			switch (selectedOption) {
			case 1:
				PrintAll printAllFiles = new PrintAll(); 
				System.out.println("Option 1 selected");
				System.out.println("\nEnter Folder name Or Press enter for home Folder: \n");
				Scanner folderName = new Scanner(System.in);
				String folderNameSelected = folderName.nextLine();
				
				if(folderNameSelected.length() == 0) {
					
					folderNameSelected = "/home/kdevadossvmware/java_fsd_assessment/";
				}
				
			
				printAllFiles.showAllfiles(folderNameSelected);
				System.out.println("\nPress enter to continue...");
				mainSelection.nextLine();
				mainSelection.nextLine();
				break;
				
			case 2:
				System.out.println("\nEnter Folder name Or Press enter for home Folder: \n");
				Scanner folderName1 = new Scanner(System.in);
				String folderNameSelected1 = folderName1.nextLine();
				
				if(folderNameSelected1.length() == 0) {
					
					folderNameSelected1 = "/home/kdevadossvmware/java_fsd_assessment/";
				}
				FileOpsMain fileio = new FileOpsMain(folderNameSelected1);
				fileio.fileOp();
				
			case 3:
				System.out.println("Quitting Application. Thank you and have a great time!!!");
			}

		}

	}

}
