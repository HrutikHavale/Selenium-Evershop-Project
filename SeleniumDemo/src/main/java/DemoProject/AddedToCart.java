package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class AddedToCart {
    WebDriver wd ;

    public AddedToCart(WebDriver wd){
        this.wd= wd;
    }
    By ViewCart = By.xpath("//a[text()='VIEW CART (1)']");

    public AddedToCart WaitMethod3(){
        FluentWait wait= new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//div[text()='JUST ADDED TO YOUR CART']")));
        return this;
    }

    public CartPage ViewCart(){
        wd.findElement(ViewCart).click();
        return new CartPage(wd);
    }
}
