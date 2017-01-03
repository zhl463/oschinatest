package net.oschina.app;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.zutubi.android.junitreport.JUnitReportTestRunner;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2016/12/25.
 */
public class CommonRunner extends JUnitReportTestRunner {
    boolean reGenerate = false;

    @Override
    public void onCreate(Bundle arguments) {
        String value = arguments.getString("isNeedReGenarate");
        if ("true".equalsIgnoreCase(value)) {
            reGenerate = true;
        }
        super.onCreate(arguments);
    }

    /**
     * 判断是否需要重新组装测试用例。
     * 获取原始的测试用例集，逐一判断是否与崩溃的测试用例相同，若相同则进入重新组装流程
     * public void addTestSuite(Class<? extends TestCase> testClass)通过java的Class.forName
     *
     * @param suite
     * @return
     */
    public TestSuite generateNewSuite(TestSuite suite) {
        TestSuite newSuite = new TestSuite();
        String crashCaseName = getCrashName();
        Log.i("AUTO","crashCaseName : "+crashCaseName);
        boolean startAdd = false;
        for (String caseName : getCaseNames(suite)) {
            Log.i("AUTO","caseName : "+caseName);
            if(caseName.contains(crashCaseName)){
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

    /**
     * 获取用例名。分为TestSuite和Test两种。遍历获取
     * 把获得到的用例加入List<String>中。在最后一个用例加上FinalTest（记得要全路径）
     * @param suite
     * @return
     */
    public List<String> getCaseNames(TestSuite suite) {
        List<String> cases = new ArrayList<>();
        for( int i=0; i < suite.testCount(); i++){
            for( int j=0; j < ((TestSuite)suite.testAt(i)).testCount(); j++){
                String name = ((TestSuite)suite.testAt(i)).testAt(j).toString();
//                Log.i("AUTO","caseName : "+name);
                cases.add(name);
            }
        }
        cases.add("net.oschina.app.com.oschina.FinalTest");
        return cases;
    }

    /**
     * 获取发生崩溃的用例名
     * 
     * @return
     */
    public String getCrashName() {
        String name = "";
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(Environment.getExternalStorageDirectory() + "/crash.txt");
            br = new BufferedReader(fr);
            name = br.readLine();
        } catch (Exception ex) {

        } finally {
            try {
                fr.close();
                br.close();
            } catch (Exception ex) {

            }
        }
        return name;
    }
}
