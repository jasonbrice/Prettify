package com.example.test;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

import com.example.*;

import java.util.*;

/**
 * The TestPrettyFormatter class tests the claims made by the PrettyFormatter class. 
 * 
 * @author Jason Brice jlbrice@gmail.com
 * @version 1.0
 */
public class TestPrettyFormatter {

	@Test
	public void testPositive() {

		// note from the JavaDoc:
		// This class makes no guarantees as to the order of the map; in particular, 
		// it does not guarantee that the order will remain constant over time.
		// So the printout might not always match the order pairs are put into the map.
		java.util.HashMap<String,String> map = new java.util.HashMap<String,String>();
		
		map.put("10", "10");
		map.put("1000", "1000");
		map.put("10000", "10000");
		map.put("100000", "100000");
		map.put("1,000,000", "1M");
		//map.put("-1,000,000", "-1M");
		map.put("1.08E2", "1.08E2");
		// no longer valid map.put("1.08E100", "1.08E100 is outside the Prettification range");
		map.put("apple", "apple doesn't look like a number. Try something like 123 or 456.789 or 100,000,000 or 1.08E2");
		map.put("1000000", "1M");
		map.put("2500000.34", "2.5M");
		map.put("532", "532");
		map.put("1123456789", "1.1B");
		
		for(Iterator<String> it = map.keySet().iterator(); it.hasNext(); )
		{
			String key = it.next();
			String expectedValue = map.get(key);
			String actualValue = new PrettyFormatter(key).getFormattedValue();
			
			if(!expectedValue.equals(actualValue)){
				fail("Unexpected result: " + expectedValue + " != " + actualValue);				
			}else{
				System.out.println(expectedValue + " equals " + actualValue);	
			}
			
		}
		
	}

	@Test
	public void testNegative(){
		// note from the JavaDoc:
				// This class makes no guarantees as to the order of the map; in particular, 
				// it does not guarantee that the order will remain constant over time.
				// So the printout might not always match the order pairs are put into the map.
				java.util.HashMap<String,String> map = new java.util.HashMap<String,String>();
				
				map.put("-1,000,000", "-1M");
				
				for(Iterator<String> it = map.keySet().iterator(); it.hasNext(); )
				{
					String key = it.next();
					String expectedValue = map.get(key);
					String actualValue = new PrettyFormatter(key).getFormattedValue();
					
					if(!expectedValue.equals(actualValue)){
						fail("Unexpected result: " + expectedValue + " != " + actualValue);				
					}else{
						System.out.println(expectedValue + " equals " + actualValue);	
					}
					
				}
		
	}
	
	@Test
	public void testReallyBig(){
		java.util.HashMap<String,String> map = new java.util.HashMap<String,String>();
		
		map.put("1,000,000,000,000", "1T");
		map.put("10,000,000,000,000", "10T");
		map.put("100,000,000,000,000", "100T");
		map.put("1,000,000,000,000,000", "1,000T");

		
		for(Iterator<String> it = map.keySet().iterator(); it.hasNext(); )
		{
			String key = it.next();
			String expectedValue = map.get(key);
			String actualValue = new PrettyFormatter(key).getFormattedValue();
			
			if(!expectedValue.equals(actualValue)){
				fail("Unexpected result: " + expectedValue + " != " + actualValue);				
			}else{
				System.out.println(expectedValue + " equals " + actualValue);	
			}
			
		}
	}
	
	// Uncomment the method below to intentionally fail the test
//	@Test
//	public void intentionalFail() {
//
//		java.util.HashMap<String,String> map = new java.util.HashMap<String,String>();
//		
//		map.put("1000", "1M");
//		
//		for(Iterator<String> it = map.keySet().iterator(); it.hasNext(); )
//		{
//			String key = it.next();
//			String expectedValue = map.get(key);
//			String actualValue = new PrettyFormatter(key).getFormattedValue();
//			
//			if(!expectedValue.equals(actualValue)){
//				fail("Unexpected result: " + expectedValue + " != " + actualValue);				
//			}else{
//				System.out.println(expectedValue + " equals " + actualValue);	
//			}
//			
//		}
//	}
	
}
