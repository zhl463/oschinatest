package net.oschina.app;

import android.os.Environment;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.robotium.solo.Solo;

import net.oschina.app.com.oschina.PageHelper;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Aaron on 2016/11/27.
 */
public class BasicTestCase extends ActivityInstrumentationTestCase2<AppStart> {
    protected PageHelper pageHelper;
    private boolean isNeedLogin = false;
    private Solo solo1;
    private SoloWrap solo;


    public BasicTestCase(boolean isNeedLogin) {
        super(AppStart.class);
        this.isNeedLogin = isNeedLogin;
    }

    @Override
    public void setUp() throws Exception {
        try {
            super.setUp();
            logCurrentCaseName();
            solo1 = new Solo(getInstrumentation(), getActivity());
            solo = new SoloWrap(solo1);
            pageHelper = new PageHelper(solo);
            pageHelper.getPageNavigation().clickMyTab();
            if (isNeedLogin) {
                if (!pageHelper.getPageMyLoginStatus().isAlreadyLogin()) {
                    pageHelper.getPageMyUnLoginStatus().clickLoginIcon();
                    pageHelper.getPageLogin().login("735723619@qq.com", "12345678");
                }
            } else {
                if (pageHelper.getPageMyLoginStatus().isAlreadyLogin()) {
                    pageHelper.getPageMyLoginStatus().clickSettings();
                    pageHelper.getPageSettings().clickLogout();
                }
            }
            pageHelper.getPageNavigation().clickNewsTab();
        } catch (Exception ex) {
            Log.i("AUTO", "Exception happened in setup , error msg is: " + ex.getMessage());
            solo.takeScreenshot(this.getClass().getSimpleName());
            tearDown();
            throw ex;
        }

    }


    @Override
    protected void runTest() throws Throwable {
        try {
            super.runTest();
        } catch (Throwable ex) {
            Log.i("AUTO", "Exception happened in runTest , error msg is: " + ex.getMessage());
            solo.takeScreenshot(this.getClass().getSimpleName());
            throw ex;
        }

    }

    @Override
    public void tearDown() throws Exception {
        try {

        } catch (Throwable th) {
            Log.i("AUTO", "Exception happened in teardown , error msg is: " + th.getMessage());
            solo.takeScreenshot(this.getClass().getSimpleName());
            throw th;
        } finally {
            solo.finishOpenedActivities();
            super.tearDown();
        }
    }

    private void logCurrentCaseName() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(Environment.getExternalStorageDirectory() + "/crash.txt");
            fw.write(this.getClass().getSimpleName());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
