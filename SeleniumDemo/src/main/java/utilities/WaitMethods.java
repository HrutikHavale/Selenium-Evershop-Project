package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitMethods {

    WebDriver wd ;
    //FluentWait wait = new FluentWait(wd);

    public static String visibilityItemsPath ;
    public WaitMethods fluentWait( ){
        FluentWait wait= new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("visibilityItemsPath")));
        return this;
    }

}
