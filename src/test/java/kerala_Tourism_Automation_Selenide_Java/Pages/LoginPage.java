package kerala_Tourism_Automation_Selenide_Java.Pages;

import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;
import static com.codeborne.selenide.WebDriverConditions.*;

public class LoginPage {

	    // ------------------ Page Actions ------------------

	    @Step("Open Login Page")
	    public LoginPage openPage(String baseUrl) {
	        open(baseUrl + "login.html");
	        webdriver().shouldHave(title("Login"));
	        return this;
	    }

	    @Step("Fill Login Form with Email={0} and Password={1}")
	    public LoginPage fillLoginForm(String emailValue, String passwordValue) {
	        $("input#email").setValue(emailValue);
	        $("input#password").setValue(passwordValue);
	        return this;
	    }

	    @Step("Click Submit button")
	    public void submit() {
	        $("button[type='submit']").click();
	    }

	    @Step("Handle alert if present")
	    public void handleAlert() {
	        try {
	            switchTo().alert().accept();
	        } catch (Exception e) {
	            System.out.println("⚠️ No alert present to handle");
	        }
	    }

	    @Step("Perform normal login with valid credentials")
	    public void login(String email, String password) {
	        fillLoginForm(email, password);
	        submit();
	    }
	}