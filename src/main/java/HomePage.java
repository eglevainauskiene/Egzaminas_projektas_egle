import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage{
    @FindBy(css = "#g4072-fullname")
    private WebElement fullNameInput;
    @FindBy(css = "#g4072-email")
    private WebElement emailInput;
    @FindBy(css = "#g4072-phonenumber")
    private WebElement phoneInput;
    @FindBy(css = "#g4072-gender")
    private WebElement genderDropDown;
    @FindBy(css = ".contact-form-field>input")
    private List<WebElement> experienceSkillsList;
    @FindBy(css = "#g4072-qatools")
    private WebElement QADropDown;
    @FindBy(css = "#contact-form-comment-g4072-otherdetails")
    private WebElement contactForm;
    @FindBy(css = " button[data-id-attr='placeholder']")
    private WebElement buttonSubmit;
    @FindBy(css = "#contact-form-success-header")
    private WebElement successContactFormMessage;
    @FindBy(css = "#g4072-email-error")
    private WebElement incorrectMailErrorMessage;
    @FindBy(css = "a[href='#g4072-email']")
    private WebElement warningMessageEmailRequired;
    @FindBy(css = "#g4072-fullname-error")
    private WebElement fullNameError;
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void writeToFullNameInput(String name)
    {
        fullNameInput.sendKeys(name);
    }
    public void writeToEmailInput(String email)
    {
        emailInput.sendKeys(email);
    }
    public void writeToPhoneInput(String phone)
    {
        phoneInput.sendKeys(phone);
    }

public void selectDropDownGender()
{
    Select dropdownGender = new Select(genderDropDown);
    dropdownGender.selectByVisibleText("Male");
}
    public void SelectYearOfExperience(int nr) {
        experienceSkillsList.get(nr).click();
    }

    public int getRandomSkills(int start, int end)
    {
        Random rnd = new Random();
        return start+(int)(Math.random() * ((end -start)+1));

    }
public void SelectRandomSkills(int nr) {
    experienceSkillsList.get(nr).click();
}
    public void selectDropDownQATools()
    {
        Select dropdownQATools = new Select(QADropDown);
        dropdownQATools.selectByVisibleText("Appium");
    }
    public void writeToContactForm(String message)
    {
        contactForm.sendKeys(message);
    }
    public void clickSubmit()
    {
        buttonSubmit.click();
    }
    public String getSuccessContactFormMessageText()
    {
       return successContactFormMessage.getText();
    }
    public boolean getIncorrectMailErrorMessageIsDisplayed()
    {
        return incorrectMailErrorMessage.isDisplayed();
    }
    public boolean getWarningMessageEmailRequiredIsDisplayed()
    {
        return warningMessageEmailRequired.isDisplayed();
    }
    public boolean getFullNameErrorIsDisplayed()
    {
        return fullNameError.isDisplayed();
    }
}
