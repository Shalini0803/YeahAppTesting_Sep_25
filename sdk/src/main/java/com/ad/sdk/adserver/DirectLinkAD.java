package com.ad.sdk.adserver;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.webkit.WebView;

import com.ad.sdk.utils.LoadData;

public class DirectLinkAD {

    public DirectLinkAD() {
    }


    public void loadDirectLinkAd(Context adViewContext, WebView webView) {
        String HtmlCode = new LoadData().loadTextBanner(adViewContext);
        int maxLogSize = 4000;
        for (int j = 0; j <= HtmlCode.length() / maxLogSize; j++) {
            int start = j * maxLogSize;
            int end = (j + 1) * maxLogSize;
            end = end > HtmlCode.length() ? HtmlCode.length() : end;
            Log.d("mulitZone", "HTML CODE:" + HtmlCode.substring(start, end));
        }

        webView.setBackgroundColor(0);
        webView.setPadding(0, 0, 0, 0);
        webView.getSettings().setJavaScriptEnabled(true);
        String html = "<!DOCTYPE html><html>" +
                "<style type='text/css'>" +
                "html,body {margin: 0;padding: 0;width: 100%;height: 100%;}" +
                "html {display: table;}" +
                "body {display: table-cell;vertical-align: middle;text-align: center;}" +
                "img{display: inline;height: auto;max-width: 100%;}" +
                "</style>" +
                "<body style= \"width=\"100%\";height=\"100%\";initial-scale=\"1.0\"; maximum-scale=\"1.0\"; user-scalable=\"no\";>" + HtmlCode + "</body></html>";

        System.out.println("@@ html"+ html);
        webView.loadData(html, "text/html", "UTF-8");
        //ad_container_params = new LayoutParams(-2, -2);
        //zoneArrayList.get(0).getMultipleView().setLayoutParams(ad_container_params);
        webView.setClickable(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);


    }
}
