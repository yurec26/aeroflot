package org.example.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPageAeroflot extends BasePage {


    private final ElementsCollection routeHeaders = $$("div.frame__heading.h-pull--left.frame__heading--m24");
    private final ElementsCollection pickedDates = $$("div.price-chart__col.price-chart__col--active>div>div.price-chart__item-number");


    public SearchResultPageAeroflot() {
        super();
    }

    public List<String> getSearchResultFlightHeader() {
        return routeHeaders.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .stream().map(SelenideElement::getText).toList();
//                wait.until(ExpectedConditions
//                        .visibilityOfAllElements(routeHeaders)).stream()
//                .map(WebElement::getText).toList();
    }

    public List<String> getPickedDates() {
     return pickedDates.shouldBe(CollectionCondition.sizeGreaterThan(0))
             .stream().map(SelenideElement::getText).toList();
//        return wait.until(ExpectedConditions
//                        .visibilityOfAllElements(pickedDates)).stream()
//                .map(WebElement::getText).toList();
    }
}
