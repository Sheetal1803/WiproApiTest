package com.test.sheetal.mytest.modules.m.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.test.sheetal.mytest.R;
import com.test.sheetal.mytest.common.BaseActivity;
import com.test.sheetal.mytest.modules.m.home.adapter.FactListAdapter;
import com.test.sheetal.mytest.modules.m.pojo.Fact;
import com.test.sheetal.mytest.modules.m.pojo.FactResponse;

import java.util.ArrayList;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements MainContract.View,SwipeRefreshLayout.OnRefreshListener,BaseActivity.NetworkListener {

    MainContract.Presenter presenter;
    @BindView(R.id.recyclerView)
    RecyclerView mRecylerView;

    @BindView(R.id.swipeToRefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private FactListAdapter adapter;
    private LinearLayoutManager manager;
    private ArrayList<Fact> facts;
    private String TAG  = getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initUI();

        if (presenter == null)
            presenter = new MainPresenter(this);

        setRefreshing(true);
        presenter.getFactsData();

    }


    private void initUI() {
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecylerView.setLayoutManager(manager);

        facts = new ArrayList<>();
        adapter = new FactListAdapter(this, facts);
        mRecylerView.setAdapter(adapter);


        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

    }
    private void setRefreshing(boolean flag) {
        mSwipeRefreshLayout.setRefreshing(flag);
    }

    private void setAdapterToRecyclerView(FactResponse factResponse) {
        mRecylerView.setVisibility(View.VISIBLE);
        swipeRefreshLayout(true);
        if (!TextUtils.isEmpty(factResponse.getName())) {
            setAppTitle(factResponse.getName());
        }
        facts = getFilterList(factResponse.getFactList());
        Log.e(TAG, "setAdapterToRecyclerView: "+facts.size() );
        notifyAdapter();
    }

    private void notifyAdapter() {
        adapter.setItems(facts);
        adapter.notifyDataSetChanged();
    }

    private void swipeRefreshLayout(boolean flag) {
        mSwipeRefreshLayout.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    private ArrayList<Fact> getFilterList(ArrayList<Fact> factArrayList) {
        for (int i = 0; i < factArrayList.size(); ) {
            try {
                if (factArrayList.get(i).checkNull()) {
                    factArrayList.remove(i);
                } else {
                    i++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return factArrayList;
    }

    private void setAppTitle(String title) {
        this.setTitle(title);
    }

    @Override
    public void onRefresh() {
        if (hasConnectivity()) {
            swipeRefreshLayout(true);
            sendApiRequest(true);
        } else {
            swipeRefreshLayout(false);
        }
    }

    private void sendApiRequest(boolean b) {

        presenter.getFactsData();
    }

    @Override
    public void factDataReady(FactResponse factResponse) {
        setRefreshing(false);
        setAdapterToRecyclerView(factResponse);
    }


    @Override
    public void onNetworkRestored() {
        noConnectionLayout.setVisibility(View.GONE);
        sendApiRequest(true);
    }
}
