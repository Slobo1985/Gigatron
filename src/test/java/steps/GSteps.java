package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsPage;
import tests.BaseTest;

import java.io.IOException;


public class GSteps extends BaseTest {

    @Before
    public void initCucumber(){
        init("Chrome","96",30);
    }

    @After
    public void tearDown() throws IOException {
//        reportScreenshot("Test", "TestAllure");
//        quitDriver();
    }


    @Given("I am on products page")
    public void iAmOnProductsPage() {
        driver.get("https://gigatron.rs/tv-audio-video/slusalice");
    }

    @When("I click sort by {string}")
    public void iClickSortBy(String sortingMethod) throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver,wdWait);
        productsPage.sortBy(sortingMethod);

    }

    @Then("I should see product sorted {string}")
    public void iShouldSeeProductSorted(String sortingMethod) throws Exception {
        ProductsPage productsPage = new ProductsPage(driver,wdWait);
        productsPage.verifyItemsAreSorted(sortingMethod);
    }


}
