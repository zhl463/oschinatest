package net.oschina.app.com.oschina.testcases.login;

import net.oschina.app.BasicTestCase;

/**
 * Created by Aaron on 2016/12/16.
 */
public class Login4 extends BasicTestCase{

    public  void testCrash(){
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
