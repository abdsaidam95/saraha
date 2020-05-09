package com.example.saraha.views;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.R;
import com.example.saraha.adapter.res1_profile_frag.adapter_res1;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.model_of_addmassage;
import com.example.saraha.models.model_of_res_img_profile;
import com.example.saraha.models.model_res1_profile_frag;
import com.example.saraha.models.models_getprofile_by_id_parent;
import com.example.saraha.models.res2_massage_profile_frag;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jaeger.library.StatusBarUtil;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import android.widget.Toast;
//import android.widget.Toast;
//import android.widget.Toast;

public class User_profile_actevity extends Base_activity implements View.OnClickListener {
    private ArrayList<model_of_res_img_profile> array1 = new ArrayList<>();
    private ArrayList<res2_massage_profile_frag> array2;
    private RecyclerView recyclerView;
    private EditText editText;
    private TextView textView1;
    private TextView textView;
    private Bitmap bitmap;
    ProgressDialog progressDoalog;
    private String picturePath;
    private TextView imgeicon;
    private TextView arroww;
    private CircleImageView circleImageView;
    private TextView name;
    private TextView txtnobsa;
    private TextView nikename;
    private String imgse;
    private static final String ADMOB_AD_UNIT_ID = "ca-app-pub-8351929453534437/2560450392";

