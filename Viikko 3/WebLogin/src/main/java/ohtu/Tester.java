package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        System.out.println(driver.getPageSource());
        
        //WebElement element = driver.findElement(By.linkText("login"));
        WebElement element = driver.findElement(By.linkText("register new user"));
        
        element.click();

        sleep(2);
        
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("username"));
        // element.sendKeys("pekka");
        Random random = new Random();
        element.sendKeys("makke"+random.nextInt(100000));
        
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.name("password"));
        //element.sendKeys("akkep");
        //element.sendKeys("wrong"); // syötetään väärä salasana
        element.sendKeys("newpassword");
        
        System.out.println(driver.getPageSource());
        
        //element = driver.findElement(By.name("login"));
        element = driver.findElement(By.name("passwordConfirmation"));
        
        
        sleep(2);
        
        System.out.println(driver.getPageSource());
        element.submit();
        

        sleep(3);
        
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        System.out.println(driver.getPageSource());
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
