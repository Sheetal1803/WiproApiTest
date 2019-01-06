package com.test.sheetal.mytest.modules.m.api_call;

import com.test.sheetal.mytest.common.Util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Client {


    public String BASE_URL = Util.baseUrl;
    private Retrofit retrofit = null;


    public Api_Interface getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api_Interface.class);
    }

}

    /*public static final String BASE_URL = Util.baseUrl;
    private ApiInterface api;

    public Api_Client() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.api = retrofit.create(ApiInterface.class);
    }


    @Override
    public Observable<FactResponse> getFacts() {
        return this.api.getFacts();
    }*/

