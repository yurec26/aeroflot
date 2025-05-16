package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.element;

public class SearchInfoPageAeroflot extends BasePage {


    private final SelenideElement searchField = element(By.id("search"));
    private final ElementsCollection results = $$("yass-div.b-serp-item__text");


    public SearchInfoPageAeroflot() {
        super();
    }

    public void fillSearchFieldAndPressEnter(String text){
        searchField.shouldBe(visible).setValue(text).pressEnter();
    }

    public List<String> getResults(){
       return results.stream().map(SelenideElement::getText).toList();
    }


}
