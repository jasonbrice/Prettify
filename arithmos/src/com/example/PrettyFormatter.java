package com.example;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * The PrettyFormatter class accepts a numeric type and returns a truncated, 
 * "prettified" string version. The prettified version includes one number after the
 * decimal when the truncated number is not an integer. It prettifies numbers greater
 * than 6 digits and supports millions, billions and trillions.
 
 * @author Jason Brice jlbrice@gmail.com
 * @version 1.0
 */
public class PrettyFormatter {
	
	private String value;
	
	public PrettyFormatter(String value){
		this.value = value;
	}
	
	/**
	 * Returns a String that is pretty 
	 * 
	 * @param String value - a String representing a number to be prettified.
	 * @return a String - the prettified number.
	 */
	public String getFormattedValue() {

		Locale locale = Locale.getDefault();
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		DecimalFormat prettyDecimalFormat = (DecimalFormat) numberFormat;
		prettyDecimalFormat.applyLocalizedPattern("#,##0.#");


		try{
		double d = numberFormat.parse(value).doubleValue();
				
				//"It should prettify numbers greater than 6 digits"
				// Let's assume this means return the value unchanged,
				// even we get a format like scientific notation.
				if(Math.abs(d) < 1000000) 
					{
						return value;
					}
				
			
					String formattedNumber = format(d, prettyDecimalFormat);
					return formattedNumber;
					
			}
			
			// catch an exception thrown by NumberFormat.parse()
			catch (ParseException nfe) {
				return value
						+ " doesn't look like a number. Try something like 123 or 456.789 or 100,000,000 or 1.08E2";
			}
			// catch any general exceptions. but...
			// according to the JavaDoc, no other methods
			// called in the try/catch block can throw an exception,
			// so *if* the JavaDoc is right, this won't ever be executed.
			catch (Exception ex) {
				return "unable to prettify " + value;
			}

		}


	// to be appended to the number once it's prettified
	private static String[] suffixes = new String[] { "K", "M", "B", "T" };

	/**
	 * Returns a string representing a number with the appropriate prefix
	 * 
	 * @param number
	 * @param decimalFormat
	 * @return String formatted with decimalFormat provided
	 */
	private static String format(double number, DecimalFormat decimalFormat) {
		
		for (int j = suffixes.length; j > 0; j--) {
			double unit = Math.pow(1000, j);

			if (Math.abs(number) >= unit) {
				return decimalFormat.format(number / unit) + suffixes[--j];
			}
		}
		return decimalFormat.format(number);
	}
}
