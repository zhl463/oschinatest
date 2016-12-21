package net.oschina.app.com.oschina.pages;

import android.widget.ImageView;
import android.widget.TextView;

import net.oschina.app.SoloWrap;

/**
 * Created by Aaron on 2016/11/27.
 */
public class PageMyLoginStatus {
    private SoloWrap solo;
    private ImageView settingsIV;
    private TextView nickTV;

    public PageMyLoginStatus(SoloWrap solo){
        this.solo = solo;
    }

    /**
     * 用来加载出这个页面要使用到的控件
     */
    public void initViews(){
        solo.waitForText("点击头像登录");
        settingsIV = (ImageView) solo.getView("net.oschina.app:id/iv_logo_setting");
        nickTV = (TextView) solo.getView("net.oschina.app:id/tv_nick");
    }

    public void clickSettings(){
        solo.clickOnView(settingsIV);
    }

    public  String getNickName(){
        return nickTV.getText().toString();
    }

    public boolean isAlreadyLogin(){
       return  getNickName().equals("autotest");
    }

}
