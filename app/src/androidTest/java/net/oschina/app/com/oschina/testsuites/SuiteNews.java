package net.oschina.app.com.oschina.testsuites;

import junit.framework.TestSuite;

import net.oschina.app.com.oschina.com.oschina.testcases.news.News1;
import net.oschina.app.com.oschina.testcases.login.Login1;
import net.oschina.app.com.oschina.testcases.login.Login2;

/**
 * Created by Aaron on 2016/11/27.
 */
public class SuiteNews {

    public static TestSuite getNewsSuite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(News1.class);
        return suite;
    }

}
