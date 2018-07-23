package com.persi.adapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Date;

import static com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR;

/*This class is created for banner ads.
They stay on screen while users are interacting with the app,
and can refresh automatically after a certain period of time. I
 */
public class MainActivity extends AppCompatActivity {
    private final String APP_ID="ca-app-pub-3940256099942544~3347511713";
    private AdView mAdView;
    private Button mButton;
    private TextInputEditText mTextInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, APP_ID);//initialized should be called only once when app is created
        // TODO: 7/23/2018 add adsize and addunit id programmatically
        mAdView = findViewById(R.id.main_adView);
        /*An AdRequest contains targeting information used to fetch an ad
        * we can set information like gender,birthday,location etc. so that user
        * can get more relevant ads*
        * eg. adResquest.setGender()*/
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)//if our app is test app and we are not using the dummy app id provided in documentation we should mark our device as test device
                //.setGender(AdRequest.GENDER_MALE)
                .build();
        mAdView.loadAd(adRequest);
        mButton=findViewById(R.id.main_button);

        
    }

    public void buttonPressed(View v){
        Intent goToInterstitial=new Intent(this,InterstitialActivity.class );
        finish();
        startActivity(goToInterstitial);
    }
}
