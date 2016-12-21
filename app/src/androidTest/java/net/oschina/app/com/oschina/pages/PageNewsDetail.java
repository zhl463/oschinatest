package net.oschina.app.com.oschina.pages;

import android.widget.ImageView;

import net.oschina.app.SoloWrap;

/**
 * Created by Aaron on 2016/12/10.
 */
public class PageNewsDetail {
    private SoloWrap solo;
    private ImageView shareImg;

    public PageNewsDetail(SoloWrap solo){
        this.solo = solo;
    }

    public void initViews(){
        shareImg = (ImageView) solo.getView("net.oschina.app:id/iv_share");
    }

    public void clickShareImg(){
        solo.clickOnView(shareImg);
    }
}
