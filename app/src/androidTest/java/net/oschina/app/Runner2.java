package net.oschina.app;

import android.os.Bundle;
import android.os.Environment;
import android.test.InstrumentationTestRunner;
import android.util.Log;

import com.zutubi.android.junitreport.JUnitReportTestRunner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import net.oschina.app.com.oschina.FinalTest;
import net.oschina.app.com.oschina.testsuites.SuiteLogin;
import net.oschina.app.com.oschina.testsuites.SuiteNews;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2016/11/27.
 */
public class Runner2 extends CustomRunner{


    @Override
    public TestSuite getAllTests() {
        TestSuite suite = new TestSuite();
        suite.addTest(SuiteLogin.getLoginSuite());
        suite.addTestSuite(FinalTest.class);
//        if(isNeedRegenerate){
//            suite = regenerateTestSuite(suite);
//        }
        return  suite;
    }


}
