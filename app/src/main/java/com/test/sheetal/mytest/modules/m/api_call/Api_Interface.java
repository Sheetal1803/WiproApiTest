package com.test.sheetal.mytest.modules.m.api_call;

import com.test.sheetal.mytest.common.Util;
import com.test.sheetal.mytest.modules.m.pojo.FactResponse;

import retrofit2.Call;
import retrofit2.http.GET;



public interface Api_Interface {

        @GET(Util.methodName)
        Call<FactResponse> getFacts();

}
