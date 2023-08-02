package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private  static Actions actions;

    // espera implicita es la que se realiza a nivel global de un proyecto
    // espera explicita la que utilizo para esperar un elemento


    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public BasePage(WebDriver driver) {
        BasePage.driver =driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void navigateTo(String url){
        driver.get(url);
    }

    private WebElement Find(String locator){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    public void clickElement(String locator){
        Find(locator).click();
    }
    public void write(String locator,String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }
    public void selectFromDropdownByValue(String locator,String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }
    public void selectFromDropdownByIndex(String locator,int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }
    public void selectFromDropdownByText(String locator,String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }
    public void hoverOverElement (String locator){
        actions.moveToElement(Find(locator));
    }
    public void doubleClick (String locator){
        actions.doubleClick(Find(locator));
    }
    public void rightClick(String locator){
        actions.contextClick(Find(locator));
    }
    public void switchToiFrame(String iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public String textFromElement(String locator){
        return Find(locator).getText();
    }
    public boolean elementIsDisplayed(String locator){

        return Find(locator).isDisplayed();
    }

    public boolean elementEnabled(String locator){

        return Find(locator).isEnabled();
    }
    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }
    public static void closeBrowser(){
        driver.quit();
    }
    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }


}
