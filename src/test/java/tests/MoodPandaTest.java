package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test(description = "check the value update on the button")
    public void updateMoodValueTest() {
        int moodValue = 8;
        String description = "Hello!";
        loginSteps.login(EMAIL, PASSWORD)
                .clickOnUpdateBtn()
                .updateMood(moodValue, description);
        int getMoodValue = rateYourHappiness.getMoodValueHappiness();
        Assert.assertEquals(getMoodValue, moodValue);
    }

    @Test(description = "check the description update in the post")
    public void descriptionTest() {
        int moodValue = 8;
        String description = "Hello!";
        loginSteps.login(EMAIL, PASSWORD);
        moodUpdateModalSteps.updateMoodAndGoToDiary(moodValue, description);
        String textPost = feedPage.getPostText();
        Assert.assertEquals(textPost, description);
    }

    @Test(description = "check the value mood update in the post")
    public void levelMoodTest() {
        int moodValue = 8;
        String description = "Hello!";
        loginSteps.login(EMAIL, PASSWORD);
        moodUpdateModalSteps.updateMoodAndGoToDiary(moodValue, description);
        int level = feedPage.getMoodLevel();
        Assert.assertEquals(moodValue, level);
    }

    @Test(description = "check the number of hugs after clicking")
    public void hugTest() {
        loginSteps.login(EMAIL, PASSWORD);
        int firstHugs = feedPage.getCountHugs();
        feedPage.clickHug().waitForCommentOpened();
        int lastHugs = feedPage.getCountHugs();
        Assert.assertEquals((firstHugs + 1), lastHugs);
    }
}
