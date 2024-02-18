import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract public class BasicSettings {

    //webdriver installing, browser pick and run
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        //Configuration.driverManagerEnabled = true;
    }

    //инициализация перед выполнением теста
    @BeforeEach
    public void init(){
        setUp();
    }

    //закрытие webdriver после выполнения теста
    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
