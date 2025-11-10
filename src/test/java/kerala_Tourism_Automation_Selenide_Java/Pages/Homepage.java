package kerala_Tourism_Automation_Selenide_Java.Pages;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.*;
import io.qameta.allure.Step;

	public class Homepage {

	    @Step("Open Home Page")
	    public Homepage openPage(String baseUrl) {
	        open(baseUrl + "index.html");
	        webdriver().shouldHave(title("Kerala Tourism"));
	        return this;
	    }

	    @Step("Click on main menu link: {0}")
	    public Homepage clickMenu(String href, String expectedHeader) {
	        $x("//nav[@class='navbar']//a[@href='" + href + "']").click();
	        $x("//h1").shouldHave(text(expectedHeader));
	        return this;
	    }
	}