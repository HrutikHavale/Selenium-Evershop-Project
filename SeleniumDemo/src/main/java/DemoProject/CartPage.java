package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.WaitMethods;

import java.time.Duration;

public class CartPage {
    WebDriver wd ;

    WaitMethods wait;

    String visibilityItemsPathOfCartPage= "//a[@class=\"button primary\"]";

    public CartPage(WebDriver wd){
        this.wd= wd;
    }
    By CheckOutBtn = By.xpath("//a[@class=\"button primary\"]");


    public Checkout ClickOnCheckout(){

        wait=new WaitMethods(wd);
        wait.fluentWait(visibilityItemsPathOfCartPage);

        wd.findElement(CheckOutBtn).click();
        return new Checkout(wd);
    }
}

