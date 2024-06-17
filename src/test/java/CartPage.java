import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final String priceAfterDiscountXpath = ".//div[@class='list-item__price-wallet']";
    private final String priceWithoutDiscountXpath = ".//div[@class='list-item__price-new wallet']";
    private final String manufacturerXpath = ".//span[@class='good-info__good-brand ']";
    private final String productNameXpath = ".//span[@class='good-info__good-name']";

    public ProductDto getCartProductAttributes(){
        int priceAfterDiscount = Integer.parseInt($(By.xpath(priceAfterDiscountXpath)).getText().replaceAll("\\D", ""));
        int priceWithoutDiscount = Integer.parseInt($(By.xpath(priceWithoutDiscountXpath)).getText().replaceAll("\\D", ""));
        String manufacturer = $(By.xpath(manufacturerXpath)).getText();
        String productName = $(By.xpath(productNameXpath)).getText();

        ProductDto dto = new ProductDto();
        dto.priceAfterDiscount = priceAfterDiscount;
        dto.priceWithoutDiscount = priceWithoutDiscount;
        dto.manufacturer = manufacturer.trim();
        dto.productName = productName.trim();

        return dto;
    }
}