package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;
import static io.qameta.allure.Allure.step;

public class LambdaTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void restRepositoryIsssue(){

        step("Открываем github", ()-> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, ()->{
            $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();        });

        step("Переходим в Issues", ()-> {
            $(linkText("eroshenkoam/allure-example")).click();
            $(partialLinkText("Issues")).click();
        });

        step("Ищем Issue с номером "+ ISSUE_NUMBER, ()->{
            $(withText("#"+ISSUE_NUMBER)).should(exist);
        });

    }
}
