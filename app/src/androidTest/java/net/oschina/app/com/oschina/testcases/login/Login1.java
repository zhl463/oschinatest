package net.oschina.app.com.oschina.testcases.login;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;

import com.robotium.solo.Solo;

import net.oschina.app.AppStart;
import net.oschina.app.BasicTestCase;

/**
 * Created by Aaron on 2016/11/27.
 */
public class Login1 extends BasicTestCase{


    public void testLogin1(){
//        assertFalse(true);
        pageHelper.getPageNavigation().clickMyTab();
        pageHelper.getPageMyUnLoginStatus().clickLoginIcon();
        pageHelper.getPageLogin().login("735723619@qq.com","123456789");
        assertTrue(pageHelper.getPageCommon().searchText("用户名或口令错"));
    }
}
