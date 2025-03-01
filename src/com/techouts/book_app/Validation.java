package com.techouts.book_app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation
{
	private Validation()
	{
		super();
	}
	
	public static boolean isValidName(String name, String regex) 
	{
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
	
	public static boolean isValidPhoneNumber(String phoneNumber) 
	{
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        if (phoneNumber.startsWith("+")) {
            phoneNumber = phoneNumber.substring(1);
        }
        return phoneNumber.matches("\\d{10,13}");
    }
}