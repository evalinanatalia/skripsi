package com.example.trusts.network;

import com.example.trusts.model.Mobil;
import com.example.trusts.model.MobilKeluar;
import com.example.trusts.model.RequestLogin;
import com.example.trusts.model.ResponseData;
import com.example.trusts.model.ResponseMobil;
import com.example.trusts.model.ResponseMobilKeluar;
import com.example.trusts.model.ResponseProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NetworkService {

    @POST("login")
    Call<ResponseProfile> postLogin(
            @Body RequestLogin request);

    @GET("mobilkeluar")
    Call<ResponseMobilKeluar> getMobil();

    @POST("mobilkeluar")
    Call<ResponseData> postMobil(
            @Body MobilKeluar credentials);

    @GET("mobilkeluar/{id}")
    Call<Mobil> getMobilById(
            @Path("id") int id);

    @GET("kendaraan")
    Call<ResponseMobil> getMobilPlat();


//    @GET("polls.apiblueprint.org/v1/user/balance")
//    Call<Balance> getBalance(
//            @Header("Authorization") String credentials,
//            @Header("Content-Type") String type);
//
//    @POST("polls.apiblueprint.org/v1/user/balance")
//    Call<Balance> postBalance(
//            @Header("Authorization") String credentials,
//            @Header("Pass-key") String passKey,
//            @Header("Content-Type") String type);
//
//    @POST("/v1/login")
//    Call<Login> postLogin(
//
//    );
//
//    @GET("polls.apiblueprint.org/v1/makeorder")
//    Call<GasType> getOrder(
//            @Header("Client-ID") String clientId,
//            @Header("Pass-key") String passKey,
//            @Header("Content-Type") String type);
//
//    @GET("polls.apiblueprint.org/v1/makeorder/error")
//    Call<GasType> getOrderError(
//            @Header("Client-ID") String clientId,
//            @Header("Pass-key") String passKey,
//            @Header("Content-Type") String type);
//
//    @GET("/v1/history")
//    Call<Track> getHistory(
//            //@Header("Authorization") String credentials,
//            //@Header("Content-Type") String  type);
//    );
//
//    @GET("/v1/history")
//    Call<Track> getHistoryByDate(
//            @Query("start") String start,
//            @Query("end") String end
//    );

//  @GET("polls.apiblueprint.org/v1/history?start="09/11/2017"&end="20/11/2017")

}

