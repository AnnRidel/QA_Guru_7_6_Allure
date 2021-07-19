package guru.qa;

import org.junit.jupiter.api.Test;

public class StepTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    private WebSteps webSteps = new WebSteps();

    @Test
    public void shouldSeeIssueInRepository() {
        webSteps.openMainPage();
        webSteps.searchForRepository(REPOSITORY);
        webSteps.goToRepository(REPOSITORY);
        webSteps.openIssuesTab();
        webSteps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
