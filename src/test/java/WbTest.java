import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WbTest extends BasicSettings{

    private final static String BASE_URL = "https://www.wildberries.ru/";
    private final static String REQUEST_STRING = "Видеокарта GeForce RTX 4060 WINDFORCE OC 8G";


    @Test
    public void wildberriesActivity(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.search(REQUEST_STRING);
        PageAfterSearch pageAfterSearch = new PageAfterSearch();
        wait(10);
        ProductDto dtoPageAfterSearch = pageAfterSearch.getProductAttributes();
        assertEquals(REQUEST_STRING, dtoPageAfterSearch.productName);
        pageAfterSearch.moveToFullProductCard();
        FullProductCard fullProductCard = new FullProductCard();
        wait(10);
        ProductDto dtoFullProductCard = fullProductCard.getFullProductCardAttributes();
        assertEquals(dtoPageAfterSearch, dtoFullProductCard);
        fullProductCard.addtoCart();
        fullProductCard.moveToCart();
        CartPage cartPage = new CartPage();
        wait(10);
        ProductDto dtoCartPage = cartPage.getCartProductAttributes();
        assertEquals(dtoFullProductCard, dtoCartPage);
    }
}