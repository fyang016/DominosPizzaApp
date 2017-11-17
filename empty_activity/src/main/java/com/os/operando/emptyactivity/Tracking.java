package com.os.operando.emptyactivity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Tracking extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mLoadingText;

    private int mProgressStatus = 0;
    private int xCount = 0;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mLoadingText = (TextView) findViewById(R.id.Loading0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);

                            if (mProgressStatus < 25 && mProgressStatus >= 0) {
                                mLoadingText.setVisibility(View.VISIBLE);
                            }
                            if (mProgressStatus < 50 && mProgressStatus >= 25) {
                                mLoadingText.setVisibility(View.INVISIBLE);
                                mLoadingText = (TextView) findViewById(R.id.Loading1);
                                mLoadingText.setVisibility(View.VISIBLE);
                            }
                            if (mProgressStatus < 75 && mProgressStatus >= 50) {
                                mLoadingText.setVisibility(View.INVISIBLE);
                                mLoadingText = (TextView) findViewById(R.id.Loading2);
                                mLoadingText.setVisibility(View.VISIBLE);
                            }
                            if (mProgressStatus < 98 && mProgressStatus >= 75) {
                                mLoadingText.setVisibility(View.INVISIBLE);
                                mLoadingText = (TextView) findViewById(R.id.Loading3);
                                mLoadingText.setVisibility(View.VISIBLE);
                            }

                            if (mProgressStatus == 98 || mProgressStatus == 99 || mProgressStatus == 100) {
                                mLoadingText.setVisibility(View.INVISIBLE);
                                mLoadingText = (TextView) findViewById(R.id.Loading4);
                                mLoadingText.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        mLoadingText.setVisibility(View.VISIBLE);
//                    }
//                });

            }
        }).start();
    }
}