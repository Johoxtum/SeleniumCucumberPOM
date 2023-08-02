package pages;

public class AmazonPage extends BasePage{

    String inputSearch = "//input[@id='twotabsearchtextbox']";
    String submit = "//input[@id='nav-search-submit-button']";
    String item = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img";
    String addCart = "//span[@id='submit.add-to-cart-announce']";

    public AmazonPage() {
        super(driver);
    }
    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com/");
    }
    public void searchProduct(String text){
        write(inputSearch,text);
        clickElement(submit);
    }
    public void navigatePage(){
        goToLinkText("2");
    }
    public void selectItem(){
        clickElement(item);
    }
    public String validateCart(){
        return textFromElement(addCart);
    }
}
