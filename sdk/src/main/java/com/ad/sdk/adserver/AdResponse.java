package com.ad.sdk.adserver;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ad.sdk.utils.Cdlog;
import com.ad.sdk.utils.LoadData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

public class AdResponse {

    private JSONObject nativeadsres;


    String res = "{\"response\":\"success\",\"ads\":[{\"response\":\"success\",\"imp_url\":\"http%3A%2F%2F43.204.47.201%2FAdmobileadSDK541%2Fwww%2Fdelivery%2Flg.php%3Fbannerid%3D19%26campaignid%3D1%26zoneid%3D14%26cb%3Dac2d080509zoneid%3D14%26width%3D%26height%3D%26keywords%3D%26lattitude%3D%26longitude%3D%26systemtype%3D%26ip%3D%26layerstyle%3D%26screenwidth%3D%26screenheight%3D%26displaywidth%3D%26displayheight%3D%26displaytype%3D%26devicemodel%3D%26devicebrand%3D%26deviceos%3D%26deviceosversion%3D%26is_js_enabled%3D%26carrier%3D%26country%3D%26countryname%3D%26region%3D%26city%3D%26useragent%3D%26language%3D%26postalcode%3D%26device_appid%3D%26device_app_cat%3D%26device_app_sha1%3D%26device_app_md5%3D%26device_app_dpidsha1%3D%26device_app_dpidmd5%3D%26device_app_ipv6%3D%26udid%3D%26timezone%3D%26dataspeed%3D%26connection%3Dkeep-alive%26connectiontype%3D%26Viewername%3D%26Vieweremail%3D%26Viewerphone%3D%26Viewergender%3D%26Viewerage%3D%26userid%3D%26pincode%3D\",\"ad_type\":\"Image\",\"ad_tag\":\"<script type='text\\/javascript' src='http:\\/\\/43.204.47.201\\/AdmobileadSDK541\\/www\\/admin\\/plugins\\/mobileAdsDelivery\\/floatal.php?zoneid=14&width=&height=&keywords=&lattitude=&longitude=&systemtype=&ip=&layerstyle=&screenwidth=&screenheight=&displaywidth=&displayheight=&displaytype=&devicemodel=&devicebrand=&deviceos=&deviceosversion=&is_js_enabled=&carrier=&country=&countryname=&region=&city=&useragent=&language=&postalcode=&device_appid=&device_app_cat=&device_app_sha1=&device_app_md5=&device_app_dpidsha1=&device_app_dpidmd5=&device_app_ipv6=&udid=&timezone=&dataspeed=&connection=keep-alive&connectiontype=&Viewername=&Vieweremail=&Viewerphone=&Viewergender=&Viewerage=&userid=&pincode=&layerstyle=simple&request_id=&viewerid=&hide=0&trail=0&stickyness=2'><\\/script>\",\"click_url\":\"http%3A%2F%2F43.204.47.201%2FAdmobileadSDK541%2Fwww%2Fdelivery%2Fcl.php%3Fbannerid%3D19%26zoneid%3D14%26userid%3D%26device_appid%3D%26connectiontype%3D%26devicebrand%3D%26deviceos%3D%26deviceosversion%3D%26screenwidth%3D%26screenheight%3D%26carrier%3D%26timezone%3D%26udid%3D%26useragent%3D%26Viewername%3D%26Vieweremail%3D%26Viewerphone%3D%26language%3D%26dataspeed%3D%26displaytype%3D%26device_app_dpidmd5%3D%26device_app_dpidsha1%3D%26devicemodel%3D%26sig%3Dec414369831fa1abf37e965700d510f2555625dfd45f7d53d72cb0b31e5d8be5%26dest%3Dhttp%253A%252F%252Fwww.google.com\",\"width\":\"320\",\"height\":\"50\",\"image_path\":\"http:\\/\\/43.204.47.201\\/AdmobileadSDK541\\/www\\/images\\/15c8d3d827719a7c5825865a0cd57556.jpg\"}]}";
    //Rewarded Video
    private JSONObject rewardedres;

    ArrayList<AdResponseValue> adResponseValues;

    private String adtag = null;
    private String ad_type = null;
    private String imp_url = null;
    private String click_url = null;
    private String req_url = null;
    public String status = "error";

    private String nativead_adtag = null;
    public String video = null;

    String interstitialVideoTag = null;
    String interstitialImageTag = null;
    String rewardedVideoTag = null;
    String inArticleVideoTag = null;


