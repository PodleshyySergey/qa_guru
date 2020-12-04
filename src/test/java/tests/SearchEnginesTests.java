package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchEnginesTests {

    @BeforeAll
    static public void setUp() {
        Configuration.startMaximized = true;
        Configuration.browser = "edge";
    }

    @Test
    void testGoogleSearch() {
        open("https://www.google.com");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("html").shouldHave(text("selenide.org"));
    }

    @Test
    public void testYandexSearch() {
        open("https://yandex.ru/");
        $("#text").val("selenide");
        $(byText("Найти")).click();

        $(byText("ru.selenide.org")).shouldBe(visible);
    }

    @Test
    public void testRamblerSearch() {
        open("https://www.rambler.ru/");
        $("[placeholder='Искать в интернете']").val("selenide");
        $(byText("Найти")).click();
        sleep(2000);
        $("html").shouldHave(text("selenide.org/"));
    }

}
