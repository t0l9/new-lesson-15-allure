package allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openmainPage(String baseUrl){
        open(baseUrl);
    }

    @Step("Кликаем на вкоадку Issuese")
    public void clickToIsuue(){
        $("#issues-tab").click();
    }

    @Step("Делаем проверку что слово {vord} существует в репозитории")
    public void checkResult(String vord){
        $(withText(vord)).should(exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs((OutputType.BYTES));
    }
}
