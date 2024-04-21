package DemoprojectTestcases;

import DemoProject.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.ExcelManager;
import utilities.WebDriverManager;

import java.io.IOException;

public class TestCase1 {

    public WebDriver wd;
    public loginPage login;
    public HomePage home;
    public ItemPage item;
    public AddedToCart added;
    public CartPage cart;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(String browserName){
       wd = WebDriverManager.creteSession(browserName);
        login = new loginPage(wd);
        home = new HomePage(wd);
        item = new ItemPage(wd);
        added = new AddedToCart(wd);
        cart = new CartPage(wd);
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginData() throws IOException {

        return ExcelManager.readData1();

    }

  @Parameters({"itemName", "itemSize", "itemColour"})
    @Test(alwaysRun = true,dataProvider ="loginDataProvider" )
    public void preSteps(String UN, String PW, String itemName, String itemSize, String itemColour ) throws InterruptedException {

     /* login.get();
      login.fillusername(UN);
      login.fillpassword(PW);
      login.clicksigninbtn();
     */
      //imporved
      login.get().fillusername(UN).fillpassword(PW).clicksigninbtn()
              .ClickOnItem(itemName)
              .AddToCart(itemSize,itemColour)
              .ViewCart()
              .ClickOnCheckout()
              .ContinueToPayment();

      //Thread.sleep(4000);
  }

}
