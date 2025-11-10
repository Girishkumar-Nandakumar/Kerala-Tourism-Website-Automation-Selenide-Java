package kerala_Tourism_Automation_Selenide_Java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import io.qameta.allure.selenide.AllureSelenide;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;

public class Base {

	    protected final String BASE_URL = "https://hashirakb.github.io/Kerala-Tourism-Website/";

	    @Parameters({"browser"})
	    @BeforeClass(alwaysRun = true)
	    public void setUp(@org.testng.annotations.Optional("chrome") String browser) {

	        // Set browser type dynamically (chrome, firefox, edge)
	        Configuration.browser = browser.toLowerCase();
	        //Configuration.startMaximized = true;
	        Configuration.timeout = 8000;
	        Configuration.screenshots = true;
	        Configuration.savePageSource = false;

	        // Allure Selenide Listener: captures screenshots and logs for Allure reports
	        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
	                .screenshots(true)
	                .savePageSource(false)
	                .enableLogs(true));

	        System.out.println("🚀 Running tests on browser: " + Configuration.browser.toUpperCase());
	    }

	    @AfterClass(alwaysRun = true)
	    public void tearDown() {
	        closeWebDriver();
	        System.out.println("🧹 Browser closed successfully.");
	    }
	}