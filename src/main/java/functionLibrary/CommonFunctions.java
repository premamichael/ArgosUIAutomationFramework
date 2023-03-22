package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonFunctions {
    public static WebDriver driver;

    public void openBrowser()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
    }
    public void closeBrowser()
    {
        driver.quit();
    }
}
