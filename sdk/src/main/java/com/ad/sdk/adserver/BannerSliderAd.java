package com.ad.sdk.adserver;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.ad.sdk.R;
import com.ad.sdk.adserver.Listener.InterstitialImageAdListener;
import com.ad.sdk.utils.LoadData;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class BannerSliderAd {
    PopupWindow pop;
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "Interstitial_image";

    public BannerSliderAd() {
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void loadBannerSlider(Context context, InterstitialImageAdListener listener) {
        try {

            Activity activity = (Activity) context;
            RelativeLayout relativelayout = new RelativeLayout(activity);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.FILL_PARENT);
            //requestWindowFeature(Window.FEATURE_NO_TITLE);
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customview = layoutInflater.inflate(R.layout.popup_banner_slider, null);
            ImageView close = (ImageView) customview.findViewById(R.id.img_close_btn);
            WebView webView = (WebView) customview.findViewById(R.id.webview);

            String HtmlCode = new LoadData().loadBottomSlider(context);

//            String HtmlCode = "<script type='text/javascript' src='https://revphpe.djaxbidder.com/advancedsdk/www/admin/plugins/mobileAdsDelivery/floatal.php?zoneid=323&width=&height=&keywords=&lattitude=&longitude=&systemtype=&ip=&layerstyle=&screenwidth=&screenheight=&displaywidth=&displayheight=&displaytype=&devicemodel=&devicebrand=&deviceos=&deviceosversion=&is_js_enabled=&carrier=&country=&countryname=&region=&city=&useragent=&language=&postalcode=&device_appid=&device_app_cat=&device_app_sha1=&device_app_md5=&device_app_dpidsha1=&device_app_dpidmd5=&device_app_ipv6=&udid=&timezone=&dataspeed=&connection=&connectiontype=&Viewername=&Vieweremail=&Viewerphone=&Viewergender=&Viewerage=&userid=&layerstyle=simple&request_id=&viewerid=&hide=0&trail=0&stickyness=2'></script>";

            if (HtmlCode.length() > 0) {
                if (HtmlCode.length() > 4000) {
                    Log.v(TAG, "sb.length = " + HtmlCode.length());
                    int chunkCount = HtmlCode.length() / 4000;     // integer division
                    for (int i = 0; i <= chunkCount; i++) {
                        int max = 4000 * (i + 1);
                        if (max >= HtmlCode.length()) {
                            Log.v(TAG, "chunk " + i + " of " + chunkCount + ":" + HtmlCode.substring(4000 * i));
                        } else {
                            Log.v(TAG, "chunk " + i + " of " + chunkCount + ":" + HtmlCode.substring(4000 * i, max));
                        }
                    }
                }
                Log.d("mSDK Debug", "HTML CODE:" + HtmlCode);
                webView.setBackgroundColor(0);
                webView.setPadding(0, 0, 0, 0);
                webView.getSettings().setJavaScriptEnabled(true);
                //String html = "<!DOCTYPE html><html><body style= \"width=\"100%\";height=\"100%\";initial-scale=\"1.0\"; maximum-scale=\"1.0\"; user-scalable=\"no\";\">"+HtmlCode+"</body></html>";
                String html = "<!DOCTYPE html><html><style type='text/css'>html,body {margin: 0;padding: 0;width: 100%;height: 100%;}html {display: table;}body {display: table-cell;vertical-align: middle;text-align: center;}</style><body style= \"width=\"100%\";height=\"100%\";initial-scale=\"1.0\"; maximum-scale=\"1.0\"; user-scalable=\"no\";\">" + HtmlCode + "</body></html>";
                //htmlAd.loadData(html, "text/html", "UTF-8");
                webView.loadDataWithBaseURL("", html, "text/html", "utf-8", "");

                webView.setClickable(true);
                webView.setVerticalScrollBarEnabled(false);
                webView.setHorizontalScrollBarEnabled(false);

                pop = new PopupWindow(customview, ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT);
                pop.showAtLocation(relativelayout, Gravity.CENTER, 0, 0);
                activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                listener.onInterstitialAdShown();
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onInterstitialAdDismissed();
                        pop.dismiss();
                    }
                });


                listener.onInterstitialAdLoaded();
            }

        } catch (Exception e) {
            Log.d("SDK", "Interstital Image Ad Exception:" + e);
        }


    }

    public void loadInterstitialImageMediation(Context context, Activity activity, String adunit) {
        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.load(context, adunit, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(activity);
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.");
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
    }

}
