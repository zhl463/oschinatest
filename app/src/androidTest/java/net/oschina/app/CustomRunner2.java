package net.oschina.app;

import android.os.Bundle;
import android.os.Environment;

import com.zutubi.android.junitreport.JUnitReportTestRunner;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2016/12/24.
 */
public class CustomRunner2 extends JUnitReportTestRunner {
    boolean reGenerate = false;

    @Override
    public void onCreate(Bundle arguments) {
        String isNeedReGenerate = arguments.getString("isNeedReGenerate");
        if("true".equalsIgnoreCase(isNeedReGenerate)){
            reGenerate = true;
        }
        super.onCreate(arguments);
    }

    public String getCrashName(){
        String name = "";
        FileReader fr = null;
        BufferedReader br = null;
        try {
           fr = new FileReader(Environment.getExternalStorageDirectory()+"/crash.txt");
           br = new BufferedReader(fr);
            name = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    public List<String> getAllTestCases(TestSuite suite){
        List<String> testCases = new ArrayList<String>();
        for(int i=0; i < suite.testCount(); i++){
            for(int j=0; j < ((TestSuite)suite.testAt(i)).testCount(); j++){
                String name = ((TestSuite)suite.testAt(i)).testAt(j).toString();
                testCases.add(name);
            }
        }
        testCases.add("net.oschina.app.com.oschina.FinalTest");
        return testCases;
    }

    public TestSuite getNewTestSuite(TestSuite suite){
        TestSuite newSuite = new TestSuite();
        String crash = getCrashName();
        boolean startAdd = false;
        for(String caseName : getAllTestCases(suite)){
            if(caseName.contains(crash)){
                startAdd = true;
                continue;
            }
            if(startAdd){
                try {
                    newSuite.addTestSuite((Class<? extends TestCase>)Class.forName(caseName));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return newSuite;
    }
}
