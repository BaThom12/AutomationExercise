package com.vmo.automationexercise.Register;

import com.vmo.automationexercise.common.BaseTest;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.helper.TestNGListener;
import com.vmo.automationexercise.interfaces.HomePageUI;
import com.vmo.automationexercise.pageobject.HomePageObject;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("Demowebshop")
@Feature("Login")
@Story("Login by excel data")
@Listeners(TestNGListener.class)
public class LoginTest extends BaseTest {
    private static WebDriver driver;
   // private LoginPageObject login;
    private HomePageObject home;

    @Parameters({"browser","runType"})
    @BeforeClass
    public void setup(String browser, String type) {
      //  driver = getDriverBrowser(browser,type);
        driver.manage().window().maximize();
        Log.info("Open browser");
      //  driver.get(HomePageUI.LOCATOR_DEMOWEBSHOP_URL);
        Log.info("Open Demo shop");
       // login = new LoginPageObject(driver);
      //  home = new HomePageObject(driver);
    }

   /* @Test(dataProvider = "getInforLogin", dataProviderClass = ExcelConfig.class)
    public void Login_TC01_GetDataFromExcel(String STT, String username, String password, String expect) throws StackOverflowError {
        home.verifyOnHomePage(driver);
        login.verifyOnLoginPage(driver);
        login.enterUserPass(username,password);
        login.verifyResultLogin(expect);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
