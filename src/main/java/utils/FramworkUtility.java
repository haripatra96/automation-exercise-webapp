package utils;

import java.util.UUID;

public class FramworkUtility {
	
	public static String getRandomEmail() {
		
		return "MyTest"+UUID.randomUUID().toString().substring(0,5)+"@mytest.com";
	}
	public static String getRandomName() {
		
		return "MyTestName"+UUID.randomUUID().toString().substring(1,4)+"Full";
	}
	
	

}
