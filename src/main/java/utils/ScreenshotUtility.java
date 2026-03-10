package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	private ScreenshotUtility() {}
	
	public static String captureScreenshot(WebDriver driver, String name) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String path = System.getProperty("user.dir")+"/"+name+"_"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(src, new File (path));
		return path;
	}

}
