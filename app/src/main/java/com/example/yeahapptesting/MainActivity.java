package com.example.yeahapptesting;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.Listener.AdViewListener;
import com.ad.sdk.adserver.Listener.BannerListener;
import com.ad.sdk.adserver.Listener.InterstitialImageAdListener;
import com.ad.sdk.adserver.Listener.InterstitialVideoAdListener;
import com.ad.sdk.adserver.Listener.RewardedAdListener;
import com.ad.sdk.adserver.YeahAdsInitialize;
import com.ad.sdk.adserver.YeahBannerImageAD;
import com.ad.sdk.adserver.YeahInterstitialImage;
import com.ad.sdk.adserver.YeahInterstitialVideo;
import com.ad.sdk.adserver.YeahRewardedVideo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         new YeahAdsInitialize(this, "27", new AdViewListener() {
            @Override
            public void onAdLoad() {

            }

            @Override
            public void onAdFail() {

            }
        });





        ((Button) findViewById(R.id.bannerAd)).setOnClickListener(view -> {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    new YeahBannerImageAD().show(MainActivity.this, new BannerListener() {
                        @Override
                        public void BannerAdLoaded() {
                            Log.e("Banner Ad Status", "" + "Showed");

                        }

                        @Override
                        public void BannerAdFailed() {
                            Log.e("Banner Ad Status", "" + "Failed to show");

                        }
                    });

                }
            }, 1500);
        });


        ((Button) findViewById(R.id.interstitialAd)).setOnClickListener(view -> {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    new YeahInterstitialImage().show(MainActivity.this, new InterstitialImageAdListener() {
                        @Override
                        public void onInterstitialAdLoaded() {
                            Log.e("Interstitial AD Status :", "" + "Interstitial AD Loaded");
                        }

                        @Override
                        public void onInterstitialAdFailed() {
                            Log.e("Interstitial AD Status :", "" + "Interstitial AD Failed To show");

                        }

                        @Override
                        public void onInterstitialAdShown() {
                            Log.e("Interstitial AD Status :", "" + "Interstitial AD Shown");

                        }

                        @Override
                        public void onInterstitialAdClicked() {
                            Log.e("Interstitial AD Status :", "" + "Interstitial AD Clicked");

                        }

                        @Override
                        public void onInterstitialAdDismissed() {
                            Log.e("Interstitial AD Status :", "" + "Interstitial AD Dismissed");

                        }
                    });

                }
            }, 1500);
        });


        ((Button) findViewById(R.id.interstitialVideoAd)).setOnClickListener(view -> {

            YeahInterstitialVideo yeahInterstitialVideo = new YeahInterstitialVideo();
            yeahInterstitialVideo.show(MainActivity.this);
            yeahInterstitialVideo.load(MainActivity.this, new InterstitialVideoAdListener() {
                @Override
                public void onInterstitialAdLoaded() {

                }

                @Override
                public void onInterstitialAdFailed() {

                }

                @Override
                public void onInterstitialAdShown() {

                }

                @Override
                public void onInterstitialAdClicked() {

                }

                @Override
                public void onInterstitialAdDismissed() {

                }
            });



        });


        ((Button) findViewById(R.id.rewardedVideoAd)).setOnClickListener(view -> {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    new YeahRewardedVideo().show(MainActivity.this, new RewardedAdListener() {
                        @Override
                        public void Rewarded(String rewardItem, int rewardvalue) {
                            Toast.makeText(MainActivity.this, "Reward Points : " + rewardvalue, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void AdLoaded() {

                        }

                        @Override
                        public void AdFailed() {

                        }

                        @Override
                        public void Adclosed() {

                        }

                        @Override
                        public void Adclicked() {

                        }

                        @Override
                        public void Adshown() {

                        }
                    });


                }
            }, 1500);
        });


    }

}