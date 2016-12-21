package net.oschina.app;

import android.util.Log;

import net.oschina.app.com.oschina.Utils;

import java.util.Random;

/**
 * Created by Aaron on 2016/12/14.
 */
public class Cross2 extends BasicTestCase {

    public Cross2(){
        super(false);
    }

    public void testCross(){
        String[]  groupNames = {"云层app自动化五期班","QQ空间","自动化精讲班—app班"};
        pageHelper.getPageCommon().clickOnText("ApiAdmin v1\\.3\\.0 发布，面向 API 的后台管理框架");
        pageHelper.getPageCommon().sleep(5);
        pageHelper.getPageNewsDetail2().clickShareIM();
        pageHelper.getPageCommon().sleep(2);
        pageHelper.getPageCommon().clickOnText("QQ");
        pageHelper.getPageCommon().sleep(5);
//        pageHelper.getPageCommon().clickOnText("新用户注册");
        Random r = new Random();
        int index = r.nextInt(3);
        Log.i("AUTO","=============================="+groupNames[index]);
        Utils.doCross("Cross","testC", groupNames[index]);
        pageHelper.getPageNewsDetail2().clickCommnetCount();
        pageHelper.getPageCommon().sleep(5);
    }
}
