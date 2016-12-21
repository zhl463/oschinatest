package net.oschina.app.com.oschina.pages;

import android.widget.ImageView;
import android.widget.TextView;

import net.oschina.app.SoloWrap;

/**
 * Created by Aaron on 2016/12/14.
 */
public class PageNewsDetail2 {
    private ImageView shareIM;
    private TextView commentCount;
    private SoloWrap solo;

    public PageNewsDetail2(SoloWrap solo){
        this.solo = solo;
    }

    public void initViews(){
        shareIM = (ImageView) solo.getView("net.oschina.app:id/iv_share");
        commentCount = (TextView) solo.getView("net.oschina.app:id/tv_comment_count");
    }

    public void clickShareIM(){
        solo.clickOnView(shareIM);
    }

    public void clickCommnetCount(){
        solo.clickOnView(commentCount);
    }

}
