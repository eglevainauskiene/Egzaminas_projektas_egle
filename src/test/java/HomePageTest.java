import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @Test
    void userCanSubmitFormWithAllCorrectData() {
        homePage = new HomePage(driver);
        String FullName = DataGenerator.getRandomFulName();
        String Email = DataGenerator.getRandomEmail();
        String Phone = DataGenerator.getRandomPhoneNumber();
        String message = DataGenerator.getRandomMessage();
        int yearsOfExperience = DataGenerator.getRandomYearOfExperience();
        homePage.writeToFullNameInput(FullName);
        homePage.writeToEmailInput(Email);
        homePage.writeToPhoneInput(Phone);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.selectDropDownGender();
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.SelectYearOfExperience(yearsOfExperience);
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.SelectRandomSkills(homePage.getRandomSkills(7, 9));
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.selectDropDownQATools();
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.writeToContactForm(message);
        homePage.clickSubmit();
        assertEquals("Your message has been sent", homePage.getSuccessContactFormMessageText());

    }
    @Test
    void userCannotSubmitFormWithIncorrectEmail() {
        homePage = new HomePage(driver);
        String FullName = DataGenerator.getRandomFulName();
        String Email = "a";
        String Phone = DataGenerator.getRandomPhoneNumber();
        String message = DataGenerator.getRandomMessage();
        int yearsOfExperience = DataGenerator.getRandomYearOfExperience();
        homePage.writeToFullNameInput(FullName);
        homePage.writeToEmailInput(Email);
        homePage.writeToPhoneInput(Phone);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.selectDropDownGender();
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.SelectYearOfExperience(yearsOfExperience);
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.SelectRandomSkills(homePage.getRandomSkills(7, 9));
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.selectDropDownQATools();
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.writeToContactForm(message);
        homePage.clickSubmit();
        assertTrue(homePage.getIncorrectMailErrorMessageIsDisplayed());
        assertTrue(homePage.getWarningMessageEmailRequiredIsDisplayed());

    }
    @Test
    void userCannotSubmitFormWithoutTheRequiredFields() {
        homePage = new HomePage(driver);
        String Phone = DataGenerator.getRandomPhoneNumber();
        String message = DataGenerator.getRandomMessage();
        int yearsOfExperience = DataGenerator.getRandomYearOfExperience();
        homePage.writeToPhoneInput(Phone);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.selectDropDownGender();
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.SelectYearOfExperience(yearsOfExperience);
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.SelectRandomSkills(homePage.getRandomSkills(7, 9));
        //homePage.SelectRandomSkills(homePage.getRandomSkills(6, 8));
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.selectDropDownQATools();
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.writeToContactForm(message);
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.clickSubmit();
        assertTrue(homePage.getFullNameErrorIsDisplayed());
        assertTrue(homePage.getWarningMessageEmailRequiredIsDisplayed());

    }
    @Test
    void userCanSelectTwoSkills() throws InterruptedException {
        homePage = new HomePage(driver);
        int yearsOfExperience = DataGenerator.getRandomYearOfExperience();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,700)", "");
        homePage.SelectYearOfExperience(yearsOfExperience);
        jse.executeScript("window.scrollBy(0,250)", "");
        homePage.SelectRandomSkills(homePage.getRandomSkills(7, 9));
        Thread.sleep(3000);
        homePage.SelectRandomSkills(homePage.getRandomSkills(7, 9));

    }
}
