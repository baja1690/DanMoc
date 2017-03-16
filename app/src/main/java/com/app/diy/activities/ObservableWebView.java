package com.app.diy.activities;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by Cuong Pham on 3/14/17.
 */

public class ObservableWebView extends WebView {

        private OnScrollChangeListener onScrollChangeListener;

        public ObservableWebView(Context context) {
            super(context);
        }

        @Override
        protected void onScrollChanged(int l, int t, int oldl, int oldt) {
            super.onScrollChanged(l, t, oldl, oldt);
            Log.d("TAG","(yOld,y): "+t+","+oldt);
            if (onScrollChangeListener != null) {
                onScrollChangeListener.onScrollChange(this, l, t, oldl, oldt);
            }
        }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public void flingScroll(int vx, int vy) {
        Log.d("TAG","(vx,vy): "+vx+","+vy);
    }

    public interface OnScrollChangeListener {
            /**
             * Called when the scroll position of a view changes.
             *
             * @param v          The view whose scroll position has changed.
             * @param scrollX    Current horizontal scroll origin.
             * @param scrollY    Current vertical scroll origin.
             * @param oldScrollX Previous horizontal scroll origin.
             * @param oldScrollY Previous vertical scroll origin.
             */
            void onScrollChange(WebView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY);
        }

        public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
            this.onScrollChangeListener = onScrollChangeListener;
        }
}
