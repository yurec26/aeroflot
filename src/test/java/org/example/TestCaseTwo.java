package org.example;

import org.example.providers.DataProviders;
import org.testng.annotations.Test;

public class TestCaseTwo extends BaseTest {

    @Test(testName = "Проверка наличия поискового слова в результатах поиска",
            dataProvider = "keyword",
            dataProviderClass = DataProviders.class)
    public void testSearchResultsContainKeyword(String keyword) {
        homePageSteps
                .openSearchInfoPage()
                .performSearch(keyword)
                .verifyThatAllResultsContainsKeyword(keyword);
    }

}
