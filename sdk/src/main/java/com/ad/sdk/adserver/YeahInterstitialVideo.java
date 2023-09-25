package com.ad.sdk.adserver;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.ad.sdk.adserver.Listener.InterstitialVideoAdListener;

public class YeahInterstitialVideo {
  /*  PopupWindow pop;
    private StyledPlayerView playerView;
    private ExoPlayer player;
    private ImaAdsLoader adsLoader;*/


    @SuppressLint("LongLogTag")
    public void show(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("InterstitialVideo", MODE_PRIVATE);
            String ad_url = sharedPreferences.getString("InterstitialVideo_URL", "");
            String ad_check = sharedPreferences.getString("ad_check", "0");


            if (ad_url.length() > 0) {

                if (ad_check.equalsIgnoreCase("1")) {
                    Log.e("InterstitialVideoStatus:", "" + "LoadAd Class Called");
                    Intent i = new Intent(context, LoadActivity.class);
                    context.startActivity(i);
                } else {
                    Log.e("Ad Shown Status", "Targeting Not Match");

                }

//
            } else {
                Log.d("SDK", "No Ads");
            }


        } catch (Exception e) {
            Log.d("SDK", "InterstitialVideo Ad Exception:" + e);
        }


    }


    @SuppressLint("LongLogTag")
    public void load(Context context, InterstitialVideoAdListener interstitialVideoAdListener) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("InterstitialVideo", MODE_PRIVATE);
            String ad_url = sharedPreferences.getString("InterstitialVideo_URL", "");
            String ad_check = sharedPreferences.getString("ad_check", "0");


            if (ad_url.length() > 0) {

                if (ad_check.equalsIgnoreCase("1")) {
                    Log.e("InterstitialVideoStatus:", "" + "LoadAd Class Called");

                } else {
                    Log.e("Ad Shown Status", "Targeting Not Match");

                }

//
            } else {
                Log.d("SDK", "No Ads");
            }


        } catch (Exception e) {
            Log.d("SDK", "InterstitialVideo Ad Exception:" + e);
        }


    }


  /*  public void loadInterstitalVideo(Context context)
    {
        MultiDex.install(context);

        loadpopupShow(context);

        *//*Activity activity = (Activity) context;
        RelativeLayout relativelayout = new RelativeLayout(activity);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customview = layoutInflater.inflate(R.layout.interstitial_video_popup, null);
        ImageView close = (ImageView) customview.findViewById(R.id.img_close_btn);
        playerView = customview.findViewById(R.id.player_view);
        playerView.setControllerAutoShow(false);
        // Create an AdsLoader.
        adsLoader = new ImaAdsLoader.Builder(context).build();
        pop = new PopupWindow(customview, ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT);
        pop.showAtLocation(relativelayout, Gravity.CENTER, 0, 0);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        *//**//*if (Util.SDK_INT > 23) {
            initializePlayer(context);
            if (playerView != null) {
                playerView.onResume();
            }
        }*//**//*
        initializePlayer(context);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//**//*if (Util.SDK_INT > 23) {
                    if (playerView != null) {
                        playerView.onPause();
                    }
                    releasePlayer();
                }*//**//*
                playerView.onPause();
                pop.dismiss();
                releasePlayer();
            }
        });
*//*


    }

    private void initializePlayer(Context context) {
        // Set up the factory for media sources, passing the ads loader and ad view providers.
        DataSource.Factory dataSourceFactory = new DefaultDataSource.Factory(context);

        MediaSourceFactory mediaSourceFactory =
                new DefaultMediaSourceFactory(dataSourceFactory)
                        .setAdsLoaderProvider(unusedAdTagUri -> adsLoader)
                        .setAdViewProvider(playerView);

        // Create an ExoPlayer and set it as the player for content and ads.
        player = new ExoPlayer.Builder(context).setMediaSourceFactory(mediaSourceFactory).build();
        playerView.setPlayer(player);
        adsLoader.setPlayer(player);

        // Create the MediaItem to play, specifying the content URI and ad tag URI.
        //Uri contentUri = Uri.parse(getString(R.string.content_url));
        Uri contentUri = Uri.parse("");
        Uri adTagUri = Uri.parse(context.getString(R.string.ad_tag_url2));
        MediaItem mediaItem =
                new MediaItem.Builder()
                        .setUri(contentUri)
                        .setAdsConfiguration(new MediaItem.AdsConfiguration.Builder(adTagUri).build())
                        .build();

        // Prepare the content and ad to be played with the SimpleExoPlayer.
        player.setMediaItem(mediaItem);
        player.prepare();

        // Set PlayWhenReady. If true, content and ads will autoplay.
        player.setPlayWhenReady(true);




    }

    private void releasePlayer() {
        adsLoader.setPlayer(null);
        playerView.setPlayer(null);
        player.release();
        player = null;
    }

    @Override
    public void onBackPressed() {
        releasePlayer();
    }

    void loadpopupShow(Context context)
    {
        // Create an AdsLoader.
        adsLoader = new ImaAdsLoader.Builder(context).build();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context,R.style.DialogTheme);
// ...Irrelevant code for customizing the buttons and title
        Activity activity = (Activity) context;
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.interstitial_video_popup, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
       *//* EditText editText = (EditText) dialogView.findViewById(R.id.label_field);
        editText.setText("test label");*//*
        playerView = dialogView.findViewById(R.id.player_view);
        playerView.setControllerAutoShow(false);
        ImageView close = (ImageView) dialogView.findViewById(R.id.img_close_btn);


        initializePlayer(context);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        alertDialog.show();

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    playerView.onPause();
                alertDialog.dismiss();
            releasePlayer();
        }
    });

    }

  *//*  @Override
    public void onResume() {
        super.onResume();
        if (Util.SDK_INT <= 23 || player == null) {
            //initializePlayer();
            if (playerView != null) {
                playerView.onResume();
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            if (playerView != null) {
                playerView.onPause();
            }
            releasePlayer();
        }
    }*//*
     */

}
