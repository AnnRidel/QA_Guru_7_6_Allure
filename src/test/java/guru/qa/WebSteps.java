package guru.qa;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем github")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий [{repository}]")
    public void searchForRepository(String repository) {
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий [{repository}]")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Переходим в Issues")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Ищем Issue с номером {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(exist);
    }
}
