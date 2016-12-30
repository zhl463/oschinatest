package net.oschina.app.com.oschina;

import android.os.Environment;

import net.oschina.app.BasicTestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Aaron on 2016/12/25.
 */;
public class FinalTest extends BasicTestCase {

    public void testFinal(){
        File fr = null;
        fr = new File(Environment.getExternalStorageDirectory()+"/crash.txt");
        if(fr.exists()){
            fr.delete();
        }
    }
}
