package com.example.saraha.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.sign_regestmodel;
import com.jaeger.library.StatusBarUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class create_an_account extends Base_activity implements View.OnClickListener{
    public static final int IMAGE_GALLERY_REQUEST = 20;
    public static final int CAMERA_REQUEST_CODE = 228;
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 4192;
    private Activity activity;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private ImageView imageView;
    private Button button;
    private String l;
    String m;
    private EditText editText6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account);
        findview();
        StatusBarUtil.setTransparent( this);
       // if (Build.VERSION.SDK_INT >= 23 && (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {
       //     ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
       // }



      // getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


    }
    private void findview(){
        editText1=findViewById(R.id.user_namessssss);
        editText2=findViewById(R.id.Email_register);
        editText3=findViewById(R.id.nikename);
        editText4=findViewById(R.id.data_bairth);
        imageView=findViewById(R.id.bbbbbbbbbb);
        button=findViewById(R.id.sign_up_data);
        button.setOnClickListener(this);
        editText5=findViewById(R.id.data_pass);
        editText6=findViewById(R.id.data_pho);
        editText6.setOnClickListener(this);
    }
    private void userSignUp() {
        String name=editText1.getText().toString().trim();
        String emaIL=editText2.getText().toString().trim();
        String nickname=editText3.getText().toString().trim();
        String contry=editText4.getText().toString().trim();
        String pass=editText5.getText().toString().trim();
        String confirm=editText6.getText().toString();


        if (emaIL.isEmpty()) {
            editText2.setError("Email is required");
            editText2.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emaIL).matches()) {
            editText2.setError("Enter a valid email");
            editText2.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            editText5.setError("Password required");
            editText5.requestFocus();
            return;
        }
        if (contry.isEmpty()) {
            editText4.setError("country required");
            editText4.requestFocus();
            return;
        }

        if (nickname.isEmpty()) {
            editText3.setError("nickname required");
            editText3.requestFocus();
            return;
        }
        if (name.isEmpty()) {
            editText1.setError("name required");
            editText1.requestFocus();
            return;
        }
        if (confirm.isEmpty()) {
            editText6.setError("confirm required");
            editText6.requestFocus();
            return;
        }
        if (!confirm.equals(pass)) {
            editText6.setError("confirm required");
            editText6.requestFocus();
            return;
        }










            Call<sign_regestmodel> call = RetrofitSettings.getInstance().getrequest().signup(name, emaIL, nickname, pass, "", contry, "", "", "");
            call.enqueue(new Callback<sign_regestmodel>() {
                @Override
                public void onResponse(Call<sign_regestmodel> call, Response<sign_regestmodel> response) {

                    if (response.isSuccessful()) {
                        if (response.body().getInfo()==null){
                            Toasty.error(create_an_account.this, getString(R.string.error_of_data), Toast.LENGTH_SHORT, true).show();
                        }
                        else {
                            Intent intent = new Intent(create_an_account.this, Login_activity.class);
                            startActivity(intent);
                            Toasty.success(create_an_account.this, getString(R.string.createaccont), Toast.LENGTH_SHORT, true).show();
                        }
                    } else {
                        Toasty.error(create_an_account.this, getString(R.string.error_of_data), Toast.LENGTH_SHORT, true).show();
                    }


                }

                @Override
                public void onFailure(Call<sign_regestmodel> call, Throwable t) {
                    Toast.makeText(create_an_account.this, "fail", Toast.LENGTH_SHORT).show();

                }
            });
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
    public void onClick(View v) {
        if (v==editText6){

        }
        else if (v==button){
            userSignUp();

        }

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
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));

                 l = encodeImage(thumbnail);



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

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }
}
