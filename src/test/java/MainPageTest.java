import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class MainPageTest {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;

    @BeforeMethod
    public void start() {
        try {
            System.setProperty("webdriver.chrome.driver", Config.DRIVER_DIRECTORY);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5, 500));
        }
        catch (NullPointerException e) {
            System.out.println("Chromedriver не найден");
        }
    }

    @Test
    public void mainDropdownTest() {
        mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        Assert.assertEquals(mainPage.getArrayComputers(), mainPage.expectedArrayComputers());
        Assert.assertEquals(mainPage.getArrayElectronics(), mainPage.expectedArrayElectronics());
    }

    @Test(dataProvider = "auth-data", dataProviderClass = Config.class)
    public void authTest(String login, String pass) {
        mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        loginPage = mainPage.goToLogin();
        mainPage = loginPage.auth(login, pass);
        Assert.assertEquals(mainPage.getProfileHead(), login);


    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
}
