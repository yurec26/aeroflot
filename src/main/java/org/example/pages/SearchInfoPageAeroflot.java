package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchInfoPageAeroflot{

    private final SelenideElement searchField = element(By.id("search"));
    private final ElementsCollection results = $$("yass-div.b-serp-item__text");
    private final SelenideElement yandexLogo = $(".b-head__logo");

    public void fillSearchFieldAndPressEnter(String text) {
        searchField.shouldBe(visible)
                .setValue(text)
                .pressEnter();
    }

    public List<String> getResults() {
        yandexLogo.shouldBe(visible);
        return results.stream()
                .map(SelenideElement::getText)
                .map(String::toLowerCase).toList();
    }
}
