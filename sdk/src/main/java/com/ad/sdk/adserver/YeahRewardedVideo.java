package com.ad.sdk.adserver;


import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.ad.sdk.adserver.Listener.RewardedAdListener;
import com.google.android.gms.ads.rewarded.RewardedAd;


public class YeahRewardedVideo {

    RewardedAd rewardedAd;
    boolean isLoading;
    public static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917";
    public static final String TAG = "MainActivity";
    public static RewardedAdListener rewardadListener = null;


    public RewardedAdListener getRewardadListen() {
        return rewardadListener;
    }

    public void setRewardadListen(RewardedAdListener rewardadListen) {
        this.rewardadListener = rewardadListen;
    }


    public void show(Context context, RewardedAdListener listener) {
        setRewardadListen(listener);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("RewardedVideo", MODE_PRIVATE);
            String ad_url = sharedPreferences.getString("RewardedVideo_URL", "");
            String ad_check = sharedPreferences.getString("ad_check", "0");

            if (ad_check.equalsIgnoreCase("1")) {
                if (ad_url.length() > 0) {
                    System.out.println("@@ RewardedVideo_URL ad_url " + ad_url);

                    Intent i = new Intent(context, RewardedLoadActivity.class);
                    i.putExtra("Lis", String.valueOf(listener));
                    context.startActivity(i);
                } else {
                    Log.d("SDK", "No Ads:");
                }
            } else {
                Log.e("Ad Shown Status :", "Targeting Not Match");
            }

        } catch (Exception e) {
            Log.d("SDK", "Rewardedvideo Ad Exception:" + e);
        }


    }

    public void load(Context context, RewardedAdListener listener) {
        setRewardadListen(listener);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("RewardedVideo", MODE_PRIVATE);
            String ad_url = sharedPreferences.getString("RewardedVideo_URL", "");
            String ad_check = sharedPreferences.getString("ad_check", "0");

            if (ad_check.equalsIgnoreCase("1")) {
                if (ad_url.length() > 0) {
                    System.out.println("@@ RewardedVideo_URL ad_url " + ad_url);


                } else {
                    Log.d("SDK", "No Ads:");
                }
            } else {
                Log.e("Ad Shown Status :", "Targeting Not Match");
            }

        } catch (Exception e) {
            Log.d("SDK", "Rewardedvideo Ad Exception:" + e);
        }


    }


}


