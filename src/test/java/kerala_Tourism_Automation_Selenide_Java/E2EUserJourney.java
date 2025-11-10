package kerala_Tourism_Automation_Selenide_Java;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Description;
import kerala_Tourism_Automation_Selenide_Java.Pages.DistrictsPage;
import kerala_Tourism_Automation_Selenide_Java.Pages.Homepage;
import kerala_Tourism_Automation_Selenide_Java.Pages.LoginPage;
import kerala_Tourism_Automation_Selenide_Java.Pages.SignupPage;

public class E2EUserJourney extends Base{

	    private final String name = "Sherlock Holmes";
	    private final String email = "holmes_Sherlock@geemail.com";
	    private final String phone = "1234567890";
	    private final String password = "221B@BakeRStreeT";

	    Homepage homePage = new Homepage();
	    SignupPage signUpPage = new SignupPage();
	    LoginPage loginPage = new LoginPage();
	    DistrictsPage districtPage = new DistrictsPage();

	    @Test(priority = 1, groups = {"E2E"})
	    @Description("Verify Home Page loads successfully")
	    public void verifyHomePage() {
	        homePage.openPage(BASE_URL);
	    }

	    @Test(priority = 2, dependsOnMethods = "verifyHomePage", groups = {"E2E"})
	    @Description("Perform Sign-Up with new user")
	    public void performSignUp() {
	        signUpPage.openPage(BASE_URL)
	                  .signUp(name, email, phone, password);
	    }

	    @Test(priority = 3, dependsOnMethods = "performSignUp", groups = {"E2E"})
	    @Description("Perform Login with registered user")
	    public void performLogin() {
	        loginPage.openPage(BASE_URL)
	                 .login(email, password);
	    }

	    @Test(priority = 4, dependsOnMethods = "performLogin", groups = {"E2E"})
	    @Description("Explore District Pages")
	    public void exploreDistricts() {
	        districtPage.open(BASE_URL, "palakkad.html", "Palakkad");
	        back();
	        districtPage.open(BASE_URL, "thrissur.html", "Thrissur");
	        back();
	    }
	}
