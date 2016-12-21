package net.oschina.app.com.oschina.testcases.login;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.robotium.solo.Solo;

import net.oschina.app.AppStart;
import net.oschina.app.BasicTestCase;

/**
 * Created by Aaron on 2016/11/27.
 */
public class Login2 extends BasicTestCase{

    public Login2(){
        super(true);
    }

    public void testLogin2(){
        pageHelper.getPageNavigation().clickMyTab();
        assertTrue(pageHelper.getPageMyLoginStatus().isAlreadyLogin());
    }
}
