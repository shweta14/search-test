package com.springernature.search.test.page;

import java.util.HashMap;
import java.util.Map;


public enum Page {
    SPRINGER_HOME("Springer", "https://www.springer.com/gb/", "Springer - International Publisher Science, Technology, Medicine"),
    SEARCH_PAGE("Springer Link", "https://link.springer.com", "Home - Springer");

    private static Map<String, Page> pageNameMap = new HashMap<String, Page>();

    static {
        for (Page page : values()) {
            pageNameMap.put(page.getPageName(), page);
        }
    }

    private final String pageName;
    private final String pageUrl;
    private final String pageTitle;

    Page(String pageName, String pageUrl, String pageTitle) {
        this.pageName = pageName;
        this.pageUrl = pageUrl;
        this.pageTitle = pageTitle;
    }


    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageName() {
        return pageName;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public static Page getPageByName(String pageName) {
        return pageNameMap.get(pageName);
    }
}

