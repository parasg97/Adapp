package com.persi.adapp;

import android.app.NativeActivity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {


    private InterstitialAd mInterstitialAd;
    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        mButton=findViewById(R.id.interstitial_button);
        mButton.setEnabled(false);
        mTextView=findViewById(R.id.interstitial_textView);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mTextView.setText("Add loaded");
                mButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(getApplicationContext(),"dsd",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAdClosed() {
                mTextView.setText(R.string.waiting_for_add_to_load);
                mButton.setEnabled(false);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    public void showAd(View v){
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else{
            Toast.makeText(this,"add not loaded",Toast.LENGTH_LONG).show();
        }
    }

    public void buttonPressed(View v){
        Intent goToNativeAd=new Intent(this, RewardActivity.class );
        finish();
        startActivity(goToNativeAd);
    }
}
