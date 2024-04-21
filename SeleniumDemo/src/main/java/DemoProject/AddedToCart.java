package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.ReadPropFile;
import utilities.WaitMethods;

import java.time.Duration;

public class AddedToCart {
    WebDriver wd ;

    WaitMethods wait;

    String visibilityItemsPathOfAddedToCartpage= "//div[text()='JUST ADDED TO YOUR CART']";

    public AddedToCart(WebDriver wd)
    {this.wd= wd;}
    By ViewCart = By.xpath("//a[text()='VIEW CART (1)']");


    public CartPage ViewCart(){

        wait=new WaitMethods(wd);
        wait.fluentWait(visibilityItemsPathOfAddedToCartpage);

        wd.findElement(ViewCart).click();
        return new CartPage(wd);
    }
}
