package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {
    public static final String UPDATE_MOOD_BTN_CSS = "#LinkUpdate";
    public static final String FIRST_POST_CSS = ".m1";
    public static final String TEXT_POST_CSS = ".MoodPostItem";
    public static final String BADGE_POST_CSS = ".badge";
    public static final String CONTENT_COMMENT_FIRST_CSS = ".mcw1";
    public static final String BUTTON_HUG_CSS = ".ButtonHug";
    public static final String HUG_COUNT_POST_CSS = "//*[contains(@class,'mchugs')]";

    public FeedPage waitForPageOpened() {
        $(UPDATE_MOOD_BTN_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public RateYourHappiness clickOnUpdateBtn() {
        $(UPDATE_MOOD_BTN_CSS).click();
        return new RateYourHappiness();
    }

    public String textPost() {
        String text = $(FIRST_POST_CSS).find(TEXT_POST_CSS).getText();
        return text;
    }

    public int moodLevel() {
        String level = $(FIRST_POST_CSS).find(BADGE_POST_CSS).getText();
        return Integer.parseInt(level);
    }

    public int getCountHugs() {
        WebElement element = $(FIRST_POST_CSS).find(BUTTON_HUG_CSS);
        String count = element.findElement(By.xpath(HUG_COUNT_POST_CSS)).getText();
        return Integer.parseInt(count);
    }

    public FeedPage clickHug() {
        $(BUTTON_HUG_CSS).click();
        return this;
    }

    public FeedPage waitForCommentOpened() {
        $(CONTENT_COMMENT_FIRST_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }
}
