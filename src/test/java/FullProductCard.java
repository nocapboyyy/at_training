import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class FullProductCard {

//    private final String priceAfterDiscountXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div/div[3]/div[13]/div/div[1]/div[2]/div/div/div/p/span/span";
//    private final String priceWithoutDiscountXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div/div[3]/div[13]/div/div[1]/div[2]/div/div/div/p/del/span";
//    private final String manufacturerXpath = ".//a[contains(@class, 'product-page__header-brand')]";
//    private final String productNameXpath = ".//h1[@class='product-page__title']";
//    private final String addToCartButtonXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div/div[3]/div[13]/div/div[1]/div[5]/div/div/button[1]";
//    private final String moveToCartButtonXpath = ".//a[@data-wba-header-name='Cart']";

    public ProductDto getFullProductCardAttributes(){
        int priceAfterDiscount = Integer.parseInt($(By.xpath("/html/body/div[1]/main/div[2]/div/div[3]/div/div[3]/div[14]/div/div[1]/div[2]/div/div/div/p/span/span")).shouldBe(exist).getText().replaceAll("\\D", ""));
        int priceWithoutDiscount = Integer.parseInt($(By.xpath("/html/body/div[1]/main/div[2]/div/div[3]/div/div[3]/div[14]/div/div[1]/div[2]/div/div/div/p/del/span")).shouldBe(exist).getText().replaceAll("\\D", ""));
        String manufacturer = $(By.xpath(".//a[contains(@class, 'product-page__header-brand')]")).shouldBe(exist).getText();
        String productName = $(By.xpath(".//h1[@class='product-page__title']")).shouldBe(exist).getText();



        ProductDto dto = new ProductDto();
        dto.priceAfterDiscount = priceAfterDiscount;
        dto.priceWithoutDiscount = priceWithoutDiscount;
        dto.manufacturer = manufacturer.trim();
        dto.productName = productName.trim();

        return dto;
    }

    public void addtoCart(){
        $(By.xpath("/html/body/div[1]/main/div[2]/div/div[3]/div/div[3]/div[14]/div/div[1]/div[5]/div/div/button[1]")).click();
    }

    public void moveToCart(){
        $(By.xpath(".//a[@data-wba-header-name='Cart']")).click();
    }
}
