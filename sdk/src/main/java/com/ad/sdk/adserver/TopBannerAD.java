package com.ad.sdk.adserver;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ad.sdk.R;
import com.ad.sdk.utils.LoadData;

public class TopBannerAD {

    public TopBannerAD() {
    }

    public void loadImageBanner(Context adViewContext, FrameLayout adView) {


        LayoutInflater layoutInflater = (LayoutInflater) adViewContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customview = layoutInflater.inflate(R.layout.topad_popup, null);
        ImageView close = (ImageView) customview.findViewById(R.id.img_close_btn);
        WebView webView = (WebView) customview.findViewById(R.id.webview);

        String HtmlCode = new LoadData().loadTopBanner(adViewContext);
        SharedPreferences sharedPreferences = adViewContext.getSharedPreferences("BannerAds", MODE_PRIVATE);
        int width = sharedPreferences.getInt("topBanner_adWidth", 0);
        int height = sharedPreferences.getInt("topBanner_adHeight", 0);


//        String HtmlCode = "<script type='text/javascript' src='https://revphpe.djaxbidder.com/advancedsdk/www/admin/plugins/mobileAdsDelivery/floatal.php?zoneid=283&width=&height=&keywords=&lattitude=&longitude=&systemtype=&ip=&layerstyle=&screenwidth=&screenheight=&displaywidth=&displayheight=&displaytype=&devicemodel=&devicebrand=&deviceos=&deviceosversion=&is_js_enabled=&carrier=&country=&countryname=&region=&city=&useragent=&language=&postalcode=&device_appid=&device_app_cat=&device_app_sha1=&device_app_md5=&device_app_dpidsha1=&device_app_dpidmd5=&device_app_ipv6=&udid=&timezone=&dataspeed=&connection=&connectiontype=&Viewername=&Vieweremail=&Viewerphone=&Viewergender=&Viewerage=&userid=&layerstyle=simple&request_id=&viewerid=&hide=0&trail=0&stickyness=2'></script>";

        int maxLogSize = 4000;
        for (int j = 0; j <= HtmlCode.length() / maxLogSize; j++) {
            int start = j * maxLogSize;
            int end = (j + 1) * maxLogSize;
            end = end > HtmlCode.length() ? HtmlCode.length() : end;
            Log.d("mulitZone", "HTML CODE:" + HtmlCode.substring(start, end));
        }


        int height_inDP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, adViewContext.getResources().getDisplayMetrics());
//        int width_2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, width, adViewContext.getResources().getDisplayMetrics());

        webView.getLayoutParams().height = height_inDP;
        webView.setPadding(0, 0, 0, 0);
        webView.setBackgroundColor(Color.WHITE);
        webView.getSettings().setJavaScriptEnabled(true);

        String html = "<!DOCTYPE html><html>" +
                "<style type='text/css'>" +
                "html,body {margin: 0;padding: 0;width: 100%;height: 100%;}" +
                "html {display: table;}" +
                "body {text-align: center;}" +
                "img{display: inline;height: auto;max-width: 100%;}" +
                "</style>" +
                "<body style= \"width=\"100%\";height=\"100%\";initial-scale=\"1.0\"; maximum-scale=\"1.0\"; user-scalable=\"no\";>" + HtmlCode + "</body></html>";

        System.out.println("@@ html" + html);
        webView.loadData(html, "text/html", "UTF-8");
        //ad_container_params = new LayoutParams(-2, -2);
        //zoneArrayList.get(0).getMultipleView().setLayoutParams(ad_container_params);
        webView.setClickable(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);


        adView.addView(customview);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customview.setVisibility(View.GONE);
            }
        });
    }

}
