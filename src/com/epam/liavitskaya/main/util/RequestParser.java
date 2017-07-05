package com.epam.liavitskaya.main.util;

public class RequestParser {
	
	public static String[] parseRequest(String request) {
		
		String[] requestParts = request.split(" ");
		
		return requestParts;		
	}	
}
