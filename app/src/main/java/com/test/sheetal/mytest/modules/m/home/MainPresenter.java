package com.test.sheetal.mytest.modules.m.home;

import com.test.sheetal.mytest.modules.m.api_call.Api_Client;
import com.test.sheetal.mytest.modules.m.pojo.FactResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private Api_Client api_client;

    MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        if (this.api_client == null) {
            this.api_client = new Api_Client();
        }
    }


    public void getFactsData() {
        // view.showProgressDialog();
        api_client
                .getClient()
                .getFacts()
                .enqueue(new Callback<FactResponse>() {
                    @Override
                    public void onResponse(Call<FactResponse> call, Response<FactResponse> response) {
                        FactResponse factResponse = response.body();
                        view.factDataReady(factResponse);
                    }

                    @Override
                    public void onFailure(Call<FactResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {

    }
}


