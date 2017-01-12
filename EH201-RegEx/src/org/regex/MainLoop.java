package org.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainLoop {

	public static void main(String args[]) throws IOException {
		InputStreamReader inp = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(inp);
	    
	    System.out.println("What problem are you doing? (2/3/4/5)");
		String problem = br.readLine();
		
		if (problem.equalsIgnoreCase("2")) {
			FileStringReader fileReader = new FileStringReader("/home/tkettle/documents/openmrs-lectures/EH201 Advanced Java/Public/Exercises/04 Regular Expressions/test1.html");
			String contents = fileReader.readAll();
			System.out.println(contents);
			ArrayList<String> matchedString = regexMatcher(contents, "<a.*href=\"(.*)\".*>\\1</a>");
			System.out.println(matchedString);
			fileReader.close();
			} 
		else if (problem.equalsIgnoreCase("3")) {
			FileStringReader fileReader = new FileStringReader("/home/tkettle/documents/openmrs-lectures/EH201 Advanced Java/Public/Exercises/04 Regular Expressions/test2.txt");
			String contents = fileReader.readAll();
			System.out.println(contents);
			ArrayList<String> matchedString = regexMatcher(contents, "( [\\w\\d]+@[\\w\\d\\.]+)| ([+]*[\\d]{2,3} [\\d]*) | ([\\d]{9} )");
			System.out.println(matchedString);
			fileReader.close();
			}
		else if (problem.equalsIgnoreCase("4")) {
			FileStringReader fileReader = new FileStringReader("/home/tkettle/documents/openmrs-lectures/EH201 Advanced Java/Public/Exercises/04 Regular Expressions/test3.txt");
			String contents = fileReader.readAll();
			System.out.println(contents);
			ArrayList<String> matchedString = regexMatcher(contents, "( [\\w\\d]+@[\\w\\d\\.]+)| ([+]*[\\d]{2,3} [\\d]*) | ([\\d]{9} )");
			System.out.println(matchedString);
			fileReader.close();
		}
	}
	    
	private static ArrayList<String> regexMatcher(String searchString, String expression){

		Pattern regex = Pattern.compile(expression);
		Matcher matcher = regex.matcher(searchString);
		
		ArrayList<String> matchedString = new ArrayList<String>();
		while (matcher.find()) {
			String group = matcher.group();
			int start = matcher.start();
			int end = matcher.end();
			matchedString.add(searchString.substring(start, end));
		} 
		return matchedString;
		
	}		
}

