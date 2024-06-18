import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;


abstract public class BasicSettings {

    //webdriver installing, browser pick and run
    public void setup(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }

    public void wait(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException("Ошибка при ожидании" + e);
        }
    }

    //инициализация перед выполнением теста
    @BeforeEach
    public void init(){
        setup();
    }

    //закрытие webdriver после выполнения теста
    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}