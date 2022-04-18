package MyStepDefinitions;

import Data.ExcelHelpers;
import PageObjects.loginObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import setUp.setUp;

import java.time.Duration;

@RunWith(Cucumber.class)
public class loginStep<LoginHelpers> extends setUp {

    //setUp setup = new setUp();
    loginObjects loginOb = new loginObjects(driver);
    ExcelHelpers excel = new ExcelHelpers();


    @Given("^User go to page$")
    public void user_go_to_page() throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //excel.setExcelFile("src/test/resources/fileExcel/Book1.xlsx", "Sheet1");

    }

    @When("^User login into application with (.+) and (.+)$")
    public void user_login_into_application_with_and(String email, String password) throws Throwable {

        //Setup đường dẫn của file excel

        excel.setExcelFile("src/test/resources/fileExcel/Book1.xlsx", "Sheet1");
        for (int i = 1; i < 6; i++) {
            loginOb.ContactUsForm(excel.getCellData("email", i), excel.getCellData("password", i));
            loginOb.btnSubmit.click();
            Thread.sleep(2000);
            //Assert.assertEquals(strArg1, loginOb.WrongTitle.getText());

            String Tile = "Wrong email or password.";
            Assert.assertEquals(Tile, loginOb.WrongTitle.getText());
            loginOb.txtemail.clear();
            loginOb.txtpassword.clear();

            //loginOb.ContactUsForm();
        }

        // Ghi nhiều dòng vào file
        for (int i = 0; i < 6; i++) {
            excel.setCellData("Done", i, 3);

        }
    }


    @Then("^the home page is closed$")
    public void the_home_page_is_closed() throws Throwable {
          //Assert.assertEquals(strArg1, loginOb.WrongTitle.getText());
        setUp.driver.close();



    }

}