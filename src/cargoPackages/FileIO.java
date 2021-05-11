package cargoPackages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO{
	


	// this method read the file and assign the items to arraylist as a string
	public static ArrayList<String> readFile() throws IOException{
		String fileName = "HW3_PackagesToAccept.csv";
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		ArrayList<String> items = new ArrayList<String>(); 
		String line = null;
		line = reader.readLine();
		while(line!=null)
		{
			items.add(line);
			line = reader.readLine();
		}
		return items; // items arraylist includes all items for all lines as a string
	}
	
	// this method is created that can take number of column and row of NormalCargoArray and EcommerceCargoArray 
	public static Integer[][] ColsRowsOfArrays() throws IOException{
		ArrayList<String> items = readFile();
		Integer[][] ColsRowsArray = new Integer[2][2];
		String line = null;
		String[] splitItems = null;
		int numberOfNormalCols = 0;
		int numberOfNormalRows = 0;
		int numberOfEcommerceCols = 0;
		int numberOfEcommerceRows = 0;
		for(int i=0; i<items.size(); i++)
		{
			line = items.get(i);
			splitItems = line.split(";");
			// this code delete the hidden characters of first element in all lines
			String firstItem = splitItems[0].replaceAll("[\uFEff-\uFFFF]","");
			splitItems[0] = firstItem;	// after deleting, first index that is not include hidden characters assign to splitItem
			
			if(firstItem.equals("Normal"))
			{
				numberOfNormalCols+=1;		// number of lines of Normal package 
				numberOfNormalRows = splitItems.length;		// number of attributes of normal package
			}
			else {
				numberOfEcommerceCols+=1;	// number of lines of Ecommerce package 
				numberOfEcommerceRows = splitItems.length;	// number of attributes of ecommerce package
			}
		}
		// number of lines and attributes store in ColsRowsArray to use creating an Array of Normal and Ecommerce
		ColsRowsArray [0][0] = numberOfNormalCols;
		ColsRowsArray [0][1] = numberOfNormalRows;
		ColsRowsArray [1][0] = numberOfEcommerceCols;
		ColsRowsArray [1][1] = numberOfEcommerceRows;
		
		return ColsRowsArray;
	}

	public static String[][] NormalCargoItems() throws IOException {
		
		String[][] NormalCargoArray = new String[ColsRowsOfArrays()[0][0]][ColsRowsOfArrays()[0][1]];
		String line = null;
		String[] splitItems = null;
		int numberOfLine = 0;
		for(int i=0; i<readFile().size(); i++)
		{
			line = readFile().get(i); //All lines in items ArrayList assigns to line.
			splitItems = line.split(";"); // Split line as ";"
			String firstItem = splitItems[0].replaceAll("[\uFEff-\uFFFF]",""); // Delete all hidden characters
			splitItems[0] = firstItem; 	
			if(firstItem.equals("Normal")) // All items that have Normal type assigns to NormalCargoArray 
			{
				for(int j=0; j<splitItems.length; j++)
				{
					NormalCargoArray[numberOfLine][j] = splitItems[j];
				}
				numberOfLine++;
			}
		}

		return NormalCargoArray;
		
	}
	
	public static String[][] EcommerceCargoItems() throws IOException {
		String line = null;
		String[] splitItems = null;
		String[][] EcommerceCargoArray = new String[ColsRowsOfArrays()[1][0]][ColsRowsOfArrays()[1][1]];
		int numberOfLine = 0;
		for(int i=0; i<readFile().size(); i++)
		{
			line = readFile().get(i); //All lines in items ArrayList assigns to line.
			splitItems = line.split(";"); // Split line as ";"
			String firstItem = splitItems[0].replaceAll("[\uFEff-\uFFFF]",""); // Delete all hidden characters
			splitItems[0] = firstItem;
			if(firstItem.equals("Ecommerce")) // All items that have Ecommerce type assigns to EcommerceCargoArray 
			{
				for(int j=0; j<splitItems.length; j++)
				{
					EcommerceCargoArray[numberOfLine][j] = splitItems[j];
				}
				numberOfLine++;
			}
		}

		return EcommerceCargoArray;
		
	}




}
