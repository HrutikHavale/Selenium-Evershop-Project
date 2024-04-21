package DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReadPropFile;

import java.util.Properties;

public class loginPage {

    WebDriver wd ;

 public loginPage(WebDriver wd){
     this.wd= wd;
 }
    By usernamefield= By.xpath("//input[@name='email']");

    By passwordfield= By.xpath("//input[@name='password']");

    By signinbtn= By.xpath("//button[@type='submit']");

   public loginPage get(){
       wd.get("https://demo.evershop.io/account/login");
       return this;
   }
    public loginPage fillusername(String email){

       wd.findElement(usernamefield).sendKeys(email);
       return this;
    }

    public loginPage fillpassword(String password){

       wd.findElement(passwordfield).sendKeys(password);
        return this;
    }



    public HomePage clicksigninbtn(){

       wd.findElement(signinbtn).click();
        return new HomePage(wd);
    }







}
