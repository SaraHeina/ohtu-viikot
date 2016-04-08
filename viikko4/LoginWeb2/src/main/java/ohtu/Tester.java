package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        //vaara salasana
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("allu");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        
        //ei olemassa oleva user
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("ella");
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        
        //uusi user
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("elise");
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana1");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        //logout
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    }
}
