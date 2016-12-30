package net.oschina.app;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

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
 * Created by tyoko on 2016/12/28.
 */

public class CommonRunner1 extends JUnitReportTestRunner{
    boolean reGenerate=false;

    @Override
    public void onCreate(Bundle arguments) {
        if("true".equalsIgnoreCase(arguments.getString("isNeedReGenarate"))){
            reGenerate=true;
        }
        super.onCreate(arguments);
    }

    public TestSuite regenerateTestSuite(TestSuite suite) {
        TestSuite newSuite=new TestSuite();
        List<String> testCaseNames=getTestCase(suite);
        boolean startAdd=false;
        for(String caseName:testCaseNames){
            String trueName=getClassName(caseName);
            Log.i("AUTO",trueName);
            if (getCrashName().equalsIgnoreCase(trueName)){
                startAdd=true;
                continue;
            }
            if (startAdd){
                try {
                    newSuite.addTestSuite((Class<? extends TestCase>)Class.forName(caseName));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return newSuite;
    }
    public List<String> getTestCase(TestSuite suite){
        List<String> suites=new ArrayList<>();
        for (int i=0;i<suite.testCount();i++){
            for (int j=0;j<((TestSuite)suite.testAt(i)).testCount();j++){
                String name=((TestSuite)suite.testAt(i)).testAt(j).toString();
                suites.add(name);
            }
        }
        suites.add("net.oschina.app.com.oschina.Runner12");
        return suites;
    }

    public String getCrashName(){
        String name="";
        FileReader fr= null;
        BufferedReader br=null;
        try {
            fr = new FileReader(Environment.getExternalStorageDirectory()+"/crash.txt");
            br=new BufferedReader(fr);
            name=br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return name;
    }

    public String getClassName(String allName){
        String[] names=allName.split(".");
        return names[names.length-1];
    }
}
