import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/**
   Главная страница WB
 */

public class MainPage {

    private final SelenideElement searchField = $x("//input[@id='searchInput']");

    public MainPage(String url){
        Selenide.open(url);
    }

    /**
     * Происходит заполнение строки поиска и выполняется поиск посредством нажатия ENTER
     * @param searchValue значение для поиска
     */
    public void search(String searchValue){
        searchField.setValue(searchValue);
        searchField.sendKeys(Keys.ENTER);
    }

}