    private volatile boolean parsingComplete = true;

    private volatile boolean failed = false;
    private String error_code = null;
    private String error_desc = null;

    //Mediation
    private String ad_network = null;
    public String adunit = null;
    public String notinid;
    public int networkid;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdtag() {
        return adtag;
    }

    public String getAd_type() {
        return ad_type;
    }

    public void setAd_type(String ad_type) {
        this.ad_type = ad_type;
    }

    public String getImp_url() {
        return imp_url;
    }

    public String getClick_url() {
        return click_url;
    }

    public boolean isParsingComplete() {
        return parsingComplete;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public String getError_code() {
        return error_code;
    }

    public String getError_desc() {
        return error_desc;
    }

    //InterstitialVideo

    public String getInterstitialVideoTag() {
        return interstitialVideoTag;
    }

    public void setInterstitialVideoTag(String interstitialVideoTag) {
        this.interstitialVideoTag = interstitialVideoTag;
    }


    //IntertitialImage

    public String getInterstitialImageTag() {
        return interstitialImageTag;
    }

    public void setInterstitialImageTag(String interstitialImageTag) {
        this.interstitialImageTag = interstitialImageTag;
    }

    //Rewarded

    public String getRewardedVideoTag() {
        return rewardedVideoTag;
    }

    public void setRewardedVideoTag(String rewardedVideoTag) {
        this.rewardedVideoTag = rewardedVideoTag;
    }


    //Native video

    public JSONObject getNativeadsres() {
        return nativeadsres;
    }

    public JSONObject getrewardadsres() {
        return rewardedres;
    }

    public String getAdunit() {
        return adunit;
    }

    public void setAdunit(String adunit) {
        this.adunit = adunit;
    }

    public String getAd_network() {
        return ad_network;
    }

    public void setAd_network(String ad_network) {
        this.ad_network = ad_network;
    }

    public ArrayList<AdResponseValue> getAdResponseValues() {
        return adResponseValues;
    }

    public void setAdResponseValues(ArrayList<AdResponseValue> adResponseValues) {
        this.adResponseValues = adResponseValues;
    }

    public void readAndParseJSON(String result, Context context) {

        try {
            if (result != null) {
                adResponseValues = new ArrayList<AdResponseValue>();

                JSONObject reader = new JSONObject(result);
                //JSONObject reader = new JSONObject(res);
                String ad_response = reader.getString(Config.TAG_AD_RESPONSE);
                System.out.println("@@ ad_response" + ad_response);

                ad_response = ad_response.trim();
                new LoadData().logoutClear(context);

                if (ad_response.equalsIgnoreCase("success")) {

                    //JSONObject ads = reader.getJSONObject(Config.TAG_ADS);
                    JSONArray ads = reader.getJSONArray(Config.TAG_ADS);

                    for (int i = 0; i < ads.length(); i++) {
                        try {
                            JSONObject jsonObj = ads.getJSONObject(i);

                            String sub_status = jsonObj.getString(Config.TAG_AD_RESPONSE);

                            System.out.println("@@ sub_status" + sub_status);

                            if (sub_status.equalsIgnoreCase("success")) {


                                status = "success";
                                ad_type = jsonObj.getString(Config.TAG_AD_TYPE);
                                Log.d("dJAXM", "ad_type : " + ad_type);
                                if (ad_type.equalsIgnoreCase("M_NAT_VID")
                                        || ad_type.equalsIgnoreCase("IN_ART_VID")
                                        || ad_type.equalsIgnoreCase("IN_FEED_VID")) {
                                    imp_url = URLDecoder.decode(jsonObj.getString(Config.TAG_BEACON_URL), "UTF-8");

                                    click_url = URLDecoder.decode(jsonObj.getString(Config.TAG_CLICK_URL), "UTF-8");
                                    nativead_adtag = URLDecoder.decode(jsonObj.getString(Config.TAG_NATIVE_TAG), "UTF-8");

                                    nativeadsres = jsonObj.getJSONObject("Native_ad");
                                    Log.d("nativeadsres", "nativeadsres : " + nativeadsres);
                                }

                                //Banner Text Ad
                                else if (ad_type.equalsIgnoreCase("REDIRECT_ADS")) {
                                    Log.d("Banner Text :", "textBanner AD");
                                    String bannerText = jsonObj.getString("ad_tag");
//                                    if (jsonObj.getString("ad_check").equalsIgnoreCase("1")) {
//
//                                        Log.e("BannerTextAD Status", "AD SHOWN..");
//
//                                    } else {
//                                        Log.e("BannerTextAD Status", "AD NOT SHOWN..");
//                                    }
                                    new LoadData().saveTextBanner(context, bannerText);
                                }

                                //Banner Image Ad
                                else if (ad_type.equalsIgnoreCase("Banner")) {
                                    Log.d("Banner Image :", "Image Banner AD");
                                    String bannerImage = null;
                                    if (jsonObj.getString("ad_check").equalsIgnoreCase("1")) {
                                        bannerImage = jsonObj.getString("ad_tag");
                                        Log.e("BannerImageAD Status", "AD SHOWN..");

                                    } else {
                                        Log.e("BannerImageAD Status", "AD NOT SHOWN..");
                                    }
                                    new LoadData().saveBannerImage(context, bannerImage);
                                }


                                //TopBanner
                                else if (ad_type.equalsIgnoreCase("Top Banner")) {
                                    Log.d("TopBanner Ad:", "TOP_BANNER AD");
                                    int width = Integer.parseInt(jsonObj.getString("width"));
                                    int height = Integer.parseInt(jsonObj.getString("height"));

                                    String topBannerURL = null;
                                    if (jsonObj.getString("ad_check").equalsIgnoreCase("1")) {
                                        topBannerURL = jsonObj.getString("ad_tag");
                                        Log.e("TopBannerAD Status", "AD SHOWN..");

                                    } else {
                                        Log.e("TopBannerAD Status", "AD NOT SHOWN..");
                                    }

                                    new LoadData().saveTopBanner(context, topBannerURL, width, height);
                                }


                                //BottomSlider
                                else if (ad_type.equalsIgnoreCase("Bottom Slider")) {
                                    Log.d("BottomSlider Ad:", "BOTTOM_SLIDER AD");

                                    String bottomSliderURL = null;
                                    if (jsonObj.getString("ad_check").equalsIgnoreCase("1")) {
                                        bottomSliderURL = jsonObj.getString("ad_tag");
                                        Log.e("BottomSliderAD Status", "AD SHOWN..");
                                    } else {
                                        Log.e("BottomSliderAD Status", "AD NOT SHOWN..");
                                    }


                                    new LoadData().saveBottomSlider(context, bottomSliderURL);
                                }


                                //HTML Ads
                                else if (ad_type.equalsIgnoreCase("HTML")) {
                                    Log.d("Html Ad:", "HTML AD");
                                    String htmlURL = null;
                                    if (jsonObj.getString("ad_check").equalsIgnoreCase("1")) {
                                        htmlURL = jsonObj.getString("ad_tag");
                                        Log.e("HtmlAD Status", "AD SHOWN..");
                                    } else {
                                        Log.e("HtmlAD Status", "AD NOT SHOWN..");
                                    }
                                    new LoadData().saveHTML(context, htmlURL);
                                }

                                //HTML_5 Ads
                                else if (ad_type.equalsIgnoreCase("HTML5")) {
                                    Log.d("Html5 Ad:", "HTML5 AD");
                                    String html5URL = null;
                                    if (jsonObj.getString("ad_check").equalsIgnoreCase("1")) {
                                        html5URL = jsonObj.getString("ad_tag");
                                        Log.e("Html5AD Status", "AD SHOWN..");
                                    } else {
                                        Log.e("Html5AD Status", "AD NOT SHOWN..");
                                    }
                                    new LoadData().saveHTML_5(context, html5URL);
                                }


                                //Rewarded Video Ads
                                else if (ad_type.equalsIgnoreCase("REWARDED_VID")) {
                                    String screenType = jsonObj.getString("layout");
                                    String ad_check = jsonObj.getString("ad_check");


                                    if (ad_check.equalsIgnoreCase("1")) {
                                        Log.e("Rewarded_Video Status", "AD SHOWN..");
                                        rewardedVideoTag = jsonObj.getString("ad_tag");
                                        Log.d("rewardedres", "rewardedres : " + rewardedres);
                                    } else {
                                        Log.e("Rewarded_Video Status", "AD NOT SHOWN..");
                                    }

                                    JSONObject ad_values = jsonObj.getJSONObject("ad_values");
                                    JSONArray rewards = ad_values.getJSONArray("rewards");
                                    Log.e("reward", rewards.toString());


                                    String amount = null;
                                    JSONObject amount_object = rewards.getJSONObject(0);
                                    amount = amount_object.getString("amount");

                                    Log.e("amount", amount);

                                    SharedPreferences sharedPreferences = context.getSharedPreferences("reward_amount", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("amount", amount);
                                    editor.apply();

                                    new LoadData().saveRewardedVideo(context, rewardedVideoTag, screenType, ad_check);

                                }

                                //InArticle Video Ads
                                else if (ad_type.equalsIgnoreCase("INARTICLE_VIDEO_ADS")) {
                                    String ad_check = jsonObj.getString("ad_check");


                                    if (ad_check.equalsIgnoreCase("1")) {
                                        inArticleVideoTag = jsonObj.getString("ad_tag");
                                        Log.d("InarticleAds : ", inArticleVideoTag);
                                        Log.e("InArticleVideo Status", "AD SHOWN..");
                                    } else {
                                        Log.e("InArticleVideo Status", "AD NOT SHOWN..");
                                    }

                                    new LoadData().saveInArticleVideo(context, inArticleVideoTag, ad_check);
                                }


                                //Video Ads
                                //Interstitial Video Ads
                                else if (ad_type.equalsIgnoreCase("INTERSTITIAL_VID")) {

                                    String ad_check = jsonObj.getString("ad_check");
                                    String screenType = jsonObj.getString("layout");


                                    if (ad_check.equalsIgnoreCase("1")) {
                                        interstitialVideoTag = jsonObj.getString("ad_tag");
                                        Log.d("inarticleAds : ", interstitialVideoTag);
                                        Log.e("InArticleVideo Status", "AD SHOWN..");
                                    } else {
                                        Log.e("InArticleVideo Status", "AD NOT SHOWN..");
                                    }

                                    new LoadData().saveInterstitialVideo(context, interstitialVideoTag, screenType, ad_check);

                                } else if (ad_type.equalsIgnoreCase("Interstitial")) {

                                    String ad_check = jsonObj.getString("ad_check");
                                    interstitialImageTag = jsonObj.getString("ad_tag");

                                    Log.d("SDK", "interstitialImageTag" + interstitialImageTag);

                                    new LoadData().saveInterstitialImage(context, interstitialImageTag, "", ad_check);

                                } else {
                                    imp_url = URLDecoder.decode(jsonObj.getString(Config.TAG_BEACON_URL), "UTF-8");

                                    click_url = URLDecoder.decode(jsonObj.getString(Config.TAG_CLICK_URL), "UTF-8");

                                    adtag = URLDecoder.decode(jsonObj.getString(Config.TAG_ADTAG), "UTF-8");

                                    AdResponseValue adv = new AdResponseValue();
                                    adv.setZone_id("0");
                                    adv.setImp_url(imp_url);
                                    adv.setClick_url(click_url);
                                    adv.setAd_tag(adtag);
                                    adResponseValues.add(adv);
                                }

                            } else {

                                failed = true;
                                JSONObject error = jsonObj.getJSONObject(Config.TAG_ERROR);
                                error_code = error.getString(Config.TAG_ERR_CODE);
                                error_desc = error.getString(Config.TAG_ERR_DESC);
                            }


                        } catch (UnsupportedEncodingException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                    if (adResponseValues.size() > 0) {
                        new LoadData().saveBasicAdsData(context, adResponseValues);
                    }
                   /* if(ads!=null)
                    {
                        try {
                            //ad_network =ads.getString("ad_network");
                            ad_network ="internal";
                            ad_type = ads.getString(Config.TAG_AD_TYPE);
                            Log.d("dJAXM", "ad_type : " + ad_type);
                            if(ad_network.equalsIgnoreCase("internal")) {
                                if (ad_type.equalsIgnoreCase("IMAGE")) {
                                    adtag = URLDecoder.decode(ads.getString(Config.TAG_IMAGE_PATH), "UTF-8");
                                }
                                //native & Article & in-Feed video ads
                                else if (ad_type.equalsIgnoreCase("M_NAT_VID")) {
                                    imp_url = URLDecoder.decode(ads.getString(Config.TAG_BEACON_URL), "UTF-8");

                                    click_url = URLDecoder.decode(ads.getString(Config.TAG_CLICK_URL), "UTF-8");
                                    nativead_adtag = URLDecoder.decode(ads.getString(Config.TAG_NATIVE_TAG), "UTF-8");

                                    nativeadsres = ads.getJSONObject("Native_ad");
                                    Log.d("nativeadsres", "nativeadsres : " + nativeadsres);
                                }

                                //Rewarded Video Ads
                                else if (ad_type.equalsIgnoreCase("REWARDED_VID")) {
                                    //rewardedres = ads.getJSONObject("RewardedVideo_ad");
                                    rewardedres = ads.getJSONObject("ad_tag");
                                }
                                //Interstitial Video Ads
                                else if (ad_type.equalsIgnoreCase("M_INT_VID")) {
                                    //rewardedres = ads.getJSONObject("RewardedVideo_ad");
                                    rewardedres = ads.getJSONObject("ad_tag");
                                } else {
                                    imp_url = URLDecoder.decode(ads.getString(Config.TAG_BEACON_URL), "UTF-8");

                                    click_url = URLDecoder.decode(ads.getString(Config.TAG_CLICK_URL), "UTF-8");

                                    adtag = URLDecoder.decode(ads.getString(Config.TAG_ADTAG), "UTF-8");
                                }
                            }
                            else if(ad_network.equalsIgnoreCase("mediation"))
                            {

                                click_url 			= URLDecoder.decode(ads.getString(Config.TAG_CLICK_URL),"UTF-8");
                                imp_url 			= URLDecoder.decode(ads.getString(Config.TAG_BEACON_URL),"UTF-8");
                                req_url 			= URLDecoder.decode(ads.getString("request_url"),"UTF-8");

                                notinid = ads.getString("NOTINid");
                                networkid = ads.getInt("Mediation_id");
                                JSONObject server_extra=ads.getJSONObject("server_extra");
                                adunit=server_extra.getString("Adunit");
                                System.out.println("@ adunit "+adunit);
                            }


                        } catch (UnsupportedEncodingException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
*/


                } else {

                    // Handle Error Flow
                    Cdlog.d("mSDK Debug", ad_response);
                    failed = true;
                    JSONObject error = reader.getJSONObject(Config.TAG_ERROR);
                    error_code = error.getString(Config.TAG_ERR_CODE);
                    error_desc = error.getString(Config.TAG_ERR_DESC);

                }
                parsingComplete = false;
            } else {
                System.out.print("Caught NullPointerException: Null result return from given URL!!");
            }
        } catch (JSONException e) {
            Log.e("mSDK Debug", "unexpected JSON exception", e);
            e.printStackTrace();
        }
    }

    public void saveRewardedVideo(Context context, String url, String screenType) {

        logoutRewardedVideoAction(context);

        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        System.out.println("@@ RewardedVideo save url" + url);
        SharedPreferences sharedPreferences = context.getSharedPreferences("RewardedVideo", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();


        // prefs in the form of string.
        editor.putString("RewardedVideo_URL", url);
        editor.putString("screenType", screenType);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.commit();


    }

    public void logoutRewardedVideoAction(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RewardedVideo", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void saveInterstitialVideo(Context context, String url, String screenType) {

        logoutInterstitialVideoAction(context);

        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        System.out.println("@@ InterstitialVideo save url" + url);
        SharedPreferences sharedPreferences = context.getSharedPreferences("InterstitialVideo", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();


        // prefs in the form of string.
        editor.putString("InterstitialVideo_URL", url);
        editor.putString("screenType", screenType);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.commit();


    }

    public void logoutInterstitialVideoAction(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("InterstitialVideo", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    //InterstitialImage
    public void saveInterstitialImage(Context context, String url, String screenType) {

        logoutInterstitialImageAction(context);

        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        System.out.println("@@ save InterstitialImageurl" + url);
        SharedPreferences sharedPreferences = context.getSharedPreferences("InterstitialImage", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();


        // prefs in the form of string.
        editor.putString("InterstitialImage_URL", url);
        editor.putString("screenType", screenType);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.commit();


    }

    public void logoutInterstitialImageAction(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("InterstitialImage", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void saveBasicAdsData(Context context, ArrayList<AdResponseValue> adResponseValues) {

        logoutBasicAdsAction(context);

        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = context.getSharedPreferences("sharedpreferences", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(adResponseValues);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("SDK_LOCAL", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.commit();


    }

    public void logoutBasicAdsAction(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sharedpreferences", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

}
