package climatechange;

import java.util.*;

public class ClimateAnalyzer extends WeatherIO implements IClimateAnalyzer {


	// ctor
	public ClimateAnalyzer() { 
		
	}
	
	// Finds the lowest temperature entry by the specified country and month
	public ITemperature getLowestTempByMonth(String country, int month) {
		// TASK A-1
		// for all data that matches the specified month, get the lowest temperature reading
		
		// place holder variables for Temperature object
		double temp = 0;
		int year = 0;
		String mon = null, coun = null, countryCode = null;
		
		//int actualMonth = month - 1;
		String monthNeeded;
		
		// month array to compare month in data file
		String[] monthArray = {"Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
			
		// getting the index of the month in the array to compare it to user input month
		monthNeeded = monthArray[month-1];
		
		// load file data into arrayList
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		
		// create Temperature object to hold the desired object
		ITemperature lowestTemp = new Temperature(temp, year, mon, coun, countryCode);
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		// treeSet containg objects with matching country and month
		TreeSet<ITemperature> refinedSet = new TreeSet<ITemperature>();
				
		// add Temperature objects to treeSet
		for(ITemperature obj : dataSet) {
			
			dataSet.add(obj);
			
			// add object to refined Set if month and country match
			if(obj.getCountry().equals(country)) {
				if(obj.getMonth().equals(monthNeeded)) {
				
						
					refinedSet.add(obj);
				}
				
			}
										
		}
		
		// object with lowest temperature is stored first in the TreeSet because TreeSets are ordered
		lowestTemp = refinedSet.first();
		
		return lowestTemp;
	}

	// Finds the highest temperature entry by the specified country and month
	public ITemperature getHighestTempByMonth(String country, int month) {
		 // TASK A-1
		 // for all data that matches the specified month, get the highest temperature reading
		// place holder variables for Temperature object
			double temp = 0;
			int year = 0;
			String mon = null, coun = null, countryCode = null;
			
			//int actualMonth = month - 1;
			String monthNeeded;
			
			// month array to compare month in data file
			String[] monthArray = {"Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
				
			// getting the index of the month in the array to compare it to user input month
			monthNeeded = monthArray[month-1];
			
			// load file data into arrayList
			String fileName = "data/world_temp_2000-2016.csv";
			WeatherIO weatherObj = new WeatherIO();
			ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
			
			// create Temperature object to hold the desired object
			ITemperature highestTemp = new Temperature(temp, year, mon, coun, countryCode);
			
			//store data arrayList in treeSet
			TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
			// treeSet containg objects with matching country and month
			TreeSet<ITemperature> refinedSet = new TreeSet<ITemperature>();
					
			// add Temperature objects to treeSet
			for(ITemperature obj : dataSet) {
				
				dataSet.add(obj);
				
				// add object to refined Set if month and country match
				if(obj.getCountry().equals(country)) {
					if(obj.getMonth().equals(monthNeeded)) {
					
							
						refinedSet.add(obj);
					}
					
				}
											
			}
			
			// object with lowest temperature is stored first in the TreeSet because TreeSets are ordered
			highestTemp = refinedSet.last();
			
			return highestTemp;
	
	}

	// finds the lowest temperature entry by specified country and year
	public ITemperature getLowestTempByYear(String country, int year) {
		// TASK A-2
		// for all data that matches the specified year, get the lowest temperature reading
		double temp = 0;
		int objYear = 0;
		String mon = null, coun = null, countryCode = null;
		
		// load file data into arrayList
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		
		// create Temperature object to hold the desired object
		ITemperature lowestTemp = new Temperature(temp, objYear, mon, coun, countryCode);
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		// treeSet containg objects with matching country and month
		TreeSet<ITemperature> refinedSet = new TreeSet<ITemperature>();
				
		// add Temperature objects to treeSet
		for(ITemperature obj : dataSet) {
			
			dataSet.add(obj);
			
			// add object to refined Set if month and country match
			if(obj.getCountry().equals(country)) {
				if(obj.getYear() == year) {
				
						
					refinedSet.add(obj);
				}
				
			}
										
		}
		
		// object with lowest temperature is stored first in the TreeSet because TreeSets are ordered
		lowestTemp = refinedSet.first();
		
		return lowestTemp;

	}

	// finds the highest temperature entry by the specified country and year
	public ITemperature getHighestTempByYear(String country, int year) {
		// TASK A-2
		// for all data that matches the specified year, get the highest temperature reading
		double temp = 0;
		int objYear = 0;
		String mon = null, coun = null, countryCode = null;
		
		// load file data into arrayList
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		
		// create Temperature object to hold the desired object
		ITemperature highestTemp = new Temperature(temp, objYear, mon, coun, countryCode);
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		// treeSet containg objects with matching country and month
		TreeSet<ITemperature> refinedSet = new TreeSet<ITemperature>();
				
		// add Temperature objects to treeSet
		for(ITemperature obj : dataSet) {
			
			dataSet.add(obj);
			
			// add object to refined Set if month and country match
			if(obj.getCountry().equals(country)) {
				if(obj.getYear() == year) {
				
						
					refinedSet.add(obj);
				}
				
			}
										
		}
		
		// object with lowest temperature is stored first in the TreeSet because TreeSets are ordered
		highestTemp = refinedSet.last();
		
		return highestTemp;
	}

	// finds all temperature entries of the specified country between a certain temp range
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp) {
		// TASK A-3
		// get all temperature data that fall within the given temperature range
		// the set is sorted from lowest to highest temperature
		// input parameter values are in Celsius
		
		
		// load file data into arrayList
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		// treeSet containg objects with matching country and month
		TreeSet<ITemperature> refinedSet = new TreeSet<ITemperature>();
		
		// add Temperature objects to treeSet
		for(ITemperature obj : dataSet){
			
			dataSet.add(obj);
			
			// add object to refined Set if month and country match
			if(obj.getCountry().equals(country)) {
				if(obj.getTemperature(false) >= rangeLowTemp && obj.getTemperature(false) <= rangeHighTemp) {
								
					refinedSet.add(obj);
				}
				
			}
										
		}
				
		return refinedSet;
	}

	// Finds the temperature entry with the lowest temp of specified country
	public ITemperature getLowestTempYearByCountry(String country) {
		// TASK A-4
		// 1. get the lowest temperature reading amongst all data for that country
		
		double temp = 0;
		int objYear = 0;
		String mon = null, coun = null, countryCode = null;
		
		// load file data into arrayList
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		
		// create Temperature object to hold the desired object
		ITemperature lowestTemp = new Temperature(temp, objYear, mon, coun, countryCode);
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		// treeSet containg objects with matching country and month
		TreeSet<ITemperature> refinedSet = new TreeSet<ITemperature>();
				
		// add Temperature objects to treeSet
		for(ITemperature obj : dataSet) {
			
			dataSet.add(obj);
			
			// add object to refined Set if month and country match
			if(obj.getCountry().equals(country)) {
				
						
					refinedSet.add(obj);
				}									
		}
		
		// object with lowest temperature is stored first in the TreeSet because TreeSets are ordered
		lowestTemp = refinedSet.first();
		
		return lowestTemp;
	}

	// Finds the temperature entry with the highest temp of specified country
	public ITemperature getHighestTempYearByCountry(String country) {
		// TASK A-4
		// 1. get the highest temperature reading amongst all data for that country
		double temp = 0;
		int objYear = 0;
		String mon = null, coun = null, countryCode = null;
		
		// load file data into arrayList
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		
		// create Temperature object to hold the desired object
		ITemperature highestTemp = new Temperature(temp, objYear, mon, coun, countryCode);
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		// treeSet containg objects with matching country and month
		TreeSet<ITemperature> refinedSet = new TreeSet<ITemperature>();
				
		// add Temperature objects to treeSet
		for(ITemperature obj : dataSet) {
			
			dataSet.add(obj);
			
			// add object to refined Set if month and country match
			if(obj.getCountry().equals(country)) {
				
						
					refinedSet.add(obj);
				}									
		}
		
		// object with lowest temperature is stored first in the TreeSet because TreeSets are ordered
		highestTemp = refinedSet.last();
		
		return highestTemp;
	}

	// finds the countries with the top 10 lowest temperatures in a specified month
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) {
		// TASK B-1
		// 1. the return list is sorted from lowest to highest temperature
		
		// load file data into arrayList
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		ArrayList<String> countryNames = new ArrayList<String>();
		ArrayList<ITemperature> top10Lowest = new ArrayList<ITemperature>();
		
		String monthNeeded;
		
		// month array to compare month in data file
		String[] monthArray = {"Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
			
		// getting the index of the month in the array to compare it to user input month
		monthNeeded = monthArray[month-1];
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
				
		// add Temperature objects to treeSet
		for(ITemperature obj : dataSet) {
			
			dataSet.add(obj);
			
			if(top10Lowest.size() < 10 && !countryNames.contains(obj.getCountry()) && obj.getMonth().equals(monthNeeded)) {
				top10Lowest.add(obj);
				countryNames.add(obj.getCountry());
							
			}
				
							
		}
		
		return top10Lowest;
	}

	// finds the countries with the top 10 highest temperatures in a specified month
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) {
		// TASK B-1
		// 1. the return list is sorted from lowest to highest temperature
		// load file data into arrayList
		
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		ArrayList<String> countryNames = new ArrayList<String>();
		ArrayList<ITemperature> top10Highest = new ArrayList<ITemperature>();
		
		String monthNeeded;
		
		// month array to compare month in data file
		String[] monthArray = {"Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
			
		// getting the index of the month in the array to compare it to user input month
		monthNeeded = monthArray[month-1];
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		TreeSet<ITemperature> reverseSet = (TreeSet<ITemperature>)dataSet.descendingSet();
				
		// add Temperature objects to treeSet
		for(ITemperature obj : reverseSet) {
					
			dataSet.add(obj);
			
			if(top10Highest.size() < 10 && !countryNames.contains(obj.getCountry()) && obj.getMonth().equals(monthNeeded)) {
				top10Highest.add(obj);
				countryNames.add(obj.getCountry());
							
			}
				
							
		}
		
		return top10Highest;
	}

	// finds the top 10 lowest temperatures of all countries in data 
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() {
		// TASK B-2
		// 1. the return list is sorted from lowest to highest temperature
		// load file data into arrayList
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		ArrayList<String> countryNames = new ArrayList<String>();
		ArrayList<ITemperature> top10Lowest = new ArrayList<ITemperature>();
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
				
		// add Temperature objects to treeSet
		for(ITemperature obj : dataSet) {
			dataSet.add(obj);
						
			if(top10Lowest.size() < 10 && !countryNames.contains(obj.getCountry())) {
				top10Lowest.add(obj);
				countryNames.add(obj.getCountry());
							
			}
				
							
		}
		
		return top10Lowest;
	}

	// finds the top 10 highest temperatures of all countries in data 
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() {
		// TASK B-2
		// 1. the return list is sorted from lowest to highest temperature

		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		ArrayList<String> countryNames = new ArrayList<String>();
		ArrayList<ITemperature> top10Highest = new ArrayList<ITemperature>();
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		TreeSet<ITemperature> reverseSet = (TreeSet<ITemperature>)dataSet.descendingSet();
				
		// add Temperature objects to treeSet
		for(ITemperature obj : reverseSet) {
			reverseSet.add(obj);
			
			
			
			if(top10Highest.size() < 10 && !countryNames.contains(obj.getCountry())) {
				top10Highest.add(obj);
				countryNames.add(obj.getCountry());
							
			}
				
							
		}
		
		return top10Highest;
	}

	// Finds all temperatures withing a specified range
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp) {
		// TASK B-3
		// 1. the return list is sorted from lowest to highest temperature
		// load file data into arrayList
				String fileName = "data/world_temp_2000-2016.csv";
				WeatherIO weatherObj = new WeatherIO();
				ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
				
				//store data arrayList in treeSet
				TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
				// treeSet containg objects with matching country and month
				ArrayList<ITemperature> refinedList = new ArrayList<ITemperature>();
				
				// add Temperature objects to treeSet
				for(ITemperature obj : dataSet){
					dataSet.add(obj);
					
				// add object to refined Set if month and country match
					if(obj.getTemperature(false) >= lowRangeTemp && obj.getTemperature(false) <= highRangeTemp) {
									
						refinedList.add(obj);
					}
					
				}
														
			return refinedList;
	}

