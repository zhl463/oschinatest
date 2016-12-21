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
 * Created by Aaron on 2016/11/30.
 */
public class CustomRunner extends JUnitReportTestRunner {
    boolean isNeedRegenerate = false;

    @Override
    public void onCreate(Bundle arguments) {
        Log.i("AUTO","============================"+arguments.getString("reorganize"));
        if("true".equalsIgnoreCase(arguments.getString("reorganize"))){
            isNeedRegenerate = true;
        }
        super.onCreate(arguments);
    }

    public String getCrashName(){
        String caseName = "";
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(Environment.getExternalStorageDirectory()+"crash.txt");
            br = new BufferedReader(fr);
            caseName = br.readLine();
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
        return caseName;
    }

    public List<String> getCaseNameList(TestSuite suite){
        List<String> caseNameList = new ArrayList<String>();
        for(int i=0; i<suite.testCount(); i++){
            for(int j=0; j < suite.testAt(i).countTestCases(); j++){
                String name = ((TestSuite) suite.testAt(i)).testAt(j).toString();
                caseNameList.add(name);
            }
        }
        caseNameList.add("net.oschina.app.com.oschina.FinalTest");
        return caseNameList;
    }

    public TestSuite regenerateTestSuite(TestSuite suite){
        String crash = getCrashName();
        TestSuite newSuite = new TestSuite();
        List<String> allCaseNames = getCaseNameList(suite);
        boolean isStartAddFlag = false;
        for(String caseName : allCaseNames){
            if(caseName.contains(crash)){
                isStartAddFlag = true;
                continue;
            }
            if(isStartAddFlag){
                try{
                    newSuite.addTestSuite((Class<? extends TestCase>)Class.forName(caseName));
                }catch (ClassNotFoundException ex){
                    ex.printStackTrace();
                }
            }
        }
        return newSuite;
    }

}
