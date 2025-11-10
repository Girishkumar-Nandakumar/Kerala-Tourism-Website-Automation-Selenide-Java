package kerala_Tourism_Automation_Selenide_Java;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import kerala_Tourism_Automation_Selenide_Java.Pages.SignupPage;


public class FormValidation extends Base{

	    private final String name = "Sherlock Holmes";
	    private final String email = "holmes_Sherlock@geemail.com";
	    private final String phone = "1234567890";
	    private final String password = "221B@BakeRStreeT";

	    kerala_Tourism_Automation_Selenide_Java.Pages.LoginPage loginPage = new kerala_Tourism_Automation_Selenide_Java.Pages.LoginPage();
	    SignupPage signUpPage = new SignupPage();

	

	    @Test(description = "Valid login")
	    @Description("Login with valid credentials")
	    public void validatingLoginForm() {
	        loginPage.openPage(BASE_URL)
	                 .login(email, password);
	    }

	    @Test(groups = {"FormValidation"})
	    public void loginEmptyEmail() {
	        loginPage.openPage(BASE_URL)
	                 .fillLoginForm("", password)
	                 .submit();
	        loginPage.handleAlert();
	    }

	    @Test(groups = {"FormValidation"})
	    public void loginEmptyPassword() {
	        loginPage.openPage(BASE_URL)
	                 .fillLoginForm(email, "")
	                 .submit();
	        loginPage.handleAlert();
	    }

	    @Test(groups = {"FormValidation"})
	    public void loginBothEmptyFields() {
	        loginPage.openPage(BASE_URL)
	                 .fillLoginForm("", "")
	                 .submit();
	        loginPage.handleAlert();
	    }

	    @Test(groups = {"FormValidation"})
	    public void loginInvalidEmail() {
	        loginPage.openPage(BASE_URL)
	                 .fillLoginForm("invalid_email@", password)
	                 .submit();
	        loginPage.handleAlert();
	    }

	    @Test(groups = {"FormValidation"})
	    public void loginInvalidPassword() {
	        loginPage.openPage(BASE_URL)
	                 .fillLoginForm(email, "wrongPassword123")
	                 .submit();
	        loginPage.handleAlert();
	    }


	    @Test(groups = {"FormValidation"})
	    public void signupEmptyName() {
	        signUpPage.openPage(BASE_URL)
	                  .fillForm("", email, phone, password, password)
	                  .submit();
	        signUpPage.handleAlert();
	    }

	    @Test(groups = {"FormValidation"})
	    public void signupEmptyEmail() {
	        signUpPage.openPage(BASE_URL)
	                  .fillForm(name, "", phone, password, password)
	                  .submit();
	        signUpPage.handleAlert();
	    }

	    @Test(groups = {"FormValidation"})
	    public void signupEmptyPassword1() {
	        signUpPage.openPage(BASE_URL)
	                  .fillForm(name, email, phone, "", password)
	                  .submit();
	        signUpPage.handleAlert();
	    }

	    @Test(groups = {"FormValidation"})
	    public void signupEmptyPassword2() {
	        signUpPage.openPage(BASE_URL)
	                  .fillForm(name, email, phone, password, "")
	                  .submit();
	        signUpPage.handleAlert();
	    }

	    @Test(groups = {"FormValidation"})
	    public void signupPasswordMismatch() {
	        signUpPage.openPage(BASE_URL)
	                  .fillForm(name, email, phone, password, "PASSword@1234")
	                  .submit();
	        signUpPage.handleAlert();
	    }
	}