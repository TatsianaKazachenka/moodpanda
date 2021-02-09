package steps;

import pages.*;

public class LoginSteps {
    private LoginPage page;

    public LoginSteps() {
        page = new LoginPage();
    }

    public FeedPage login(String email, String password) {
        return page.openPage().login(email, password).waitForPageOpened();
    }
}
