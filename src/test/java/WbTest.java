import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WbTest extends BasicSettings{

    private final static String BASE_URL = "https://www.wildberries.ru/";
    private final static String REQUEST_STRING = "Видеокарта GeForce RTX 4090 ROG Strix OC Edition 24GB";

    @Test
    public void wildberriesActivity(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.search(REQUEST_STRING);
        PageAfterSearch pageAfterSearch = new PageAfterSearch();
        String productCardName = pageAfterSearch.getPCNFromFirstProduct();
        assertEquals(REQUEST_STRING, productCardName);
    }
}
