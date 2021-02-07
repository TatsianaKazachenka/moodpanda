package pages;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappiness {
    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String BTN_UPDATE_CSS = ".ButtonUpdate";
    public static final String BTN_YESTERDAY_CSS = ".ResetYesterday";
    public static final String DESCRIPTION_CSS = "#TextBoxUpdateMoodTag";
    public static final String TEXT_MOOD_BTN = "Update Mood to ";

    public RateYourHappiness updateMood(int moodValue, String description) {
        $(SLIDER_CSS).click();
        int defaultMood = 5;
        Keys direction;
        if (moodValue > defaultMood) {
            direction = Keys.ARROW_RIGHT;
        } else {
            direction = Keys.ARROW_LEFT;
        }
        for (int i = 0; i < Math.abs(moodValue - defaultMood); i++) {
            $(SLIDER_CSS).sendKeys(direction);
        }
        $(DESCRIPTION_CSS).sendKeys(description);
        return this;
    }

    public MoodUpdateModal clickBtnUpdate() {
        $(BTN_UPDATE_CSS).click();
        return new MoodUpdateModal();
    }

    public RateYourHappiness clickYesterday() {
        $(BTN_YESTERDAY_CSS).click();
        return this;
    }

    public int getMoodValueHappiness() {
        String text = $(BTN_UPDATE_CSS).getText();
        return Integer.parseInt(text.replace(TEXT_MOOD_BTN, ""));
    }
}
