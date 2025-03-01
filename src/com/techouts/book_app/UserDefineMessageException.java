package com.techouts.book_app;

@SuppressWarnings("serial")
public class UserDefineMessageException extends RuntimeException
{
	public UserDefineMessageException()
	{
		super();
	}
	
	public UserDefineMessageException(String msg)
	{
		super(msg);
	}
}
