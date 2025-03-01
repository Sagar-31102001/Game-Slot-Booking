package com.techouts.book_app;

import java.util.List;

public class Sport 
{
	private String name;
	private List<String> slot;
	
	public Sport(String name, List<String> slot)
	{
		super();
		this.name = name;
		this.slot = slot;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public List<String> getSlot() 
	{
		return slot;
	}
	
	public void bookSlot(int slotBook)
	{
		slot.remove(slotBook);
	}

	@Override
	public String toString()
	{
		return "Sport [name=" + name + ", slot=" + slot + "]";
	}
	
}
