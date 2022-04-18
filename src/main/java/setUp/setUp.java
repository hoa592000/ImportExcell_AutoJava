package setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class setUp {
    public static WebDriver driver;

    public setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\AutoTest\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://thecaringstaff.app/login");
    }

}
