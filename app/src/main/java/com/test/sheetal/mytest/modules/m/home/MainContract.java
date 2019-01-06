package com.test.sheetal.mytest.modules.m.home;

import com.test.sheetal.mytest.common.BasePresenter;
import com.test.sheetal.mytest.common.BaseView;
import com.test.sheetal.mytest.modules.m.pojo.FactResponse;

public class MainContract {

    public interface View extends BaseView {

        void factDataReady(FactResponse factResponse);

    }

    public interface Presenter extends BasePresenter {
       void getFactsData();
    }
}
