package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ImageHelper {
	
	public static String getScreenshot(WebDriver driver) throws IOException {
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String strImageName =Math.random()+".png";
		File DestFile = new File("target/"+strImageName);
		FileUtils.copyFile(SrcFile, DestFile);// this is coming from apache.commons.io
		return strImageName;
	}

}
