package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.WaitMethods;

import java.time.Duration;

public class Checkout {
    WebDriver wd ;
    WaitMethods wait;

    String visibilityItemsPathOfCheckoutPage="//h4[contains(text(),'Shipping Address')]";

    public Checkout(WebDriver wd){
        this.wd= wd;
    }
    By ViewCart = By.xpath("//a[text()='VIEW CART (1)']");


    public void ContinueToPayment(){

        wait=new WaitMethods(wd);
        wait.fluentWait(visibilityItemsPathOfCheckoutPage);

        wd.findElement(ViewCart).click();

    }
}

