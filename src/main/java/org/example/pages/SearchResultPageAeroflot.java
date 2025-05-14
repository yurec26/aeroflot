package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultPageAeroflot extends BasePage {

    @FindBy(css = "div.frame__heading.h-pull--left.frame__heading--m24")
    List<WebElement> routeHeaders;

    @FindBy(css = "div.price-chart__col.price-chart__col--active>div>div.price-chart__item-number")
    List<WebElement> pickedDates;

    public SearchResultPageAeroflot() {
        super();
    }

    public List<String> getSearchResultFlightHeader() {
        return wait.until(ExpectedConditions
                        .visibilityOfAllElements(routeHeaders)).stream()
                .map(WebElement::getText).toList();
    }

    public List<String> getPickedDates() {
        return wait.until(ExpectedConditions
                        .visibilityOfAllElements(pickedDates)).stream()
                .map(WebElement::getText).toList();
    }
}
