package com.epam.liavitskaya.main.utils;

public class RequestParserUtil {
	
	public static String[] parseRequest(String request) {
		
		String[] requestParts = request.split(" ");
		
		return requestParts;		
	}	
}
