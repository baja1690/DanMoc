package com.app.diy.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.diy.R;
import com.app.diy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong Pham on 3/2/17.
 */

public class WebActivity extends BaseActivity {
    @BindView(R.id.rootView)
    LinearLayout rootView;
    private ObservableWebView mWebView;

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, WebActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);

        //setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.webview_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
            case R.id.save:
                saveArticle();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveArticle() {
        Toast.makeText(mContext,"Acticle was saved!",Toast.LENGTH_SHORT).show();
    }

    public void init(){
        mWebView = new ObservableWebView(mContext);
        rootView.addView(mWebView);

        mWebView.loadUrl("https://www.lamsao.com/huong-dan-moc-len-co-ban-cho-nguoi-moi-chua-biet-gi-p214a108474.html");
        //Log.d("TAG","(yOld,y): "+oldScrollY+","+scrollY);
        mWebView.setOnScrollChangeListener(new ObservableWebView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(WebView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            }
        });

        mWebView.setWebViewClient(new DiyWebClient());
    }

    class DiyWebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgress.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mProgress.hide();
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            mProgress.hide();
        }
    }
}
