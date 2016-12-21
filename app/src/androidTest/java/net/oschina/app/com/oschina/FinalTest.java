package net.oschina.app.com.oschina;

import android.os.Environment;

import net.oschina.app.BasicTestCase;

import java.io.File;

/**
 * Created by Aaron on 2016/11/29.
 */
public class FinalTest extends BasicTestCase{

    public FinalTest(){
        super(false);
        File file = new File(Environment.getExternalStorageDirectory()+"/crash.txt");
        if(file.exists()){
            file.delete();
        }
    }

    public void testFinalTest(){

    }
}
