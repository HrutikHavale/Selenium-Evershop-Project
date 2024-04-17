package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class HomePage {
    WebDriver wd ;
   /* public WaitMethods wait;
    String visibilityItemsPathOfHomepage= "//span[text()=('Shop kids')]";*/

    public HomePage(WebDriver wd){
        this.wd= wd;
    }
 String ItemLink = "//span[text()=('^^')]";
    public HomePage WaitMethod(){
        FluentWait wait= new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//span[text()=('Shop kids')]")));
        return this;
    }

    public ItemPage ClickOnItem(String itemName){
       /* wait = new WaitMethods();
        wait.fluentWait(visibilityItemsPathOfHomepage);*/
        String localItemLink = ItemLink.replace("^^",itemName);
        wd.findElement(By.xpath(localItemLink)).click();
        return new ItemPage(wd);
    }
}
