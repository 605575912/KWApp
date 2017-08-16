package com.ts.fmxt.ui.user;/**
 * Created by A1 on 2017/8/15.
 */

import android.os.Bundle;
import android.view.View;

import com.ts.fmxt.R;

import java.util.Map;

import widget.web.BaseWebActivity;

/**
 * created by kp at 2017/8/15
 * 关于我们
 */
public class AboutusActivity extends BaseWebActivity {

    private String url;
    private int  num;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.include_web_view);
        mTitile = getIntent().getStringExtra("title");
        url = getIntent().getStringExtra("url");
        num = getIntent().getIntExtra("num", 0);
        if (url == null || "".equals(url)) {
            finish();
        }
        initNavigation();
        bindWebView(R.id.refresh_web_view, url);

    }

    @Override
    public void platformPay(Map<String, String> map) {

    }

    @Override
    public void login() {
//        UISkipUtils.showMes(this,"login");
        finish();
    }

    public void initNavigation() {
        if (mTitile != null && !"".equals(mTitile)) {
            navigationView.setTitle(mTitile, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    getBackActive();
                }
            });
        }
    }

    @Override
    public void loadUrl() {
        getAcutoWebView().loadUrl(url);
    }
}