	//Finds the top 10 countries with the highest change in temp from year1 to year2
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) {
		// TASK C-1
		// 1. the countries with the largest temperature differences (absolute value) of the same month between 2 given years.
		// 2. the return list is sorted from lowest to highest temperature delta
		// load file data into arrayList
		double temp = 0;
		String mon = null, coun = null, countryCode = null;
		double tempDelta = 0;
		
		String monthNeeded;
		
		// month array to compare month in data file
		String[] monthArray = {"Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
			
		// getting the index of the month in the array to compare it to user input month
		monthNeeded = monthArray[month-1];
		
		// create Temperature object to hold the desired object
		ITemperature tempObj1 = new Temperature(temp, year1, mon, coun, countryCode);
		ITemperature tempObj2 = new Temperature(temp, year2, mon, coun, countryCode);
		
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		ArrayList<String> countryNames = new ArrayList<String>();
		ArrayList<ITemperature> top10Delta = new ArrayList<ITemperature>();
		ArrayList<ITemperature> tempList1 = new ArrayList<ITemperature>();
		ArrayList<ITemperature> tempList2 = new ArrayList<ITemperature>();
		
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		TreeSet<ITemperature> refinedSet = new TreeSet<ITemperature>();
				
		// add Temperature objects to treeSet
		for(ITemperature obj : dataSet) {
			dataSet.add(obj);
			
			if(obj.getYear() == year1 && obj.getMonth().equals(monthNeeded)) {
				tempList1.add(obj);
			}
			if(obj.getYear() == year2 && obj.getMonth().equals((monthNeeded))) {
				tempList2.add(obj);
			}
									
		}
		
		for(int i = 0; i < tempList1.size(); i++) {
			 if(tempList1.get(i).getCountry().equals(tempList2.get(i).getCountry())){
				 
				 refinedSet.add(tempList1.get(i));
			 }
			
		}
		
		for(ITemperature obj : refinedSet) {
			if(top10Delta.size() < 10 && !countryNames.contains(obj.getCountry())) {
				top10Delta.add(obj);
				countryNames.add(obj.getCountry());
							
			}
		}
		
	
		
		return top10Delta;
	}
	
	public boolean isValidCountry(String country) {
	
		String fileName = "data/world_temp_2000-2016.csv";
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
	
		
		//store data arrayList in treeSet
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>(tempArray);
		HashSet<String> countries = new HashSet<String>();
		
		for(ITemperature obj : dataSet){
			countries.add(obj.getCountry());
			
		}
		
		//System.out.println(countries.size());
		
		if(countries.contains(country)) {
			return true;
		}
		else {
			return false;
		}
		
	
	}
	
	public boolean isValidMonth(int month) {
		
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		intArr.add(1);
		intArr.add(2);
		intArr.add(3);
		intArr.add(4);
		intArr.add(5);
		intArr.add(6);
		intArr.add(7);
		intArr.add(8);
		intArr.add(9);
		intArr.add(10);
		intArr.add(11);
		intArr.add(12);
		
		if(intArr.contains(month))
			return true;
		else	
			return false;
	}
	
public boolean isValidYear(int year) {
		
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		intArr.add(2000);
		intArr.add(2001);
		intArr.add(2002);
		intArr.add(2003);
		intArr.add(2004);
		intArr.add(2005);
		intArr.add(2006);
		intArr.add(2007);
		intArr.add(2009);
		intArr.add(2010);
		intArr.add(2011);
		intArr.add(2012);
		intArr.add(2013);
		intArr.add(2014);
		intArr.add(2015);
		intArr.add(2016);
		
		if(intArr.contains(year))
			return true;
		else	
			return false;
	}

	@Override
	public void runClimateAnalyzer() {
		// 1. This method starts the climate-change task activities
		// 2. The ClimateChange methods must be called in the order as listed in the [description section], (first with the Task A
		// methods, second are the Task B methods, and third are the Task C methods)
		// 3. For each of the ClimateChange methods that require input parameters, this method must ask the user to
		// enter the required information for each of the tasks.
		// 4. Each ClimateAnalyzer method returns data, so the data results must be written to data files 
		
String fileName = "data/world_temp_2000-2016.csv";
		
		ClimateAnalyzer ca = new ClimateAnalyzer();
		WeatherIO weatherObj = new WeatherIO();
		ArrayList<ITemperature> tempArray = weatherObj.readDataFromFile(fileName);
		ArrayList<ITemperature> task = new ArrayList<ITemperature>();
		ArrayList<ITemperature> dataList = new ArrayList<ITemperature>();
		
		TreeSet<ITemperature> dataSet = new TreeSet<ITemperature>();
		String taskA1 = "A1";
		String taskA2 = "A2";
		String taskA3 = "A3";
		String taskA4 = "A4";
		String taskB1 = "B1";
		String taskB2 = "B2";
		String taskB3 = "B3";
		String taskC1 = "C1";
		
		
		Scanner in = new Scanner(System.in);
		
		// Task A1
		System.out.print("Task A1. Please enter the name of a country: ");
		String country = in.nextLine();
		while(!ca.isValidCountry(country)) {
			
			System.out.println("Please enter a valid country: ");
			country = in.nextLine();
		}
		
		System.out.print("Please enter the number for a month(1-12): ");
		int monthA1 = in.nextInt();
		in.nextLine();
		while(!ca.isValidMonth(monthA1)) {
			
			System.out.println("Please enter a valid month(1-12: ");
			monthA1 = in.nextInt();
		}
		
	
		task.add(ca.getLowestTempByMonth(country, monthA1));
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskA1+"_climate_info.csv", "Task A1: Lowest temperature in "+country
				+" for the month of "+monthA1);
		weatherObj.writeDataToFile("data/task"+taskA1+"_climate_info.csv", " ", task);
		System.out.println();
		
		task.clear();
		System.out.println();

		task.add(ca.getHighestTempByMonth(country, monthA1));
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskA1+"_climate_info.csv", "Task A1: Highest temperature in "+country
			+" for the month of "+monthA1);
		weatherObj.writeDataToFile("data/task"+taskA1+"_climate_info.csv", " ", task);
		System.out.println();
		
		task.clear();
		
		
		// Task A2
		System.out.print("Task A2. Please enter the name of a country: ");
		String countryA2 = in.nextLine();
		while(!ca.isValidCountry(countryA2)) {
			
			System.out.println("Please enter a valid country: ");
			countryA2 = in.nextLine();
		}
		
	
		System.out.print("Please enter the desired year: ");
		int yearA2 = in.nextInt();
		while(!ca.isValidYear(yearA2)) {
			
			System.out.println("Please enter a valid year(2000-2016): ");
			yearA2 = in.nextInt();
		}
		in.nextLine();
			
		task.add(ca.getLowestTempByYear(countryA2, yearA2));
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskA2+"_climate_info.csv", "Task A2: Lowest temperature in "+countryA2
				+" for the year of "+yearA2);
		weatherObj.writeDataToFile("data/task"+taskA2+"_climate_info.csv", " ", task);
		
		task.clear();
		
		task.add(ca.getHighestTempByYear(country, yearA2));
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskA2+"_climate_info.csv", "Task A2: Highest temperature in "+countryA2
				+" for the year of "+yearA2);
		weatherObj.writeDataToFile("data/task"+taskA2+"_climate_info.csv", " ", task);
		System.out.println();
		
		task.clear();
		
		//Task A3
		
		System.out.print("Task A3. Please enter the name of a country: ");
		String countryA3 = in.nextLine();
		while(!ca.isValidCountry(countryA3)) {
			
			System.out.println("Please enter a valid country: ");
			countryA3 = in.nextLine();
		}
		
		System.out.print("Please enter the low bound for temperature(C): ");
		int rangeLowTemp = in.nextInt();
		in.nextLine();
		System.out.print("Please enter the high bound for temperature(C): ");
		int rangeHighTemp = in.nextInt();
		in.nextLine();
		
		
		dataSet  = ca.getTempWithinRange(countryA3, rangeLowTemp, rangeHighTemp);
		dataList = new ArrayList<ITemperature>(dataSet);
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskA3+"_climate_info.csv", "Task A3: Temperature for "+countryA3
				+" within temperature range "+rangeLowTemp+"-"+rangeHighTemp);
		weatherObj.writeDataToFile("data/task"+taskA3+"_climate_info.csv", " ", dataList);
		System.out.println();
		
		task.clear();
		
		// Task A4
		System.out.print("Task A4. Please enter the name of a country: ");
		String countryA4 = in.nextLine();
		while(!ca.isValidCountry(countryA4)) {
			
			System.out.println("Please enter a valid country: ");
			countryA4 = in.nextLine();
		}
		
		task.add(ca.getLowestTempYearByCountry(countryA4));
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskA4+"_climate_info.csv", "Task A4: Lowest temperature in "+countryA4+": ");
		weatherObj.writeDataToFile("data/task"+taskA4+"_climate_info.csv", " ", task);
		System.out.println();
		
		task.clear();
		
		task.add(ca.getHighestTempYearByCountry(countryA4));
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskA4+"_climate_info.csv", "Task A4: Highest temperature in "+country+": ");
		weatherObj.writeDataToFile("data/task"+taskA4+"_climate_info.csv", " ", task);
		System.out.println();
		
		task.clear();
		
		// Task B1
		System.out.print("Task B1. Please enter the number for a month(1-12): ");
		int monthB1 = in.nextInt();
		while(!ca.isValidMonth(monthB1)) {
			
			System.out.println("Please enter a valid month(1-12): ");
			monthB1 = in.nextInt();
		}
		in.hasNextLine();
		in.nextLine();
		
		dataList = ca.allCountriesGetTop10LowestTemp(monthB1);
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskB1+"_climate_info.csv", "Task B1: Countries with top 10 lowest temperatures in month "+monthB1+": ");
		weatherObj.writeDataToFile("data/task"+taskB1+"_climate_info.csv", " ", dataList);
		System.out.println();
		
		dataList.clear();
		
		// Task B1
		dataList = ca.allCountriesGetTop10HighestTemp(monthB1);
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskB1+"_climate_info.csv", "Task B1: Countries with top 10 highest temperatures in month "+monthB1+": ");
		weatherObj.writeDataToFile("data/task"+taskB1+"_climate_info.csv", " ", dataList);
		System.out.println();
		
		dataList.clear();
		
		// Task B2
		dataList = ca.allCountriesGetTop10LowestTemp();
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskB2+"_climate_info.csv", "Task B2: Countries with top 10 lowest temperatures: ");
		weatherObj.writeDataToFile("data/task"+taskB2+"_climate_info.csv", " ", dataList);
		System.out.println();
		System.out.println();
		
		dataList.clear();
		
		// Task B2
		dataList = ca.allCountriesGetTop10HighestTemp();
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskB2+"_climate_info.csv", "Task B2: Countries with top 10 highest temperatures: ");
		weatherObj.writeDataToFile("data/task"+taskB2+"_climate_info.csv", " ", dataList);
		System.out.println();
		
		dataList.clear();
		
		// Task B3

		System.out.print("Task B3. Please enter the low bound for temperature: ");
		 rangeLowTemp = in.nextInt();
		in.nextLine();
		System.out.print("Please enter the high bound for temperature: ");
		 rangeHighTemp = in.nextInt();
		in.nextLine();
		
		dataList = ca.allCountriesGetAllDataWithinTempRange(rangeLowTemp, rangeHighTemp);
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskB3+"_climate_info.csv", "Task B3: Countries with tempertatures that fall within the range "
				+rangeLowTemp+"-"+rangeHighTemp+": ");
		weatherObj.writeDataToFile("data/task"+taskB3+"_climate_info.csv", " ", dataList);
		System.out.println();
		
		dataList.clear();
		
		// Task C1
		System.out.print("Task C1. Please enter the number for a month(1-12): ");
		int monthC1 = in.nextInt();
		while(!ca.isValidMonth(monthC1)) {
			
			System.out.println("Please enter a valid month(1-12): ");
			monthC1 = in.nextInt();
		}
		in.hasNextLine();
		in.nextLine();
		System.out.print("Please enter the first year: ");
		int year1 = in.nextInt();
		while(!ca.isValidYear(year1)) {
			
			System.out.println("Please enter a valid year(2000-2016): ");
			year1 = in.nextInt();
		}
		in.nextLine();
		System.out.print("Please enter the second year: ");
		int year2 = in.nextInt();
		while(!ca.isValidYear(year2)) {
			
			System.out.println("Please enter a valid year(2000-2016): ");
			year1 = in.nextInt();
		}
		in.nextLine();
		
		dataList = ca.allCountriesTop10TempDelta(monthC1, year1, year2);	
		
		weatherObj.writeSubjectHeaderInFile("data/task"+taskC1+"_climate_info.csv", "Task C1: Countries with top 10 highest delta temp");
		weatherObj.writeDataToFile("data/task"+taskC1+"_climate_info.csv", " ", dataList);
		System.out.println();
		
		
		System.out.println("done");
		
		

		
	}
	

	
}
