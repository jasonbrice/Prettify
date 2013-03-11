package com.example;

import java.text.*;
import java.util.*;

/**
 * The Prettify class provides an entry point into the application,
 * and creates a PrettyFormatter instance for each argument provided. 
 * 
 * @author Jason Brice jlbrice@gmail.com
 * @version 1.0
 */
public class Prettify {

	public static void main(String[] args) {

		if (null == args || args.length == 0) {
			usage();
			return;
		}

		// echo the args back to confirm...
		System.out.println("You entered: " + join(args, ","));

		// loop through each argument and show the user their prettified numbers
		for(int i=0;i<args.length;i++){
			PrettyFormatter formatter = new PrettyFormatter(args[i]);
			System.out.println(formatter.getFormattedValue());
		}

	}

	/**
	 * Returns a String object that is the concatenation of the array provided
	 * delimited by the String delimiter provided.
	 * 
	 * @param input
	 *            - an array of strings
	 * @param delimiter
	 *            - the String to use to separate array entries
	 * @return a String of inputs joined by the delimiter
	 */
	public static String join(String[] input, String delimiter) {

		if (null == input || input.length == 0)
			return null;

		StringBuilder sb = new StringBuilder();
		int i;

		for (i = 0; i < input.length - 1; i++)
			sb.append(input[i] + delimiter);

		return sb.toString() + input[i];
	}

	// catch all for null/unexpected input
	private static void usage() {

		System.out.println("Please enter a number to format.");
		System.out.println("Some examples you might try are: 123 or 456.789 or 100,000,000 or 1.08E2");

	}
}
