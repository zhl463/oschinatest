package net.oschina.app.com.oschina.pages;

import net.oschina.app.SoloWrap;

/**
 * Created by Aaron on 2016/11/27.
 */
public class PageCommon {
    private SoloWrap solo;

    public PageCommon(SoloWrap solo){
        this.solo = solo;
    }

    public boolean searchText(String text){
        return solo.searchText(text);
    }

    public void clickOnText(String text){
        solo.clickOnText(text);
    }


    public void sleep(int seconds){
        solo.sleep(seconds);
    }
}
