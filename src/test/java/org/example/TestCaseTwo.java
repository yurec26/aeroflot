package org.example;

import io.qameta.allure.*;
import org.example.model.Keyword;
import org.example.providers.DataProviders;
import org.testng.annotations.Test;

@Epic("Система поиска по ключевым словам")
@Feature("Поиск статей по ключевым словам с главной страницы")
public class TestCaseTwo extends BaseTest {

    @Description("Проверка наличия поискового слова в результатах поиска")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "keyword",
            dataProviderClass = DataProviders.class)
    public void testSearchResultsContainKeyword(Keyword keyword) {
        homePageSteps
                .openSearchInfoPage()
                .performSearch(keyword.keyword())
                .verifyThatAllResultsContainsKeyword(keyword.keyword());
    }
}
