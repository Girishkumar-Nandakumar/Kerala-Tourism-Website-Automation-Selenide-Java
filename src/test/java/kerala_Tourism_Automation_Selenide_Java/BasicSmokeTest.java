package kerala_Tourism_Automation_Selenide_Java;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class BasicSmokeTest extends Base {

	
		    @Test(priority = 1, groups = {"Smoke"})
		    public void homePageValidation() {
		        System.out.println("Navigating to: " + BASE_URL + "index.html");
		        open(BASE_URL + "index.html");

		        // URL & Title Validation
		        webdriver().shouldHave(url(BASE_URL + "index.html"));
		        title().equals("Kerala Tourism");
		        System.out.println("✅ URL and Title validation passed!");

		        // Element visibility checks
		        $x("//img[@src='img/kerala-tourism-title.png']").shouldBe(visible);
		        System.out.println("✅ Logo is visible!");

		        $x("//nav[@class='navbar navbar-expand-lg']").shouldBe(visible);
		        System.out.println("✅ Navigation bar is visible!");

		        System.out.println("🎉 Home page smoke test completed successfully!");
		    }

		    @Test(priority = 2, groups = {"Smoke"})
		    public void basicNavigationThroughMainMenu() {
		        open(BASE_URL + "index.html");

		        // Home link
		        $("nav.navbar a[href='index.html']").click();
		        webdriver().shouldHave(url(BASE_URL + "index.html"));
		        System.out.println("✅ Home navigation validated!");

		        // Explore (About) link
		        $("nav.navbar a[href='about.html']").click();
		        $("h1").shouldHave(text("At a glance"));
		        System.out.println("✅ Explore navigation validated!");

		        $("nav.navbar a[href='login.html']").click();
		        $("h1").shouldHave(text("Login"));
		        System.out.println("✅ Login page navigation validated!");

		        $("nav.navbar a[href='signup.html']").click();
		        $("h1").shouldHave(text("Sign up"));
		        System.out.println("✅ Sign up page navigation validated!");

		        System.out.println("🎉 Navigation Bar completed successfully!");
		    }

		    @Test(priority = 3, groups = {"Smoke"})
		    public void validatingExplorePage() {
		        open(BASE_URL + "about.html");

		        webdriver().shouldHave(url(BASE_URL + "about.html"));
		        $("title").shouldHave(attribute("text", "At a glance"));
		        System.out.println("✅ Explore page title and URL validation passed!");

		        $x("//a[text()='Places To Visit']").scrollTo().click();

		        webdriver().shouldHave(url(BASE_URL + "districts.html"));
		        $("title").shouldHave(attribute("text", "Districts"));
		        System.out.println("✅ Districts page title and URL validation passed!");
		    }

		    @DataProvider(name = "districtPages")
		    public Object[][] getDistrictPages() {
		        return new Object[][]{
		                {"palakkad.html", "palakkad"},
		                {"thrissur.html", "Thrissur"},
		                {"malappuram.html", "malappuram"},
		                {"trivandrum.html", "Trivandrum"},
		                {"kollam.html", "kollam"},
		                {"kozhikode.html", "kozhikode"},
		                {"pathanamthitta.html", "Pathanamthitta"},
		                {"wayanad.html", "wayanad"},
		                {"alappuzha.html", "alappuzha"},
		                {"kannur.html", "Kannur"},
		                {"kottayam.html", "kottayam"},
		                {"iduki.html", "Iduki"},
		                {"ernakulam.html", "ernakulam"},
		                {"kasargod.html", "Kasargod"}
		        };
		    }

		    @Test(dataProvider = "districtPages", groups = {"Smoke"}, priority = 4)
		    public void validateIndividualDistrictPages(String path, String expectedTitle) {
		        open(BASE_URL + path);
		        $("title").shouldHave(attribute("text", expectedTitle));
		        System.out.println("✅ Title validation for " + expectedTitle + " page passed!");
		    }

		    @Test(priority = 5, groups = {"Smoke"})
		    public void validatingLoginPage() {
		        open(BASE_URL + "login.html");
		        webdriver().shouldHave(url(BASE_URL + "login.html"));
		        $("title").shouldHave(attribute("text", "Login"));
		        System.out.println("✅ Login page validation passed!");
		    }

		    @Test(priority = 6, groups = {"Smoke"})
		    public void validatingSignupPage() {
		        open(BASE_URL + "signup.html");
		        webdriver().shouldHave(url(BASE_URL + "signup.html"));
		        $("title").shouldHave(attribute("text", "Sign up"));
		        System.out.println("✅ Signup page validation passed!");
		    }
		}