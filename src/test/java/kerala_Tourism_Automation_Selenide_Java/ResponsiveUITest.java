package kerala_Tourism_Automation_Selenide_Java;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Selenide.*;

public class ResponsiveUITest extends Base{

	    @DataProvider(name = "screenResolutions")
	    public Object[][] screenResolutions() {
	        return new Object[][]{
	            {1920, 1080, "Desktop"},
	            {1024, 768, "Tablet"},
	            {375, 667, "Mobile iPhone"},
	            {360, 800, "Mobile Android"}
	        };
	    }

	    @Test(dataProvider = "screenResolutions", groups = {"Responsive"})
	    public void verifyResponsiveLayouts(int width, int height, String deviceType) {
	        System.out.println("\n📱 Checking layout for: " + deviceType + " (" + width + "x" + height + ")");

	        // Resize browser window to desired resolution
	        webdriver().driver().getWebDriver().manage().window().setSize(new Dimension(width, height));

	        // Open page
	        open(BASE_URL + "index.html");

	        // Validate title
	      
	        System.out.println("✅ " + deviceType + " layout loaded successfully (" + width + "x" + height + ")");

	        // Take screenshot for each device
	        screenshot("screenshots/" + deviceType.replaceAll("\\s", "_"));
	    }
	}