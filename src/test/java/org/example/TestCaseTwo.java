package org.example;

import org.example.model.Keyword;
import org.example.providers.DataProviders;
import org.testng.annotations.Test;

public class TestCaseTwo extends BaseTest {

    @Test(testName = "Проверка наличия поискового слова в результатах поиска",
            dataProvider = "keyword",
            dataProviderClass = DataProviders.class)
    public void testSearchResultsContainKeyword(Keyword keyword) {
        homePageSteps
                .openSearchInfoPage()
                .performSearch(keyword.keyword())
                .verifyThatAllResultsContainsKeyword(keyword.keyword());
    }
}
