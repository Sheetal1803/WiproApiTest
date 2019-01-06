// Generated code from Butter Knife. Do not modify!
package com.test.sheetal.mytest.common;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.test.sheetal.mytest.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BaseActivity_ViewBinding implements Unbinder {
  private BaseActivity target;

  @UiThread
  public BaseActivity_ViewBinding(BaseActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BaseActivity_ViewBinding(BaseActivity target, View source) {
    this.target = target;

    target.noConnectionLayout = Utils.findRequiredViewAsType(source, R.id.noConnectionLayout, "field 'noConnectionLayout'", RelativeLayout.class);
    target.errorLayout = Utils.findRequiredViewAsType(source, R.id.errorLayout, "field 'errorLayout'", RelativeLayout.class);
    target.connectionMessageTitle = Utils.findRequiredViewAsType(source, R.id.connectionMessageTitle, "field 'connectionMessageTitle'", TextView.class);
    target.connectionMessageSubTitle = Utils.findRequiredViewAsType(source, R.id.connectionMessageSubTitle, "field 'connectionMessageSubTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BaseActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.noConnectionLayout = null;
    target.errorLayout = null;
    target.connectionMessageTitle = null;
    target.connectionMessageSubTitle = null;
  }
}
