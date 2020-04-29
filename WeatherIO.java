package climatechange;

import java.io.*;
import java.util.*;

public class WeatherIO implements IWeatherIO{

	// private instance variable
	private ArrayList<ITemperature> tempArray;
	
	//ctor
	public WeatherIO() {
		tempArray = new ArrayList<ITemperature>();
		
	}
	
	// read the data from the csv file and store it in an arrayList
	public ArrayList<ITemperature> readDataFromFile(String fileName) {
		
		File dataFile = new File(fileName);
	
		try 
		{
			Scanner in = new Scanner(dataFile);
			// skip first line
			String throwAwayline = in.nextLine();
			
			// while not at the end of a file
			while(in.hasNext()) 
			{
				// save next line in file
				String line = in.nextLine();
				// seperate temp, year, month, country, and country code from line
				String[] lineComponents = line.split(", ");
				// create iTemperature objects made of each line in file
				ITemperature tempObj = new Temperature(Double.parseDouble(lineComponents[0]), Integer.parseInt(lineComponents[1]), 
						lineComponents[2], lineComponents[3], lineComponents[4]);
				// add each object to arrayList
				tempArray.add(tempObj);
			}
			
			// close scanner
			in.close();
			
		// catch file error
		} catch (FileNotFoundException e) {
			
			System.out.println("Unable to locate correct file");
		}
		
		return tempArray;
	}

	
	public void writeSubjectHeaderInFile(String filename, String subject){
		// 1. write the subject header before dumping data returned from each ClimateAnalyzer method
		
		// try block to catch exceptions 
		try {
			
			// create new file object
			File newFile = new File(filename);
			FileWriter fw = new FileWriter(newFile, true);
			PrintWriter pw = new PrintWriter(fw);
			
			// write subject of file at the top of the file
			pw.write(subject);
			pw.println();
			
			// 2. a subject header is to be written for each ClimateAnalyzer method call
			pw.write("Temperature, Year, Month, Country, Country_Code");
			pw.println();
			
			// close writers
			pw.close();
			fw.close();
			
			
		}catch(IOException e) {
			System.out.println("An error occured when creating the file.");
			
		}	
		
	}

	
	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) {
		
		//try/catch
		try {
			File newFile = new File(filename);
			FileWriter fw = new FileWriter(newFile,true);
			PrintWriter pw = new PrintWriter(fw);
			
			
			//print out array list
			for(int i = 0; i < theWeatherList.size(); i++) {
				pw.write(theWeatherList.get(i).toString());
				pw.println();
										

			}
			pw.println();	
			
			// close writer
			pw.close();
			fw.close();
			
		// catch exception
		}catch(IOException e) {
			System.out.println("File IO error");
		}	
		
	}
}
