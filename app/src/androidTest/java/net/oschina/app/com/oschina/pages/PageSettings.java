package net.oschina.app.com.oschina.pages;

import android.widget.Button;
import android.widget.TextView;

import net.oschina.app.SoloWrap;
import net.qiujuer.genius.ui.widget.EditText;

/**
 * Created by Aaron on 2016/11/27.
 */
public class PageSettings {
    private SoloWrap solo;
    private TextView logoutTV;

    public PageSettings(SoloWrap solo){
        this.solo = solo;
    }

    /**
     * 用来加载出这个页面要使用到的控件
     */
    public void initViews(){
        logoutTV =(TextView) solo.getView("net.oschina.app:id/setting_cancle");
    }

    public void clickLogout(){
        solo.clickOnView(logoutTV);
    }


}
