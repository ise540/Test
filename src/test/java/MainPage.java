import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebElement dropdownComputers;
    private WebElement dropdownElectronics;


    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    public void goToMainPage() {
        driver.get("http://demowebshop.tricentis.com/");
    }

    public List<String> getArrayComputers () {
        dropdownComputers = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/computers']")));

        Actions actions = new Actions(driver);

        actions.moveToElement(dropdownComputers).build().perform();


        List<WebElement> listElements = driver.findElements(By.xpath("//ul[@class='sublist firstLevel active']//li//a"));

        List<String> list = new ArrayList<>();

        for (WebElement element:listElements) {
            list.add(element.getText());
        }

        return list;
    }

    public List<String> getArrayElectronics () {
        dropdownElectronics = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/electronics']")));

        Actions actions = new Actions(driver);

        actions.moveToElement(dropdownElectronics).build().perform();


        List<WebElement> listElements = driver.findElements(By.xpath("//ul[@class='sublist firstLevel active']//li//a"));

        List<String> list = new ArrayList<>();

        for (WebElement element:listElements) {
            list.add(element.getText());
        }

        return list;
    }

    public LoginPage goToLogin () {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        return new LoginPage(driver);
    }

    public String getProfileHead () {
        return driver.findElement(By.xpath("//a[@class='account'] [1]")).getText();
    }


    public List<String> expectedArrayComputers() {
        return Arrays.asList("Desktops", "Notebooks", "Accessories");
    }

    public List<String> expectedArrayElectronics() {
        return Arrays.asList("Camera, photo", "Cell phones");
    }

}
