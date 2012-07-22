package com.arcplusinc.moviedb.managedbeans;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.arcplusinc.moviedb.dbservices.DbServices;




@ManagedBean
@RequestScoped

public class TestdbBean {
	
	DbServices dbs = DbServices.getInstance();
	
	
	public void AllDirectors()
	{
		Collection c = dbs.findAlldirectors();
	}
	
	public void AllTitles()
	{
		Collection c = dbs.findAllTitles();
		
	}

}
