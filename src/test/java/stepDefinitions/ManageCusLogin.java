package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ManageCusLogin {
    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");

    // Check login successfully with select correct username
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("Xin chao ....");
        System.setProperty("webdriver.chrome.driver", projectPath + "/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Given("verify login page")
    public void verify_login_page() throws Throwable {
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        //Verify title
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "XYZ Bank");
        Thread.sleep(2 * 1000);
    }

    @When("click customer login button")
    public void click_customer_login_button() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/button")).click();
        Thread.sleep(2 * 1000);
    }

    @When("select correct username")
    public void select_correct_username() throws Throwable {
//        driver.findElement(By.id("userSelect")).click();
//        driver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[2]")).click();
//        Thread.sleep(1000);
        Select se = new Select(driver.findElement(By.id("userSelect")));
        se.selectByValue("2");
    }

    @And("click on login button")
    public void click_on_login_button() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/button")).click();
        Thread.sleep(2 * 1000);
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {

    }

    //Verify that user Deposit successfully with input valid amount
    @When("click on Deposit")
    public void click_on_deposit() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/button[2]")).click();
        Thread.sleep(2 * 1000);
    }

    //Verify that user Deposit failed with input invalid amount

    @When("enter valid {int} to be deposit")
    public void enter_valid_to_be_deposit(Integer int1) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(int1.toString(int1));
        Thread.sleep(1000);
    }
    @And("enter invalid mount to be deposit")
    public void enter_invalid_mount_to_be_deposit() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("-2000");
        Thread.sleep(1000);
    }


    @And("click on deposit button")
    public void click_on_deposit_button() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/button")).click();
    }

    @Then("message is displayed")
    public void message_is_display() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Successfully excution");
    }

    //Verify that user Withdrawl successfully with input valid amount
    @And("click on withdrawl")
    public void click_on_withdrawl() throws Throwable {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
        Thread.sleep(2 * 1000);
    }

    @When("enter valid {int} to be withdrawl")
    public void enter_valid_to_be_withdrawl(Integer int2) throws InterruptedException {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")).sendKeys(int2.toString(int2));
        Thread.sleep(2 * 1000);
    }
    // Verify that user Withdrawl with input invalid amount (character, Number 0, Negative number)

    @When("enter invalid mount to be withdrawl")
    public void enter_invalid_mount_to_be_withdrawl() throws Throwable {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")).sendKeys("-2000");
        Thread.sleep(1000);
    }
    @And("click on withdrawl button")
    public void click_on_withdrawl_button() {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")).click();
    }

    //Verify that user can see old transaction when click on "Transaction" button
    @And("click on transaction button")
    public void click_on_transaction_button() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/button[1]")).click();
        Thread.sleep(2 * 1000);
    }

    //Verify that user can back homepage when click on "Back" button
    @And("click on back button")
    public void click_on_back_button() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[1]")).click();
        Thread.sleep(2 * 1000);
    }
   // Verify that user can reset transation page when click on "Reset" button
   @And("click on reset button")
   public void click_on_reset_button() throws Throwable {
       driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[2]")).click();
       Thread.sleep(2 * 1000);
   }
}
