package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.AmazonPage;

public class AmazonStep {

    AmazonPage amazonPage = new AmazonPage();

    @Given("the user navigate to amazon")
    public void theUserNavigateToWwwAmazonCom() {
        amazonPage.navigateToAmazon();
    }
    @When("Searches for {string}")
    public void searchesForAlexa(String product) {
        amazonPage.searchProduct(product);
    }
    @And("navigates to the second pages")
    public void navigatesToTheSecondPages() {
        amazonPage.navigatePage();
    }
    @And("selects the third item")
    public void selectsTheThirdItem() {
        amazonPage.selectItem();
    }
    @Then("the user is able to add it to the cart")
    public void theUserIsAbleToAddItToTheCart() {
        Assert.assertEquals("Agregar al Carrito",amazonPage.validateCart());
    }

}
