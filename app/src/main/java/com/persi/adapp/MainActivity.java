package com.persi.adapp;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private final String APP_ID="ca-app-pub-3940256099942544~3347511713";
    private AdView mAdView;
    private Button mButton;
    private TextView mTextView;
    private TextInputEditText mTextInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, APP_ID);
        mAdView = findViewById(R.id.main_adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("97F84E2DAA26F15D8141753F76ED0932")
                .build();
        if(adRequest.isTestDevice(this)){
            mAdView.loadAd(adRequest);
        }

        mButton=findViewById(R.id.main_button);
        mTextView=findViewById(R.id.main_textview);
        mTextInputEditText=findViewById(R.id.main_text_input);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
        });
    }

    public void buttonPressed(View v){
        mTextView.setText(mTextInputEditText.getText().toString());
    }
}
