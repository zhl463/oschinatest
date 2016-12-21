package net.oschina.app.com.oschina.testsuites;

import junit.framework.TestSuite;

import net.oschina.app.com.oschina.testcases.login.Login1;
import net.oschina.app.com.oschina.testcases.login.Login2;
import net.oschina.app.com.oschina.testcases.login.Login4;

/**
 * Created by Aaron on 2016/11/27.
 */
public class SuiteLogin {

    public static TestSuite getLoginSuite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(Login2.class);
        suite.addTestSuite(Login4.class);
        suite.addTestSuite(Login1.class);
        return suite;
    }

}
