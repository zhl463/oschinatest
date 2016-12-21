package net.oschina.app.com.oschina.pages;

import android.widget.FrameLayout;
import android.widget.ImageView;

import net.oschina.app.SoloWrap;

/**
 * Created by Aaron on 2016/11/27.
 */
public class PageNavigation {
    private SoloWrap solo;
    private FrameLayout newsTab,tweetTab,exploreTab,myTab;
    private ImageView pubIM;

    public PageNavigation(SoloWrap solo){
        this.solo = solo;
    }

    public void initViews(){
        newsTab = (FrameLayout) solo.getView("net.oschina.app:id/nav_item_news");
        tweetTab = (FrameLayout) solo.getView("net.oschina.app:id/nav_item_tweet");
        exploreTab = (FrameLayout) solo.getView("net.oschina.app:id/nav_item_explore");
        myTab = (FrameLayout) solo.getView("net.oschina.app:id/nav_item_me");
        pubIM = (ImageView) solo.getView("net.oschina.app:id/nav_item_tweet_pub");
    }

    public void clickNewsTab(){
        solo.clickOnView(newsTab);
    }

    public void clickTweetTab(){
        solo.clickOnView(tweetTab);
    }

    public void clickExploreTab(){
        solo.clickOnView(exploreTab);
    }

    public void clickMyTab(){
        solo.clickOnView(myTab);
    }

    public void clickPubIM(){
        solo.clickOnView(pubIM);
    }

}
