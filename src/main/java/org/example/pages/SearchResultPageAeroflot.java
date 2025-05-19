package org.example.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPageAeroflot{

    private final ElementsCollection routeHeaders = $$("div.frame__heading." +
            "h-pull--left.frame__heading--m24");
    private final ElementsCollection pickedDates = $$("div.price-chart__col." +
            "price-chart__col--active>div>div.price-chart__item-number");

    public List<String> getSearchResultFlightHeader() {
        return routeHeaders.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .stream().map(SelenideElement::getText).toList();
    }

    public List<String> getPickedDates() {
        return pickedDates.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .stream().map(SelenideElement::getText).toList();
    }
}
