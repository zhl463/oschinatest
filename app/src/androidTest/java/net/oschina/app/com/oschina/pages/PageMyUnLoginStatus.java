package net.oschina.app.com.oschina.pages;

import android.widget.Button;
import android.widget.ImageView;

import com.robotium.solo.Solo;

import net.oschina.app.SoloWrap;
import net.qiujuer.genius.ui.widget.EditText;

/**
 * Created by Aaron on 2016/11/27.
 */
public class PageMyUnLoginStatus {
    private SoloWrap solo;
    private ImageView settingsIV,loginIcon;

    public PageMyUnLoginStatus(SoloWrap solo){
        this.solo = solo;
    }

    /**
     * 用来加载出这个页面要使用到的控件
     */
    public void initViews(){
        settingsIV = (ImageView) solo.getView("net.oschina.app:id/iv_logo_setting");
        loginIcon = (ImageView) solo.getView("net.oschina.app:id/iv_portrait");
    }


    public void clickLoginIcon(){
        solo.clickOnView(loginIcon);
    }

    public void clickSettings(){
        solo.clickOnView(settingsIV);
    }

}
