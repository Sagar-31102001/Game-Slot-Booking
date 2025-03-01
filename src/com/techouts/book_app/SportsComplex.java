package com.techouts.book_app;

import java.util.ArrayList;
import java.util.List;

public class SportsComplex 
{
	private List<Sport> sport;

	public SportsComplex()
	{
		super();
		this.sport = new ArrayList<Sport>();
		allocateSlot();
	}
	
	
	public void allocateSlot()
	{
		// Allocate Slot For Badminton Court
		List<String> badminton=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			badminton.add((9 + i) + ":00 - " + (10 + i) + ":00");
		}
		sport.add(new Sport("Badminton",badminton));
		
		// Allocate Slot For Football Court
		List<String> football=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			int startHour = 8 + (i / 2); // 8
            int startMinute = (i % 2 == 0) ? 30 : 0; // 1       // 08:00- 08:30
            //football.add("Slot " + (i) + ": " + String.format("%02d:%02d - %02d:%02d", startHour, startMinute, startHour, startMinute + 30));
            football.add(String.format("%02d:%02d - %02d:%02d", startHour, startMinute, startHour, startMinute + 30));
		}
		sport.add(new Sport("Football", football));
		
		
		// Allocate Slot For Cricket Box 
		List<String> cricket=new ArrayList<>();
		for(int i=0;i<3;i++)
		{
			//cricket.add("Slot " + (i) + ": " + (10 + i) + ":00 - " + (12 + i) + ":00");
			cricket.add((10 + i) + ":00 - " + (12 + i) + ":00");
		}
		sport.add(new Sport("Cricket", cricket));
	}
	
	public List<Sport> getSport() 
	{
		return sport;
	}
	
	// Display All Games
	public  void displaySports()
	{
		System.out.println("Avaiable Games Are :-\n");
		for(int i=0;i<sport.size();i++)
		{
			System.out.println((i+1)+"\t"+sport.get(i).getName());
		}
	}
	
	// Display Slot Coressponding Game
	public void displaySlot(Sport sport)
	{
		System.out.println("Selected Game Is : "+sport.getName());
		System.out.println("Avaiable Slot Are :-");
		List<String> slot = sport.getSlot();
		for(int i=0;i<slot.size();i++)
		{
			System.out.println("Slot " + (i+1) + ": " +slot.get(i));
		}
	}


	public boolean checkSlots(int choice)
	{
		  List<String> slot = this.getSport().get(choice).getSlot();
		  
		  if(slot.isEmpty())
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
		  
	}
}
