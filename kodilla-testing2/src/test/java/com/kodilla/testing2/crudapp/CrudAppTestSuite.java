package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CrudAppTestSuite {
    public static final String BASE_URL = "https://mwydra.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests(){
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    private String createCruddAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement button = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        button.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException{
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                    anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }

    private void deleteCruddAppTestTask(String taskName) throws InterruptedException {
        try {
            // Add a wait timeout before this statement to make
            // sure you are not checking for the alert too soon.
            Alert alt = driver.switchTo().alert();
            alt.accept();
        } catch(NoAlertPresentException noe) {
            // No alert found on page, proceed with test.
        }

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement buttonDelete =
                            theForm.findElement(By.xpath(".//button[4]"));
                    buttonDelete.click();
                });
        Thread.sleep(5000);
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCruddAppTestTask();
        sendTestTaskToTrello(taskName);
        deleteCruddAppTestTask(taskName);
    }

    @After
    public void cleanUpAfterTest(){
        driver.close();
    }
}
