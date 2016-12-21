package net.oschina.app.com.oschina;

import net.oschina.app.SoloWrap;
import net.oschina.app.com.oschina.pages.PageCommon;
import net.oschina.app.com.oschina.pages.PageLogin;
import net.oschina.app.com.oschina.pages.PageMyLoginStatus;
import net.oschina.app.com.oschina.pages.PageMyUnLoginStatus;
import net.oschina.app.com.oschina.pages.PageNavigation;
import net.oschina.app.com.oschina.pages.PageNewsDetail;
import net.oschina.app.com.oschina.pages.PageNewsDetail2;
import net.oschina.app.com.oschina.pages.PageSettings;

/**
 * Created by Aaron on 2016/11/27.
 */
public class PageHelper {
    private SoloWrap solo;
    private PageLogin pageLogin;
    private PageMyUnLoginStatus pageMyUnLoginStatus;
    private PageSettings pageSettings;
    private PageMyLoginStatus pageMyLoginStatus;
    private PageNavigation pageNavigation;
    private PageCommon pageCommon;
    private PageNewsDetail pageNewsDetail;
    private PageNewsDetail2 pageNewsDetail2;

    public PageHelper(SoloWrap solo){
        this.solo = solo;
    }

    public PageLogin getPageLogin(){
        if(pageLogin == null){
            pageLogin = new PageLogin(solo);
        }
        pageLogin.initViews();
        return pageLogin;
    }

    public PageMyUnLoginStatus getPageMyUnLoginStatus(){
        if(pageMyUnLoginStatus == null){
            pageMyUnLoginStatus = new PageMyUnLoginStatus(solo);
        }
        pageMyUnLoginStatus.initViews();
        return pageMyUnLoginStatus;
    }

    public PageSettings getPageSettings(){
        if(pageSettings == null){
            pageSettings = new PageSettings(solo);
        }
        pageSettings.initViews();
        return pageSettings;
    }

    public PageMyLoginStatus getPageMyLoginStatus(){
        if(pageMyLoginStatus == null){
            pageMyLoginStatus = new PageMyLoginStatus(solo);
        }
        pageMyLoginStatus.initViews();
        return pageMyLoginStatus;
    }


    public PageNavigation getPageNavigation(){
        if(pageNavigation == null){
            pageNavigation = new PageNavigation(solo);
        }
        pageNavigation.initViews();
        return pageNavigation;
    }

    public PageCommon getPageCommon(){
        if(pageCommon == null){
            pageCommon = new PageCommon(solo);
        }
        return pageCommon;
    }

    public PageNewsDetail getPageNewsDetail(){
        if(pageNewsDetail == null){
            pageNewsDetail = new PageNewsDetail(solo);
        }
        pageNewsDetail.initViews();
        return pageNewsDetail;
    }

    public PageNewsDetail2 getPageNewsDetail2(){
        if(pageNewsDetail2 == null){
            pageNewsDetail2 = new PageNewsDetail2(solo);
        }
        pageNewsDetail2.initViews();
        return pageNewsDetail2;
    }


}
