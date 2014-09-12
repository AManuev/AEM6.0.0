package com.epam.webinar.adapter.models;

import com.day.cq.wcm.api.Page;

public class SimpleRequestModel {

    private final Page page;
    private final String title;

    public SimpleRequestModel(final String title, final Page page) {
        this.title = title;
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public Page getPage() {
        return page;
    }
}
