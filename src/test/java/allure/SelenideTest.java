package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.*;

public class SelenideTest {

    private static final String vord = "hello";
    private static final String url = "https://github.com/eroshenkoam/allure-example";

    @DisplayName("Демонтрация работы аллюра успешная")
    @Test
    void testIssueSearchSucsesfull() {

        //Добавляем интеграцию селенида и аллюра
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", ()-> {
            open(url);
            //Делаем скриншот
            attachment("Source", webdriver().driver().source());
        });

        //$("[data-target='qbsearch-input.inputButtonText']").click();
        //$("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();
        //$(linkText("eroshenkoam/allure-example")).click();

        step("Кликаем на вкоадку Issuese", ()-> {
            $("#issues-tab").click();
        });

        step("Делаем проверку что слово " + vord + " существует в репозитории", ()-> {
            $(withText(vord)).should(exist);
        });

    }


    @DisplayName("Annotated test with methods")
    @Test
    public void testAnnotated() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openmainPage(url);
        steps.clickToIsuue();
        steps.checkResult(vord);

        //Добавляем скриншот
        steps.takeScreenshot();
    }
}
