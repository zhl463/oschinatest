package net.oschina.app.com.oschina.com.oschina.testcases.news;

import net.oschina.app.BasicTestCase;

/**
 * Created by Aaron on 2016/11/27.
 */
public class News1 extends BasicTestCase{

    public News1(){
        super(false);
    }

    public void testLogin1(){
        pageHelper.getPageNavigation().clickMyTab();
        pageHelper.getPageMyUnLoginStatus().clickLoginIcon();
        pageHelper.getPageLogin().login("735723619@qq.com","123456789");
        assertTrue(pageHelper.getPageCommon().searchText("用户名或口令错"));
    }
}
