package com.test.sheetal.mytest.common;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.sheetal.mytest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {
    @BindView(R.id.noConnectionLayout)
    public RelativeLayout noConnectionLayout;
    @BindView(R.id.errorLayout)
    RelativeLayout errorLayout;
    /*  @BindView(R.id.networkRetryTextView)
      public TextView networkRetryTextView;*/
    @BindView(R.id.connectionMessageTitle)
    public TextView connectionMessageTitle;
    @BindView(R.id.connectionMessageSubTitle)
    public TextView connectionMessageSubTitle;
    private ProgressDialog mProgressDialog;


    ConnectivityManager connectivityManager;
    NetworkListener networkListener;


    public BroadcastReceiver networkDetectReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkInternetConnection();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        mProgressDialog = new ProgressDialog(this);
    }

    @Override
    public void setContentView(int layoutid) {
        super.setContentView(layoutid);
        ButterKnife.bind(this);
        checkInternetConnection();
        setCustomFontFaces();
        errorLayout.setVisibility(View.VISIBLE);
    }

    private void setCustomFontFaces() {
        connectionMessageTitle.setTypeface(getSemiBoldTypeface());
        connectionMessageSubTitle.setTypeface(getLightTypeface());
    }

    public Typeface getSemiBoldTypeface() {
        return Typeface.createFromAsset(getAssets(), "fonts/open-sans.semibold.ttf");
    }

    public Typeface getLightTypeface() {
        return Typeface.createFromAsset(getAssets(), "fonts/open-sans.light.ttf");
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkDetectReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkDetectReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private void checkInternetConnection() {
        noConnectionLayout.setVisibility(View.GONE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!hasConnectivity()) {
                    closeKeyBoard();
                    noConnectionLayout.setVisibility(View.VISIBLE);

                } else {
                    if (networkListener != null)
                        networkListener.onNetworkRestored();
                    noConnectionLayout.setVisibility(View.GONE);
                }
            }
        }, 100);

    }

    public boolean hasConnectivity() {
        connectivityManager.getActiveNetworkInfo();
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    public interface NetworkListener {
        public void onNetworkRestored();
    }

    public void closeKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
