package kerala_Tourism_Automation_Selenide_Java.Pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;
import io.qameta.allure.Step;

public class DistrictsPage {

	    @Step("Navigate to District Page: {0}")
	    public DistrictsPage open(String baseUrl, String path, String expectedTitle) {
	        open(baseUrl + path, expectedTitle, expectedTitle);
	        webdriver().shouldHave(title(expectedTitle));
	        return this;
	    }
	}