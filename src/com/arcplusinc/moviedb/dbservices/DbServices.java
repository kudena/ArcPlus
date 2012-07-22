package com.arcplusinc.moviedb.dbservices;

import java.util.Collection;
import java.util.Iterator;

import com.arcplusinc.moviedb.model.Directors;
import com.arcplusinc.moviedb.model.DirectorsDAO;
import com.arcplusinc.moviedb.model.Titles;
import com.arcplusinc.moviedb.model.TitlesDAO;

 

public final class DbServices {
	
	private static final class DataBaseServicesHolder {
		static final DbServices dbServices = new DbServices();
	}

	private DbServices() {}
	
	public static DbServices getInstance() {
		return DataBaseServicesHolder.dbServices;
	}
	
	
	public Collection findAlldirectors()
	{
		Collection c = null;
		DirectorsDAO d = new DirectorsDAO();
		c = d.findAll();
		
		for (Iterator iter = c.iterator(); iter.hasNext();) 
		{
			Directors director = (Directors)iter.next();
			System.out.println(director.getName());			
		}
		
		
		return c;
		
	}
	
	public Collection findAllTitles()
	{
		Collection c = null;
		TitlesDAO t = new TitlesDAO();
		c = t.findAll();
		
		for (Iterator iter = c.iterator(); iter.hasNext();) 
		{
			Titles title = (Titles)iter.next();
			System.out.println(title.getTitles());			
		}
		
		return c;
		
		
	}
	
}	
	
	
