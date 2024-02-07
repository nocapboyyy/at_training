import org.junit.jupiter.api.Test;

public class WbTest extends BasicSettings{

    private final static String BASE_URL = "https://www.wildberries.ru/";
    private final static String REQUEST_STRING = "Видеокарта GeForce RTX 4090 ROG Strix OC Edition 24GB";

    @Test
    public void checkHref(){
        MainPage mainPage = new MainPage(BASE_URL);
        int a = 0;
    }
}
