package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;


public class TakeScreenshots {

     WebDriver wd;

    public TakeScreenshots(WebDriver wd){
        this.wd=wd;
    }

 public  void TakeScreenshot() throws IOException {
    // Take screenshot and store as a file format
    File src = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);

    // now copy the screenshot to desired location using copyFile //method
    String screenshotPath = "C:\\Users\\Rutik\\IdeaProjects\\SeleniumDemo\\Screenshots";
    FileUtils.copyFile(src,new  File(screenshotPath));
}
}