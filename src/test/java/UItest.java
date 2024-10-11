import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class UItest {

    public ChromeDriver driver;
    public static Selector selector;
    public WebDriverWait wait;

    @Before
    public void setup() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream("application-test.properties")){
            properties.load(resourceStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriverchrome.path"));
        driver = new ChromeDriver();
        selector = new Selector(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, Duration.ofSeconds(3000));

    }

    public void init(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @Test
    public void Test (){
        driver.get("https://e.mail.ru/inbox/");
        init(driver);
        selector.setInputEmail("artem-ryabcev@inbox.ru");
        selector.clickSubmit();
        selector.setInputPass(" ");
        selector.clickSubmit();

        //timeout для прохождения капчи
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@class='compose-button__wrapper']")));

        selector.clickWriteEmail();
        selector.inputAddressEmail("dokuchaev_av@tkbbank.ru");
//        selector.inputAddressEmail("artem-ryabcev@inbox.ru");
        selector.inputMessageSubject("Тестовое задания для Рябцева Артема");
        selector.inputMessage("Добрый день\nРябцев Артем Андреевич\nАвтотест готов");
        selector.sendEmail();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[text()='Письмо отправлено']")));

    }

    @After
    public void close(){
        driver.quit();
    }
}

