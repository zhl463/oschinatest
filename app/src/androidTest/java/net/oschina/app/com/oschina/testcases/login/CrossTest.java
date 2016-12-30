package net.oschina.app.com.oschina.testcases.login;

import net.oschina.app.BasicTestCase;
import net.oschina.app.com.oschina.Utils;

/**
 * Created by Aaron on 2016/12/10.
 */
public class CrossTest extends BasicTestCase {


    public void testCross(){
        pageHelper.getPageCommon().clickOnText("为什么有些程序员宁愿降薪也要离开创业公司\\？");
        pageHelper.getPageCommon().sleep(8);
        pageHelper.getPageNewsDetail().clickShareImg();
        pageHelper.getPageCommon().clickOnText("QQ");
        pageHelper.getPageCommon().sleep(8);
//        Utils.doCross("C","testC");
    }
}
