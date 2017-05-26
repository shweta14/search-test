package com.springernature.search.test.page;

import java.util.HashMap;
import java.util.Map;


public enum HtmlElement {
    SEARCH_QUERY("Search Query", "query", "global_search"),
    SEARCH_BUTTON("Search Button", "search", "global_search");
    private final String name;
    private final String id;
    private final String parentId;

    static Map<String, HtmlElement> nameIdMap = new HashMap<String, HtmlElement>();

    static {
        for (HtmlElement element : values()) {
            nameIdMap.put(element.name, element);
        }
    }

    HtmlElement(String name, String id, String parentId) {
        this.name = name;
        this.parentId = parentId;
        this.id = id;
    }

    public static HtmlElement getElementByName(String name) {
        return nameIdMap.get(name);
    }

    public String getName() {
        return name;
    }

    public String getParentId() {
        return parentId;
    }

    public String getId() {
        return id;
    }
}
