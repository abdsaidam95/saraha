package com.example.saraha.api;


import com.example.saraha.models.CommentModelResc;
import com.example.saraha.models.Example;
import com.example.saraha.models.change_pass_models;
import com.example.saraha.models.changeprofilephoto;
import com.example.saraha.models.hodel_of_search_resc;
import com.example.saraha.models.model_of_addmassage;
import com.example.saraha.models.model_res1_profile_frag;
import com.example.saraha.models.modelchiiid;
import com.example.saraha.models.modelfaceloginparent;
import com.example.saraha.models.modelofimageuploud;
import com.example.saraha.models.models_getprofile_by_id_parent;
import com.example.saraha.models.models_of_any_profile;
import com.example.saraha.models.nobsa_models;
import com.example.saraha.models.replaymassagemodel;
import com.example.saraha.models.rigisterfacebookparent;
import com.example.saraha.models.sign_regestmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

  public    interface Requests {


    @GET("Login")
    Call<List<Example>> getPosts();
    @GET("ProfilesGetNew")
    Call<hodel_of_search_resc> getuserlastrigister();
    @GET("Login")
    Call<Example> getPostssss(@Query("email")String email,@Query("password") String pass );
    @GET("GetPublicMessagesByProfileID")
    Call<model_res1_profile_frag> addmassageinpuplic(@Query("ProfileID")String profileid);
    @GET("GetMessageReplyByMessageID")
    Call<modelchiiid> addmassagereplayinpuplic(@Query("MessageID")String massageid);

    @GET("MessagesAdd")
    Call<model_of_addmassage> addmassage(@Query("Messagetext")String massagetxt, @Query("ReceiverProfileID") String id,@Query("AccessToken")String acsesstoken,@Query("Country")String count,@Query("Flag")String flag,@Query("Ip")String ip,@Query("Extra")String extra);
    @FormUrlEncoded
    @POST("MessagesAdd")
    Call<model_of_addmassage> addmassagesupdate(@Field("Messagetext")String massagetxt,@Field("ReceiverProfileID") String id,@Field("AccessToken")String acsesstoken,@Field("Country")String count,@Field ("Flag")String flag,@Field("Ip")String ip,@Field("ImageBase64")String imge64,@Field("ImageName")String nameofimge);

    @GET("MessageAddReply")
    Call<replaymassagemodel> addmassagereplay(@Query("AccessToken")String acsesstoken, @Query("Message") String massage, @Query("Country")String count, @Query("Flag")String flag, @Query("Ip")String ip, @Query("_Data")String data,@Query("MessageID")String massageid);


    @GET("GetMessages")
    Call<CommentModelResc> getmassage(@Query("AccessToken")String acsesstoken);
    @GET("ChangePassword")
    Call<change_pass_models> chandepass(@Query("AccessToken")String acsesstoken,@Query("OldPassword")String oldpass,@Query("NewPassword")String newpass);

    @GET("Register")
    Call<sign_regestmodel> signup(@Query("Name")String name, @Query("Email")String email, @Query("NickName")String nikename, @Query("Password")String pass, @Query("Image")String imge, @Query("Country")String count, @Query("Flag")String flag, @Query("Ip")String ip, @Query("_Data")String data);


    @GET("posts/{id}")
    Call<Example> getPost(@Path("id") int id);


    //    @Headers("Content-type: application/json; charset=UTF-8")
    @FormUrlEncoded
    @POST("Upload")
    Call<modelofimageuploud> createimage(@Field("Imagefile") String imge);
    @FormUrlEncoded
    @POST("SAR_ProfileSearch")
    Call<models_of_any_profile> search_of_anyprofile(@Field("SearchText") String search);
    @FormUrlEncoded
    @POST("ChangeImage")
    Call<changeprofilephoto> changeimage(@Field("AccessToken")String acsesstoken,@Field("fileName") String imge,@Field("ImageBase64") String imgebase64);

    @FormUrlEncoded
    @PUT("posts/{id}")
    Call<Example> updatePost(@Path("id") int id,
                          @Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") int userId);

    @DELETE("posts/{id}")
    Call<Example> deletePost(@Path("id") int id);
    @GET("UpdateInfo")
    Call<nobsa_models> getnobsa(@Query("AccessToken")String token, @Query("Name") String name,@Query("Details") String detail );

    @GET("SAR_ProfileGetByID")
    Call<models_getprofile_by_id_parent> getprofilebyid(@Query("ID")String id );





// facebook prgister
    @GET("RegisterFacebok")
    Call<rigisterfacebookparent> rigistertofacebook(@Query("Name")String name, @Query("Email") String email, @Query("FacebookID")String faceid,@Query("AccessToken")String token, @Query("Country")String count, @Query("Flag")String flag, @Query("Ip")String ip, @Query("_Data")String data);
    // facebook login

    @GET("SAR_ProfileGetByFacebookID")
    Call<modelfaceloginparent> loginfacebook(@Query("FacebookID")String idface,@Query("Key")String keyprivacy );

}

