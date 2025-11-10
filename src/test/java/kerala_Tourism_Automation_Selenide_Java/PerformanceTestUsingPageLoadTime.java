package kerala_Tourism_Automation_Selenide_Java;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class PerformanceTestUsingPageLoadTime extends Base{

	    @Test(description = "Measure page load time for multiple pages")
	    public void measurePageLoadTime() {

	        String[] urls = {
	            BASE_URL + "index.html",
	            BASE_URL + "about.html",
	            BASE_URL + "districts.html",
	            BASE_URL + "login.html",
	            BASE_URL + "signup.html"
	        };

	        System.out.println("\n🚀 Starting Page Load Performance Test\n");

	        for (String url : urls) {
	            System.out.println("Navigating to: " + url);

	            long start = System.currentTimeMillis();
	            open(url);
	            long finish = System.currentTimeMillis();

	            long totalTime = finish - start;

	          
	            if (totalTime < 1500) {
	                System.out.println("✅ Fast: " + totalTime + " ms\n");
	            } else if (totalTime < 3000) {
	                System.out.println("⚠️ Moderate: " + totalTime + " ms\n");
	            } else {
	                System.out.println("❌ Slow: " + totalTime + " ms\n");
	            }
	        }

	        System.out.println("🎯 Page Load Performance Test Completed!\n");
	    }
	}
