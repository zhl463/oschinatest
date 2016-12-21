package net.oschina.app.com.oschina;

import android.util.Log;

import junit.framework.Assert;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Aaron on 2016/12/10.
 */
public class Utils {

    public static void doCross(String className,String methodName,String extraValue){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://10.0.0.32:8080/Server3/Server").newBuilder();
        urlBuilder.addQueryParameter("className", className);
        urlBuilder.addQueryParameter("methodName", methodName);
        urlBuilder.addQueryParameter("extraValue",extraValue);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String resStr = response.body().string().toString();
            JSONObject json = new JSONObject(resStr);
            //返回格式是JSON类型，返回的key是resultMsg，成功执行后返回的内容是Executed successfully!
            String msg = json.get("resultMsg").toString();
            Assert.assertEquals("Executed successfully!",msg);
        } catch (IOException e) {
            Log.i("AUTO",e.getMessage()+"");
            Assert.fail("跨应用操作失败！");
        } catch (JSONException e) {
            e.printStackTrace();
            Assert.fail("跨应用操作失败！");
        }
    }
}