    private UnifiedNativeAd nativeAd;
    public String ids;
    private ScrollView scrollView;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_actevity);

        StatusBarUtil.setTransparent(this);
        findview();
        setname();
        getprofilebyid();
        initializeRecyclerAdapter3();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        refreshAd();

    }

    /**
     * Populates a {@link UnifiedNativeAdView} object with data from a given
     * {@link UnifiedNativeAd}.
     *
     * @param nativeAd the object containing the ad's assets
     * @param adView   the view to be populated
     */
    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
        // Set the media view.
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));

        // Set other ad assets.
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        // The headline and mediaContent are guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        // This method tells the Google Mobile Ads SDK that you have finished populating your
        // native ad view with this native ad.
        adView.setNativeAd(nativeAd);

        // Get the video controller for the ad. One will always be provided, even if the ad doesn't
        // have a video asset.
        VideoController vc = nativeAd.getVideoController();

        // Updates the UI to say whether or not this ad has a video asset.

    }

    /**
     * Creates a request for a new native ad based on the boolean parameters and calls the
     * corresponding "populate" method when one is successfully returned.
     */
    private void refreshAd() {


        AdLoader.Builder builder = new AdLoader.Builder(this, ADMOB_AD_UNIT_ID);

        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            // OnUnifiedNativeAdLoadedListener implementation.
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                // You must call destroy on old ads when you are done with them,
                // otherwise you will have a memory leak.
                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = unifiedNativeAd;
                FrameLayout frameLayout =
                        findViewById(R.id.fl_adplaceholder);
                UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater()
                        .inflate(R.layout.unit_advanced, null);
                populateUnifiedNativeAdView(unifiedNativeAd, adView);
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
            }

        });


        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {


            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }



    @Override
    protected void onDestroy() {
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        super.onDestroy();
    }




    private void findview (){
        recyclerView=findViewById(R.id.profile_img_res);
        editText=findViewById(R.id.textttttttt);
        editText.setOnClickListener(this);
        constraintLayout=findViewById(R.id.const1);
        circleImageView=findViewById(R.id.img_profiles);
        imgeicon=findViewById(R.id.picc);
        arroww=findViewById(R.id.arrrow);
        txtnobsa=findViewById(R.id.txttt12);
        name=findViewById(R.id.txtttt);
        nikename=findViewById(R.id.nikename);
        scrollView=findViewById(R.id.ssssssss);
        constraintLayout.setOnClickListener(this);
        arroww.setOnClickListener(this);
        imgeicon.setOnClickListener(this);
        constraintLayout.scrollTo(0,constraintLayout.getScrollY());
        textView=findViewById(R.id.action);
        textView.setOnClickListener(this);
    }
    public void setname() {
        UserPref userPref = new UserPref(User_profile_actevity.this);

        String names = getIntent().getExtras().getString("name");
        String niknames = getIntent().getExtras().getString("nikename");
        String photo = getIntent().getExtras().getString("photo");
        Picasso.get().load(photo).into(circleImageView);

        name.setText(names.toString());
        nikename.setText(niknames.toString());
    }
        public void showprrogresspae(){
            progressDoalog = new ProgressDialog(User_profile_actevity.this);
            progressDoalog.setMax(100);
            progressDoalog.setMessage(getString(R.string.load));
            progressDoalog.setTitle(getString(R.string.executed));
            progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }



    private void initializeRecyclerAdapter3() {

        recyclerView.setNestedScrollingEnabled(false);

        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        getmassageinpublic();

    }

    public  void newaddmassage(){
        ids=getIntent().getExtras().getString("categoryId");

        String addmassage=editText.getText().toString().trim();
        if (addmassage.isEmpty()) {
            editText.setError("massage is required");
            editText.requestFocus();
            return;
        }
        UserPref userPref=new UserPref(User_profile_actevity.this);

        String s= userPref.getName();
        String id=userPref.getid();
        if (imgse!=null&&picturePath!=null) {


            Call<model_of_addmassage> call = RetrofitSettings.getInstance().getrequest().addmassagesupdate(addmassage, ids, s, "", "", "", imgse, picturePath);

           showprrogresspae();
           progressDoalog.show();
            call.enqueue(new Callback<model_of_addmassage>() {

                @Override
                public void onResponse(Call<model_of_addmassage> call, Response<model_of_addmassage> response) {
                    if (response.isSuccessful()) {
                        progressDoalog.dismiss();

                      Toasty.success(User_profile_actevity.this, getString(R.string.Themessagewassentsuccessfully), Toast.LENGTH_SHORT, true).show();

                    } else {
                      Toasty.error(User_profile_actevity.this, getString(R.string.error_send), Toast.LENGTH_SHORT, true).show();
                    }
                }

                @Override
                public void onFailure(Call<model_of_addmassage> call, Throwable t) {

                }
            });
        }
        else {
            Call<model_of_addmassage> call = RetrofitSettings.getInstance().getrequest().addmassagesupdate(addmassage, ids, s, "", "", "", "", "");
            call.enqueue(new Callback<model_of_addmassage>() {
                @Override
                public void onResponse(Call<model_of_addmassage> call, Response<model_of_addmassage> response) {
                    if (response.isSuccessful()) {
                       Toasty.success(User_profile_actevity.this, getString(R.string.Themessagewassentsuccessfully), Toast.LENGTH_SHORT, true).show();
                    } else {
                        Toasty.error(User_profile_actevity.this, getString(R.string.error_send), Toast.LENGTH_SHORT, true).show();
                    }
                }

                @Override
                public void onFailure(Call<model_of_addmassage> call, Throwable t) {

                }
            });
        }
    }


    @Override
    public void onClick(View v) {
        if (v==textView){
            newaddmassage();
            editText.setText("");
          //  Toasty.success(User_profile_actevity.this, getString(R.string.Themessagewassentsuccessfully), Toast.LENGTH_SHORT, true).show();
        }
        else if (v==editText){
            scrollView.scrollTo(0,scrollView.getBottom());
        }
        else if (v==imgeicon){
            if (Build.VERSION.SDK_INT >= 23 && (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
            }
            selectImage();

        }
        else if (v==arroww){
            Intent intent=new Intent(this,Home_activety.class);
            startActivity(intent);
        }

    }
    public void  getmassageinpublic(){
        String asd=getIntent().getExtras().getString("categoryId");
       // String s=String.valueOf(1911);

        Call<model_res1_profile_frag> call= RetrofitSettings.getInstance().getrequest().addmassageinpuplic(asd);
        call.enqueue(new Callback<model_res1_profile_frag>() {
            @Override
            public void onResponse(Call<model_res1_profile_frag> call, Response<model_res1_profile_frag> response) {
                if (response.isSuccessful()){
                    if (response.body()==null){}
                    else {
                        if (response.body().getMessages()==null){
                            Toasty.info(User_profile_actevity.this,   getString(R.string.no_massage), Toast.LENGTH_SHORT, true).show();


                        }
                        else {

                            model_res1_profile_frag cos = response.body();
                            array2 = new ArrayList<>(cos.getMessages());
                            adapter_res1 adapter = new adapter_res1(User_profile_actevity.this, array2);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<model_res1_profile_frag> call, Throwable t) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,Home_activety.class);
        startActivity(intent);
    }
    private void selectImage() {
        final CharSequence[] options = { "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);

                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                 picturePath = c.getString(columnIndex);
                c.close();
                bitmap= (BitmapFactory.decodeFile(picturePath));

               imgse=encodeImage(bitmap);






            }
        }
    }
    private String encodeImage(Bitmap bm)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encImage;
    }


    public void getprofilebyid(){
        String asd=getIntent().getExtras().getString("categoryId");

        // String s=String.valueOf(1911);

        Call<models_getprofile_by_id_parent> call= RetrofitSettings.getInstance().getrequest().getprofilebyid(asd);
        call.enqueue(new Callback<models_getprofile_by_id_parent>() {
            @Override
            public void onResponse(Call<models_getprofile_by_id_parent> call, Response<models_getprofile_by_id_parent> response) {
                if (response.body().getInfo().get(0).getDetails()==null){
                  //  Toast.makeText(User_profile_actevity.this, "null", Toast.LENGTH_SHORT).show();

                }
                if (response.isSuccessful()){
                    UserPref userPref = new UserPref(User_profile_actevity.this);

                   String ss= response.body().getInfo().get(0).getImage();
                   // userPref.save(ss);
                  //  Toast.makeText(User_profile_actevity.this, "sucsess", Toast.LENGTH_SHORT).show();
                    String m=response.body().getInfo().get(0).getDetails();

                    if (m==null){}
                    else {
                        txtnobsa.setText(m.toString());
                    }
                }
                else {
                 //   Toast.makeText(User_profile_actevity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<models_getprofile_by_id_parent> call, Throwable t) {

            }
        });

    }
}
