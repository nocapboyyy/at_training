import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$$x;


public class PageAfterSearch {

    private final ElementsCollection productCardWrapper = $$x("//div[@class='product-card__wrapper']");

    private final String linkXpath = ".//a[@class='product-card__link j-card-link j-open-full-product-card']";

    private final String priceAfterDiscountXpath = ".//p//span//ins[@class='price__lower-price']";
    private final String priceXpath = ".//p//span//del";
    private final String manufacturerXpath = ".//h2//span[@class='product-card__brand']";
    private final String productNameXpath = ".//h2//span[@class='product-card__name']";
    private final String extraSpanXpath = ".//h2//span[@class='product-card__name']//span";

    private WebElement firstElement = productCardWrapper.first();

    private WebElement findInFirstElement (String xpath){
        return firstElement.findElement(By.xpath(xpath));
    }

    /**
     * Метод для получения атрибута Product Card Name в карочке товара
     * @return возвращает значение
     */
    public ProductDto getProductAttributes(){
        int priceAfterDiscount = Integer.parseInt(findInFirstElement(priceAfterDiscountXpath).getText().replaceAll("\\D", ""));
        int price = Integer.parseInt(findInFirstElement(priceXpath).getText().replaceAll("\\D", ""));
        String manufacturer = findInFirstElement(manufacturerXpath).getText();
        String productName = findInFirstElement(productNameXpath).getText();
        String extraSpan = findInFirstElement(extraSpanXpath).getText();

        ProductDto dto = new ProductDto();
        dto.price = price;
        dto.priceAfterDiscount = priceAfterDiscount;
        dto.manufacturer = manufacturer.trim();
        dto.productName = productName.replaceFirst(extraSpan, "").trim();

        return dto;
    }

    public void moveToFullProductCard(){
        findInFirstElement(productCardWrapper, linkXpath).click();
    }
}