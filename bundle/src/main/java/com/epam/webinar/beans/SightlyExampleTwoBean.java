package com.epam.webinar.beans;

import javax.script.Bindings;

import com.adobe.cq.sightly.WCMBindings;
import com.day.cq.wcm.api.Page;
import io.sightly.java.api.Use;

public class SightlyExampleTwoBean implements Use {

    private String myTitle;

    @Override
    public void init(Bindings bindings) {
        Page currentPage = (Page) bindings.get(WCMBindings.CURRENT_PAGE);
        myTitle = currentPage.getTitle() + " Alternative source";
    }

    public String getMyTitle() {
        return myTitle;
    }
}
