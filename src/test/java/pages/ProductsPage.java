package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Locale;

public class ProductsPage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public ProductsPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver, wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='sort']")
    WebElement sortBy;


    String productPriceXpath = "//div[contains(@class, 'product-items-main')]/div[$]//span[@class='ppra_price-number']";


    public void sortBy(String sortingMethod) throws InterruptedException {
        selectByValue(sortBy, sortingMethod);
        Thread.sleep(5000);
    }

    public void assertPriceAppending() {
        int cena1 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "1"))).getText().replace(".", ""));
        int cena2 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "2"))).getText().replace(".", ""));

        Assert.assertTrue(cena1 <= cena2);

    }

    public void assertPriceDescending() {
        int cena1 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "1"))).getText().replace(".", ""));
        int cena2 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "2"))).getText().replace(".", ""));

        Assert.assertTrue(cena1 >= cena2);

    }

    public void assertNameAppending() {

        String naziv1 = driver.findElement(By.xpath(productPriceXpath.replace("$", "1"))).getText().toLowerCase(Locale.ROOT).replace(".", "");
        String naziv2 = driver.findElement(By.xpath(productPriceXpath.replace("$", "2"))).getText().toLowerCase(Locale.ROOT).replace(".", "");

        int comparedResult = naziv1.compareTo(naziv2);

        if (comparedResult > 0) {
            System.out.println(naziv1 + " comes after " + naziv2);
        } else if (comparedResult < 0) {
            System.out.println(naziv1 + " comes before " + naziv2);
        } else {
            System.out.println(naziv1 + " is equal to " + naziv2);
        }
    }

    public void verifyItemsAreSorted(String sortingMethod) throws Exception {

        switch (sortingMethod) {
            case "rastuci": {
                assertPriceAppending();
            }
            break;
            case "opadajuci": {
                assertPriceDescending();

            }
            break;
            case "naziv": {
                assertNameAppending();
            }
            break;
            case "rejting": {

                break;
            }
            case "scope": {

            }
            break;
            default:
                throw new Exception("Sorting option not supported");
        }

    }
}