package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

import org.junit.Assert;

public class ProjectStepDefinations {
    WebDriver driver;

    @Before
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.b.kulkarni\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Then("^we are on (.*)$")
    public void pageIdentify(String pageObjectFile) {
        ObjectProperties.initializeObjectProperties(pageObjectFile);
    }

    @Then("^we wait for (.*) seconds$")
    public void explicitWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("we opened amazon site")
    public void we_opened_amazon_site() {
        driver.get("https://www.amazon.in");
    }

    @Then("we should see \"(.*?)\"$")
    public void we_should_see(String object) {
        ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectProperties.getElementProperty(object)));
    }

    @Then("^the title should be \"(.*?)\"$")
    public void titleVerify(String title) throws InterruptedException {
        String currentTitle = driver.getTitle();
        System.err.println(currentTitle);
        Thread.sleep(2000);
        if (!currentTitle.equals(title)) {
            Assert.assertEquals(currentTitle, title);
        }
    }

    @Then("^we click on (.*)$")
    public void click(String object) {
        WebElement objectToClick = driver.findElement(By.xpath(ObjectProperties.getElementProperty(object)));
        ExpectedConditions.elementToBeClickable(objectToClick);
        objectToClick.click();
    }

    @Then("^we enter \"(.*?)\" into the (.*) element")
    public void inputText(String input, String element) {
        try {
            driver.findElement(By.xpath(ObjectProperties.getElementProperty(element))).sendKeys(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterTest(){
        driver.quit();
    }

}