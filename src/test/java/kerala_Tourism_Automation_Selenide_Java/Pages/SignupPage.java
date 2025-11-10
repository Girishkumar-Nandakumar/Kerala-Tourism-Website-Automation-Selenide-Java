package kerala_Tourism_Automation_Selenide_Java.Pages;


import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;


public class SignupPage {

	    // ------------------ Page Actions ------------------

	    @Step("Open Sign Up Page")
	    public SignupPage openPage(String baseUrl) {
	        open(baseUrl + "signup.html");
	        return this;
	    }

	    @Step("Fill Sign Up Form: Name={0}, Email={1}, Phone={2}")
	    public SignupPage fillForm(String name, String email, String phone, String password1, String password2) {
	        $("input[name='name']").setValue(name);
	        $("input[type='email']").setValue(email);
	        $("input#phone").setValue(phone);
	        $("input#password1").setValue(password1);
	        $("input#password2").setValue(password2);
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

	    @Step("Perform normal signup with valid data")
	    public void signUp(String name, String email, String phone, String password) {
	        fillForm(name, email, phone, password, password);
	        submit();
	    }
	}

