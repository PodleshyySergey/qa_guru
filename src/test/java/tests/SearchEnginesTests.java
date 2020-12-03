package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchEnginesTests {

    @Test
    void testGoogleSearch() {
        open("https://www.google.com");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("html").shouldHave(text("selenide.org"));
    }

    @Test
    public void testYandexSearch() {
        Configuration.startMaximized = true;
        Configuration.browser = "edge";
        open("https://yandex.ru/");
        $("#text").val("selenide");
        $(byText("Найти")).click();

        $(byText("ru.selenide.org")).shouldBe(visible);
    }

}
