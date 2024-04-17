package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CartPage {
    WebDriver wd ;

    public CartPage(WebDriver wd){
        this.wd= wd;
    }
    By CheckOut = By.xpath("//a[@class=\"button primary\"]");

    public CartPage WaitMethod4(){
        FluentWait wait= new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//a[@class=\"button primary\"]")));
        return this;
    }

    public void ViewCart(){
        wd.findElement(CheckOut).click();
    }
}

