package lixiaoqian.bwie.com.slidingmenuprac;

import android.app.Application;

import org.xutils.x;


/**
 * @类的用途：
 * @author: 李晓倩
 * @date: 2017/4/15
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
