package com.vcentry.onlineshop.intializer;

public class Precondition extends Intializer {

	
	public static void loadUrl(){
		
        wd.get(envProp.getProperty("URL"));

	}
}
