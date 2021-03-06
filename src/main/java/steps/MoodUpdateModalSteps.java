package steps;

import pages.*;

public class MoodUpdateModalSteps {
    private FeedPage page;

    public MoodUpdateModalSteps() {
        page = new FeedPage();
    }

    public MoodUpdateModal updateMoodAndGoToDiary(int moodValue, String description) {
        return page
                .clickOnUpdateBtn()
                .updateMood(moodValue, description)
                .clickYesterday()
                .clickBtnUpdate()
                .waitForModalOpened()
                .clickGoDiary();
    }
}
