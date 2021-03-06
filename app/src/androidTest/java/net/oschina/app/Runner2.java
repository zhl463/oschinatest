package net.oschina.app;
import junit.framework.TestSuite;

import net.oschina.app.com.oschina.FinalTest;
import net.oschina.app.com.oschina.testsuites.SuiteLogin;
/**
 * Created by Aaron on 2016/11/27.
 */
public class Runner2 extends CommonRunner{

    @Override
    public TestSuite getAllTests() {
        TestSuite suite = new TestSuite();
        suite.addTest(SuiteLogin.getLoginSuite());
        suite.addTestSuite(FinalTest.class);
        if(reGenerate){
            suite =  generateNewSuite(suite);
        }
        return  suite;
    }


}
