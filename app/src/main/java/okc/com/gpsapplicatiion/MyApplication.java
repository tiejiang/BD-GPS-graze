package okc.com.gpsapplicatiion;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by yinyu-tiejiang on 18-3-22.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //baidu map init
        SDKInitializer.initialize(this);
    }


}
