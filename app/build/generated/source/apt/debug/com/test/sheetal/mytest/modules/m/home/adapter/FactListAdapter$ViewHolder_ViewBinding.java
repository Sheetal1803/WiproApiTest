// Generated code from Butter Knife. Do not modify!
package com.test.sheetal.mytest.modules.m.home.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.test.sheetal.mytest.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FactListAdapter$ViewHolder_ViewBinding implements Unbinder {
  private FactListAdapter.ViewHolder target;

  @UiThread
  public FactListAdapter$ViewHolder_ViewBinding(FactListAdapter.ViewHolder target, View source) {
    this.target = target;

    target.imageView = Utils.findRequiredViewAsType(source, R.id.imageView, "field 'imageView'", ImageView.class);
    target.textTitle = Utils.findRequiredViewAsType(source, R.id.texTitle, "field 'textTitle'", TextView.class);
    target.textDescription = Utils.findRequiredViewAsType(source, R.id.textDescription, "field 'textDescription'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FactListAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageView = null;
    target.textTitle = null;
    target.textDescription = null;
  }
}
