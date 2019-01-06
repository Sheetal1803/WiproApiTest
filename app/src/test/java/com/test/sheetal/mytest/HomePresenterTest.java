package com.test.sheetal.mytest;

import com.test.sheetal.mytest.modules.m.api_call.Api_Interface;
import com.test.sheetal.mytest.modules.m.home.MainContract;
import com.test.sheetal.mytest.modules.m.home.MainPresenter;
import com.test.sheetal.mytest.modules.m.pojo.Fact;
import com.test.sheetal.mytest.modules.m.pojo.FactResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import retrofit2.Call;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class HomePresenterTest {

    @Mock
    Api_Interface apiInterface;
    @Mock
    MainContract.View view;

    @Before
    public void create() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadValidDataIntoAdapter() {

        ArrayList<Fact> factArrayList = new ArrayList<>();
        factArrayList.add(new Fact("Transportation","Better Transportation",null));

        FactResponse factResponse = new FactResponse("Canada", factArrayList);

        when(apiInterface.getFacts())
                .thenReturn();

        MainPresenter presenter = new MainPresenter(this.view);
        presenter.getFactsData();

        InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view, times(1)).factDataReady(factResponse);

    }

}
