package com.springernature.search.test.steps;

import com.springernature.search.test.page.HtmlElement;
import com.springernature.search.test.page.Page;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static com.springernature.search.test.page.HtmlElement.getElementByName;
import static com.springernature.search.test.page.Page.getPageByName;
import static org.junit.Assert.*;
import static org.openqa.selenium.By.*;


public class SearchSteps {

    private static final String TITLE = "title";
    private static WebDriver webDriver;

    @Before
    public void setup() throws Exception {
        //Currently using HTML unit driver can be used with other drivers Like Chrome Driver or IE or Firefox
        webDriver = new HtmlUnitDriver();
    }

    @Given("^I (?:visit|go to) (.*) (?:website|page)$")
    public void I_go_to_page(String pageName) {
        Page page = getPageByName(pageName);
        webDriver.get(page.getPageUrl());
        WebElement title = webDriver.findElement(tagName(TITLE));
        assertEquals(page.getPageTitle(), title.getText());
    }


    @When("^I click on (.*) (?:button|element|link)$")
    public void I_click_on_element(String elementName) {
        HtmlElement htmlElement = getElementByName(elementName);
        webDriver.findElement(id(htmlElement.getId())).click();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }


    @Then("^I see the (.*) page$")
    public void I_see_the_page(String pageName) {
        Page page = getPageByName(pageName);
        assertEquals(webDriver.getCurrentUrl(), page.getPageUrl());

    }

    @When("^I enter the search term (.*)$")
    public void enterTheSearchTerm(String searchTerm) throws Throwable {
        WebElement searchElement = webDriver.findElement(id(HtmlElement.SEARCH_QUERY.getId()));
        searchElement.sendKeys(searchTerm);
        webDriver.findElement(id(HtmlElement.SEARCH_BUTTON.getId())).click();
    }

    @Then("^I see (.*) (\\d+) search results$")
    public void checkSearchResults(String resultType, long numberOfResults) throws Throwable {
        WebElement element = webDriver.findElement(className("number-of-search-results-and-search-terms"));
        String text = element.getText();
        String countValue = text.substring(0, text.indexOf("Result")).replaceAll(" ", "").replaceAll(",", "");
        long count = Long.valueOf(countValue);
        switch (resultType) {
            case "atleast":
                assertTrue("Count does not match , expected numberOfResults:" + numberOfResults + " actual:" + count, numberOfResults <= count);
                break;
            case "exact":
                assertTrue("Count does not match , expected numberOfResults:" + numberOfResults + " actual:" + count, numberOfResults == count);
                break;
            default:
                fail("Invalid option " + resultType);
                break;
        }

    }

    @And("^I see below link (.*) with (.*) in search results$")
    public void iSeeBelowLinkRESULTWithHREFLINKInSearchResults(String searchResult, String resultUrl) throws Throwable {
        if (null != searchResult && searchResult.length() > 0) {
            List<WebElement> results = webDriver.findElements(By.xpath("//ol[@id='results-list']/li"));
            for (WebElement element : results) {
                WebElement anchorElement = element.findElement(By.tagName("a"));
                if (anchorElement.getText().equals(searchResult)) {
                    assertEquals(searchResult, anchorElement.getText());
                    assertTrue(anchorElement.getAttribute("href").contains(resultUrl));
                    return;
                }
            }
            fail("Unable to find search result " + searchResult);
        }
    }
}
