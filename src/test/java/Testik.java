import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Testik {

    @BeforeAll
        static void setupSelenideEnv(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }



    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        $("#firstName").setValue("Sake");
        $("#lastName").setValue("Maki");
        $("#userEmail").setValue("susi@susi.com");
        $("[for='gender-radio-3']").click();
        $("#userNumber").setValue("8005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("September")).click();
        $(".react-datepicker__year-select").$(byText("2001")).click();
        $(".react-datepicker__month").$(byText("9")).click();
        $("#subjectsInput").setValue("Maths");
        $("#react-select-2-option-0").click();
        $("#subjectsInput").setValue("Comp");
        $("#react-select-2-option-0").click();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("images (2).jpg");
        $("#currentAddress").setValue("Tokyo Hotel");
        //$("footer").scrollTo();
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        $$("table tbody tr").findBy(text("Student Name")).shouldHave(text("Sake Maki"));
        $$("table tbody tr").findBy(text("Student Email")).shouldHave(text("susi@susi.com"));
        $$("table tbody tr").findBy(text("Gender")).shouldHave(text("Other"));
        $$("table tbody tr").findBy(text("Mobile")).shouldHave(text("8005553535"));
        $$("table tbody tr").findBy(text("Date of Birth")).shouldHave(text("09 September,2001"));
        $$("table tbody tr").findBy(text("Subjects")).shouldHave(text("Maths, Computer Science"));
        $$("table tbody tr").findBy(text("Hobbies")).shouldHave(text("Sports, Music"));
        $$("table tbody tr").findBy(text("Picture")).shouldHave(text("images (2).jpg"));
        $$("table tbody tr").findBy(text("Address")).shouldHave(text("Tokyo Hotel"));
        $$("table tbody tr").findBy(text("State and City")).shouldHave(text("Rajasthan Jaipur"));
        sleep(5000);
    }

}
