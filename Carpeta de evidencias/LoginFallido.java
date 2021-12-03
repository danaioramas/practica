package com.example.UADY;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class LoginFallido {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testLoginFallido() throws Exception {
    driver.get("https://es.uadyvirtual.uady.mx/login/index.php");
    pause(5000);
    driver.findElement(By.xpath("//section[@id='region-main']/div/div[2]/div/div/div/div/div/div")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("A15001091");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Underworld74");
    driver.findElement(By.id("loginbtn")).click();
    String TextoRealizado= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div[2]/div/div/div/div/div[1]/div")).getText();
    String TextoDeseado= "Datos erróneos. Por favor, inténtelo otra vez.";
    assertThat(TextoDeseado,is(TextoRealizado));
  }
  
 /* @Test
  public void testLoginCorrecto() throws Exception {
    driver.get("https://es.uadyvirtual.uady.mx/login/index.php");
    driver.findElement(By.xpath("//section[@id='region-main']/div/div[2]/div/div/div/div/div/div")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("A15001091");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Underworld71");
    driver.findElement(By.id("loginbtn")).click();
    pause(5000);
    String TextoRealizado= driver.findElement(By.xpath("/html/body/div[2]/nav/ul[2]/li[2]/div/div/div/div/div/a/span/span[1]")).getText();
    String TextoDeseado="DANAI MARCELA ALPUCHE ORAMAS";
    assertThat(TextoDeseado,is(TextoRealizado));
  }
 */ 
  private void pause(long mils) {
  try {
  Thread.sleep(mils);
  }catch(Exception e) {
  e.printStackTrace();
  }
  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
