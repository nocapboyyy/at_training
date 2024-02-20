import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$$x;


public class PageAfterSearch {

    private final ElementsCollection productCardsPCN = $$x("//span[contains(@class, 'product-card__name')]");

    /**
     * Метод для получения атрибута Product Card Name в карочке товара
     * @return возвращает значение
     */
    public String getPCNFromFirstProduct(){
        String fullProductCardName = productCardsPCN.first().getText();
        String extraSpan = productCardsPCN.first().find(By.tagName("span")).getText();
        return fullProductCardName.replaceFirst(extraSpan, "").trim();
    }

}
