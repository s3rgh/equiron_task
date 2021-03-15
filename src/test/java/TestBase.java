import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver webDriver;

    Path getCurrentWorkingDirectory() {
        return Paths.get("").toAbsolutePath();
    }

    public void initialize() {

        //TODO: убрать опции веб-драйвера и сделать скачивание файла через input/output stream, чтобы не привязываться к типу браузера
        HashMap<String,Object> chromePrefs = new HashMap<>();
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", getCurrentWorkingDirectory().toString());
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("prefs", chromePrefs);
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //TODO: добавить возможность использовать браузер многократно, не перезапуская перед каждым тестом
    public void tearDown() {
        webDriver.quit();
    }
}