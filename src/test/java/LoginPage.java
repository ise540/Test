import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail (String email) {
        driver.findElement(By.className("email")).sendKeys(email);
    }

    public void setPassword (String password) {
        driver.findElement(By.className("password")).sendKeys(password);
    }

    public void loginClick () {
        driver.findElement(By.xpath("//input[contains(@class, 'login-button')]")).click();
    }

    public MainPage auth (String email, String password) {
        setEmail(email);
        setPassword(password);
        loginClick();
        return new MainPage(driver);
    }

}
