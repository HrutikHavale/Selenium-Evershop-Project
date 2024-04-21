package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.WaitMethods;

import java.time.Duration;

public class HomePage {
    WebDriver wd ;
    WaitMethods wait;
    String visibilityItemsPathOfHomepage= "//span[text()=('Shop kids')]";

    public HomePage(WebDriver wd){
        this.wd= wd;
    }
 String ItemLink = "//span[text()=('^^')]";


    public ItemPage ClickOnItem(String itemName){
       wait = new WaitMethods(wd);
       wait.fluentWait(visibilityItemsPathOfHomepage);

        String localItemLink = ItemLink.replace("^^",itemName);
        wd.findElement(By.xpath(localItemLink)).click();
        return new ItemPage(wd);
    }
}
