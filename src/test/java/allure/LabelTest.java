package allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {

    @Test
    @Feature("Issue в репозитории // фича")
    @Story("Создание Isuue // что мы можем с нею делать")
    @Owner("Kolyshkin")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "htttps://testing.github.com")
    @DisplayName("Проверка создания Isuue для авторизрванного пользователя")
    public void testStaticLabels() {
    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Проверка создания Isuue для авторизрванного пользователя")
        );
        Allure.feature("Issue в репозитории");
    }
}
