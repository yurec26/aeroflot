package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.SearchInfoPageAeroflot;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class SearchInfoSteps {

    private final SearchInfoPageAeroflot searchInfoPageAeroflot = new SearchInfoPageAeroflot();

    @Step("Пользователь вводит ключевое слово и нажимает enter")
    public SearchInfoSteps performSearch(String text) {
        searchInfoPageAeroflot.fillSearchFieldAndPressEnter(text);
        return this;
    }

    public void verifyThatAllResultsContainsKeyword(String keyword) {
        assertSoftly(softly -> searchInfoPageAeroflot.getResults()
                .forEach(i -> assertThat(i)
                        .as("Статья должна содержать искомое слово %s".formatted(keyword))
                        .contains(keyword)));
    }
}
