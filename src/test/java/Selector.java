import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selector {

    public WebDriver driver;

    public Selector(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement inputPass;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement clickSubmit;

    @FindBy(xpath = "//span[@class='compose-button__wrapper']")
    WebElement clickWriteEmail;

    @FindBy(xpath = "//div[@data-name='to']//input")
    WebElement inputAddressEmail;

    @FindBy(xpath = "//input[@name='Subject']")
    WebElement inputMessageSubject;

    @FindBy(xpath = "//div[@role='textbox']//div")
    WebElement inputMessage;

    @FindBy(xpath = "//button[@data-test-id='send']")
    WebElement sendEmail;



    public void setInputEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void setInputPass(String pass) {
        inputPass.sendKeys(pass);
    }

    public void clickSubmit() {
        clickSubmit.click();
    }

    public void clickWriteEmail() {
        clickWriteEmail.click();
    }

    public void inputAddressEmail(String addressEmail) {
        inputAddressEmail.sendKeys(addressEmail);
    }

    public void inputMessageSubject(String messageSubject) {
        inputMessageSubject.sendKeys(messageSubject);
    }

    public void inputMessage(String message){
        inputMessage.sendKeys(message);
    }

    public void sendEmail(){
        sendEmail.click();
    }

}
