package com.app.diy.learning;

import android.os.Looper;
import android.os.Process;

/**
 * Created by Cuong Pham on 3/13/17.
 */

public class MyHandlerThread extends Thread{

    int mPriority;
    int mTid = -1;
    Looper mLooper;

    public MyHandlerThread(String name) {
        super(name);
        mPriority = Process.THREAD_PRIORITY_DEFAULT;
    }

    public MyHandlerThread(String name, int priority) {
        super(name);
        mPriority = priority;
    }
    protected void onLooperPrepared() {
    }
    @Override
    public void run() {
        super.run();
    }
}
