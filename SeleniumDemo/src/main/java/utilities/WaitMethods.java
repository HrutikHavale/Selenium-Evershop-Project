package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitMethods {

    WebDriver wd ;

    public WaitMethods(WebDriver wd){
        this.wd=wd;
    }



    public void fluentWait(String visibilityItemsPath ){
        FluentWait wait= new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath(visibilityItemsPath)));
    }

    public void implicitWait(){
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

}
