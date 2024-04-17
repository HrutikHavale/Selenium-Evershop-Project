package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ItemPage {
    WebDriver wd ;

    public ItemPage(WebDriver wd){
        this.wd= wd;
    }
    String itemSize = "//a[text()='^^']";
    String itemColour = "//a[text()='^^']";
    By AddToCartButton = By.xpath("//button[@type=\"button\"]");
    public ItemPage WaitMethod2(){
        FluentWait wait= new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//button[@type=\"button\"]")));
        return this;
    }

    public AddedToCart AddToCart(String itemSize, String itemColour ){
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
