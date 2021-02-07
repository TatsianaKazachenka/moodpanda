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
    public void DescriptionTest() {
        int moodValue = 8;
        String description = "Hello!";
        loginSteps.login(EMAIL, PASSWORD);
        moodUpdateModalSteps.fullingFieldAndGoToDiary(moodValue, description);
        String textPost = feedPage.textPost();
        Assert.assertEquals(textPost, description);
    }

    @Test(description = "check the value mood update in the post")
    public void LevelMoodTest() {
        int moodValue = 8;
        String description = "Hello!";
        loginSteps.login(EMAIL, PASSWORD);
        moodUpdateModalSteps.fullingFieldAndGoToDiary(moodValue, description);
        int level = feedPage.moodLevel();
        Assert.assertEquals(moodValue, level);
    }

    @Test(description = "check the number of hugs after clicking")
    public void HugTest() {
        loginSteps.login(EMAIL, PASSWORD);
        int firstHugs = feedPage.getCountHugs();
        feedPage.clickHug().waitForCommentOpened();
        int lastHugs = feedPage.getCountHugs();
        Assert.assertEquals((firstHugs + 1), lastHugs);
    }
}
