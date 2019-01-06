// Generated code from Butter Knife. Do not modify!
package com.test.sheetal.mytest.modules.m.home;

import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.Utils;
import com.test.sheetal.mytest.R;
import com.test.sheetal.mytest.common.BaseActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding extends BaseActivity_ViewBinding {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    super(target, source);

    this.target = target;

    target.mRecylerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecylerView'", RecyclerView.class);
    target.mSwipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swipeToRefresh, "field 'mSwipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecylerView = null;
    target.mSwipeRefreshLayout = null;

    super.unbind();
  }
}
