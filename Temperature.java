package climatechange;

import java.util.*;

public class Temperature implements ITemperature, Comparable<Temperature>{
	
	// private instance variables
	private String month, country, countryCode;
	private int year;
	private double temp;
	
	// ctor
	public Temperature(double temp, int year, String month, String country, String countryCode) {
		this.temp = temp;
		this.year = year;
		this.month = month;
		this.country = country;
		this.countryCode = countryCode;
	}

	// returns country
	public String getCountry() {
		
		return country;
	}

	// returns country 3 letter code
	public String getCountry3LetterCode() {
		
		return countryCode;
	}

	// returns month
	public String getMonth() {
	
		return month;
	}

	// returns year
	public int getYear() {
		
		return year;
	}

	// make object info readable
	public String toString() {
		return getTemperature(false) + "(C) " + getTemperature(true) + "(F)" + ", " + getYear() 
		+ ", " + getMonth() + ", " + getCountry() + ", " + getCountry3LetterCode();
	}
	
	
	// returns temp(F) if param is true
	// returns temp(C) is param is false
	public double getTemperature(boolean getFahrenheit) {
		if (!getFahrenheit)
		{
			temp = Math.round(temp*100.0)/100.0;
			return temp;
		}
		else {
			temp = ((9*temp)/5 + 32);
			temp = Math.round(temp*100.0)/100.0;
			return temp;
		}
	}

	@Override
	public int compareTo(Temperature o) {
		
		// create map to store int value of months
		Map<String, Integer> months = new HashMap<>();
		months.put("Jan", 1);
		months.put("Feb", 2);
		months.put("Mar", 3);
		months.put("Apr", 4);
		months.put("May", 5);
		months.put("Jun", 6);
		months.put("Jul", 7);
		months.put("Aug", 8);
		months.put("Sep", 9);
		months.put("Oct", 10);
		months.put("Nov", 11);
		months.put("Dec", 12);
		
		// vars to hold the months to compare
		String testMonth = getMonth();
		String otherTestMonth = o.getMonth();
		
		// ints that hold the map key of the strings stored above
		int monthValue = months.get(testMonth);
		int otherMonthValue = months.get(otherTestMonth);
		
		// compare objects by temp, then country, then year, then month
		if(getTemperature(false) > o.getTemperature(false))
				return 1;
		else if(getTemperature(false) < o.getTemperature(false))
			return -1;
		else if(getCountry().compareTo(o.getCountry()) > 0)
			return 1;
		else if(getCountry().compareTo(o.getCountry()) < 0)
			return -1;
		else if(getYear() < o.getYear())
			return 1;
		else if(getYear() > o.getYear())
			return -1;
		else if(monthValue < otherMonthValue)
			return 1;
		else if(monthValue > otherMonthValue)
			return -1;
		
		else {
			return 0;
		}
				
	}
	
	@Override // overrides the comparator method
	public boolean equals(Object obj) {
		Temperature t = (Temperature) obj;
		
		if(this.getTemperature(false) != t.getTemperature(false))
			return false;
		else if(!this.getCountry().equals(t.getCountry()))
			return false;
		else if(this.getYear() != t.getYear())
			return false;
		else if(!this.getMonth().equals(t.getMonth()))
			return false;
		else {
			return true;
		}
				
	}
	
	@Override // overrides the comparator method hashCode()
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		long temp;
		temp = Double.doubleToLongBits(this.temp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + year;
		return result;
	}



}
