import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignTest {
    @Test
    public void testFazerLoginNoTaskIt(){


        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.juliodelima.com.br/taskit");

        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("julio0001");
        driver.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123456");

        driver.findElement(By.linkText("SIGN IN")).click();

        String saudacao = driver.findElement(By.className("me")).getText();
        System.out.println("Login efetuado");

        assertEquals("Hi, Julio", saudacao);
        System.out.println(saudacao);
        driver.quit();
    }
}
