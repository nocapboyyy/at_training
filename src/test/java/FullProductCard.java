import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class FullProductCard {

    private final String pageGridXpath = "//div[@class='product-page__grid']";

    private final String priceAfterDiscountXpath = ".//ins[@class='price-block__final-price']";
    private final String priceXpath = ".//del[@class='price-block__old-price']//span";
    private final String manufacturerXpath = ".//a[@class='product-page__header-brand j-wba-card-item j-wba-card-item-show j-wba-card-item-observe']";
    private final String productNameXpath = ".//h1[@class='product-page__title']";

    @FindBy(xpath = pageGridXpath)
    WebElement productCardGrid;

    private WebElement getAttribute (String attributeXpath){
//        WebDriver driver = new ChromeDriver();
//        WebElement productCardGrid = driver.findElement(By.xpath(gridXpath));

        return productCardGrid.findElement(By.xpath(attributeXpath));
    }

    public ProductDto getFullProductCardAttributes(){
        int priceAfterDiscount = Integer.parseInt(getAttribute(priceAfterDiscountXpath).getText().replaceAll("\\D", ""));
        //int priceAfterDiscount = Integer.parseInt(getAttribute(pageGridXpath, priceAfterDiscountXpath).getText().replaceAll("\\D", ""));
//        int price = Integer.parseInt(getAttribute(pageGridXpath, priceXpath).getText().replaceAll("\\D", ""));
//        String manufacturer = getAttribute(pageGridXpath, manufacturerXpath).getText();
//        String productName = getAttribute(pageGridXpath, productNameXpath).getText();

        ProductDto dto = new ProductDto();
        dto.priceAfterDiscount = priceAfterDiscount;
//        dto.price = price;
//        dto.manufacturer = manufacturer.trim();
//        dto.productName = productName.trim();

        return dto;
    }
}
