package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.WaitMethods;

import java.time.Duration;

public class ItemPage {
    WebDriver wd ;
    WaitMethods wait;

    String visibilityItemsPathOfItempage= "//button[@type=\"button\"]";

    public ItemPage(WebDriver wd){
        this.wd= wd;
    }
    String itemSize = "//a[text()='^^']";
    String itemColour = "//a[text()='^^']";
    By AddToCartButton = By.xpath("//button[@type=\"button\"]");

    public AddedToCart AddToCart(String itemSize, String itemColour ){

        wait= new WaitMethods(wd);
        wait.fluentWait(visibilityItemsPathOfItempage);

       String localItemSize =itemSize.replace("^^","itemSize");
       wd.findElement(By.xpath(localItemSize)).click();

       String localItemColour = itemColour.replace("^^","itemColour");
       wd.findElement(By.xpath(localItemColour)).click();
        wd.findElement(AddToCartButton).click();

        /*wd.findElement(ItemSize).click();
        wd.findElement(ItemColour).click();
        wd.findElement(AddToCartButton).click();*/

        return new AddedToCart(wd);

    }
}
