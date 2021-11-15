import org.testng.annotations.DataProvider;

public class Config {
    public static final String DRIVER_DIRECTORY = "D:/Projects/chromedriver.exe";
    public static final String EMAIL = "fff@fff.fff";
    public static final String PASSWORD = "fff123";

    @DataProvider(name = "auth-data")
    public Object[][] authData() {
        return new Object[][] {{EMAIL,PASSWORD},{"udsfoghj@odfijg.com", "fff"}};
    }
}
