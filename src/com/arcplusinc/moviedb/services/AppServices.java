package com.arcplusinc.moviedb.services;

public final class AppServices {
	
	private static final class ApplicationServicesHolder {
		static final AppServices appServices = new AppServices();
	}

	private AppServices() {}
	
	public static AppServices getInstance() {
		return ApplicationServicesHolder.appServices;
	}
	
	
	
	
	
}	
