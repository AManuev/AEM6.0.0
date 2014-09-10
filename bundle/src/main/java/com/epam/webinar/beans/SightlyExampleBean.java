package com.epam.webinar.beans;

import com.adobe.cq.sightly.WCMUse;

public class SightlyExampleBean extends WCMUse {

    private String myTitle;

    @Override
    public void activate() throws Exception {
        myTitle = "My current page title: " + getCurrentPage().getTitle();
    }

    public String getMyTitle() {
        return myTitle;
    }
}
