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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.LocalDatabase.preffffff;
import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.api.api_controller;
import com.example.saraha.interfaces.ObjectRequestCallback;
import com.example.saraha.models.changeprofilephoto;
import com.example.saraha.models.modelofimageuploud;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.jaeger.library.StatusBarUtil;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Edit_profile_actievity extends Base_activity implements View.OnClickListener{
   private TextView editText;
   private  String ss;
   private CircleImageView imageView;
   private TextView textView;
    ProgressDialog progressDoalog;
    AdView adView;
    String picturePath;
    private TextView textViewarraw;
   private TextView email;
   public static final int Img_request=777;
   private Bitmap bitmap;
    String imgse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_actievity);
        StatusBarUtil.setTransparent( this);
        MobileAds.initialize(this,"ca-app-pub-8351929453534437~2943593775");

        adView = findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        findview();
        UserPref  userPref= new UserPref(this);
       String s= userPref.getemail();
       String l=userPref.getusername();
       String m=userPref.Getmobile();
        final String r="https://sariiih.com/images/thumb/"+userPref.Getmobile();
        Picasso.get().load(r).into(imageView);

        // Picasso.get().load(userPref.Getmobile()).into(imageView);



        editText=findViewById(R.id.editttttttt);
        editText.setText(userPref.getusername().toString());
        editText.setText(l);
        email.setText(s);
         if (Build.VERSION.SDK_INT >= 23 && (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {
             ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
        }

    }
    public void showprrogresspae(){
        progressDoalog = new ProgressDialog(Edit_profile_actievity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage(getString(R.string.load));
        progressDoalog.setTitle(getString(R.string.executed));
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }
    public void findview(){
        imageView=findViewById(R.id.imdes);
        textView=findViewById(R.id.change_pho);
        email=findViewById(R.id.emailllls);
        textViewarraw=findViewById(R.id.arrowww);

        textView.setOnClickListener(this);
        textViewarraw.setOnClickListener(this);
        //imageView.setOnClickListener(this);
    }
    public void chandimage(String filename,String imgebase64){
        final UserPref  userPref= new UserPref(Edit_profile_actievity.this);
      String token=  userPref.getName();


        Call<changeprofilephoto> call= RetrofitSettings.getInstance().getrequest().changeimage(token,filename,imgebase64);
        showprrogresspae();
        progressDoalog.show();
        call.enqueue(new Callback<changeprofilephoto>() {
            @Override
            public void onResponse(Call<changeprofilephoto> call, Response<changeprofilephoto> response) {
                progressDoalog.dismiss();
                if (response.isSuccessful()){
                    if (response.body().getInfo()==null){}
                    else {

                      //  Toast.makeText(Edit_profile_actievity.this, "" + response.body().getInfo(), Toast.LENGTH_SHORT).show();
                        String m = response.body().getInfo().toString();

                        //  Bundle bundle = new Bundle();
                        // bundle.putString("edttext", m);
                        // My_profile prof=new My_profile();
                        //  prof.setArguments(bundle);
                        preffffff pr = new preffffff(Edit_profile_actievity.this);

                        pr.save(m);
                    }




                  Toasty.success(Edit_profile_actievity.this,getString(R.string.sucsess_change_photo), Toast.LENGTH_SHORT, true).show();

                }
                else {
                    Toasty.error(Edit_profile_actievity.this, getString(R.string.error_chngephoto), Toast.LENGTH_SHORT, true).show();

                }
            }

            @Override
            public void onFailure(Call<changeprofilephoto> call, Throwable t) {
                progressDoalog.dismiss();

            }
        });


    }
    public  void upliad(String j){
       // String imgse=encodeImage(bitmap);
        Call<modelofimageuploud> call= RetrofitSettings.getInstance().getrequest().createimage(j);
        call.enqueue(new Callback<modelofimageuploud>() {
            @Override
            public void onResponse(Call<modelofimageuploud> call, Response<modelofimageuploud> response) {
                if (response.isSuccessful()){
                    Toast.makeText(Edit_profile_actievity.this, "sucsess", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Edit_profile_actievity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<modelofimageuploud> call, Throwable t) {

            }
        });



    }
    public void chandeee(){
        UserPref  userPref= new UserPref(Edit_profile_actievity.this);
        String token=  userPref.getName();
        api_controller.getInstance(this).getobject(token,picturePath,imgse,new ObjectRequestCallback<changeprofilephoto>() {
            @Override
            public void onSuccess(changeprofilephoto object) {
                Toast.makeText(Edit_profile_actievity.this, ""+object, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailed() {
                Toast.makeText(Edit_profile_actievity.this, "faild", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v==textView){
           selectImage();

         //  upliad();
        }
        else if (v==textViewarraw){
            Intent intent=new Intent(this,setting_actevety.class);
            startActivity(intent);

        }

    }
    public void sellectimge(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,Img_request);
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
               // Toast.makeText(this, ""+picturePath, Toast.LENGTH_SHORT).show();
                c.close();
               bitmap= (BitmapFactory.decodeFile(picturePath));
                imageView.setImageBitmap(bitmap);
                 imgse=encodeImage(bitmap);
              chandimage(picturePath,imgse);
             //   chandeee();
              //  Intent intent=new Intent(this,Edit_profile_actievity.class);
                //startActivity(intent);





            }
        }
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
    private String encodeImage(Bitmap bm)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encImage;
    }

    @Override
    public void onBackPressed() {
          Intent intent=new Intent(this,setting_actevety.class);
        startActivity(intent);
    }
}
