package com.tencent.mm.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class WechatTest extends ActivityInstrumentationTestCase2 {
  	private Solo solo;
  	
  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.tencent.mm.ui.LauncherUI";

    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
  	
  	@SuppressWarnings("unchecked")
    public WechatTest() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'com.tencent.mm.ui.LauncherUI'
		solo.waitForActivity("LauncherUI", 2000);
        //Set default small timeout to 15338 milliseconds
		Timeout.setSmallTimeout(15338);
        //Click on зЂВс
		solo.clickOnView(solo.getView("ca3"));
        //Wait for activity: 'com.tencent.mm.ui.account.RegByMobileRegAIOUI'
		assertTrue("RegByMobileRegAIOUI is not found!", solo.waitForActivity("RegByMobileRegAIOUI"));
        //Enter the text: 'asd'
		solo.clearEditText((android.widget.EditText) solo.getView("g_"));
		solo.enterText((android.widget.EditText) solo.getView("g_"), "asd");
        //Click on Empty Text View
		solo.clickOnView(solo.getView("boq"));
        //Enter the text: '123456'
		solo.clearEditText((android.widget.EditText) solo.getView("boq"));
		solo.enterText((android.widget.EditText) solo.getView("boq"), "123456");
        //Set default small timeout to 16836 milliseconds
		Timeout.setSmallTimeout(16836);
        //Click on Empty Text View
		solo.clickOnView(solo.getView("g_", 1));
	}
}
