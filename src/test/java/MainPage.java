import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
   Главная страница WB
 */

public class MainPage {

    private final SelenideElement searchField = $x("searchInput"); //"div input#searchInput"

    public MainPage(String url){
        Selenide.open(url);
    }

    public void searchFieldCompletion(){

    }

}
