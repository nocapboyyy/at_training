import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WbTest extends BasicSettings{

    private final static String BASE_URL = "https://www.wildberries.ru/";
    private final static String REQUEST_STRING = "Видеокарта GeForce RTX 4060 WINDFORCE OC 8G";


    @Test
    public void wildberriesActivity(){
        MainPage mainPage = new MainPage(BASE_URL); //открытие главной страницы WB
        mainPage.search(REQUEST_STRING); //поиск товара по названию
        PageAfterSearch pageAfterSearch = new PageAfterSearch(); //объявление экземпляра класса новой страницы
        wait(5); //ожидаение загрузки
        ProductDto dtoPageAfterSearch = pageAfterSearch.getProductAttributes(); //заполнение Data Transfer Object, хранящего данные (данными со страницы поиска)
        assertEquals(REQUEST_STRING, dtoPageAfterSearch.productName); //сравнение ожидаемого названия товара с фактическим
        pageAfterSearch.moveToFullProductCard(); //переход на страницу товара
        FullProductCard fullProductCard = new FullProductCard(); //создание экземпляра класса новой страницы
        wait(5); //ожидание загрузки
        ProductDto dtoFullProductCard = fullProductCard.getFullProductCardAttributes(); //заполнение Data Transfer Object, хранящего данные (данными со страницы товара)
        assertEquals(dtoPageAfterSearch, dtoFullProductCard); //сравнение двух объектов, хранящих данные о товаре
        fullProductCard.addtoCart(); //добавление товара в корзину
        fullProductCard.moveToCart(); //переход в корзину
        CartPage cartPage = new CartPage(); //объявление экземпляра класса новой страницы
        wait(5); //ожидание загрузки
        ProductDto dtoCartPage = cartPage.getCartProductAttributes(); //заполнение Data Transfer Object, хранящего данные (данными о товаре в корзине)
        assertEquals(dtoFullProductCard, dtoCartPage); //сравнение двух объектов, хранящих данные о товаре
    }
}