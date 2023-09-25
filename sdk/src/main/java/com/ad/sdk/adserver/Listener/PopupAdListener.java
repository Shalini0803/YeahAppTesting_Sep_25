package com.ad.sdk.adserver.Listener;

public interface PopupAdListener {

    void onAdLoaded();

    void onAdFailed();

    void onAdShown();

    void onAdClicked();

    void onAdDismissed();
}
