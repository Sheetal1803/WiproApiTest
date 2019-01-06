package com.test.sheetal.mytest.modules.m.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.test.sheetal.mytest.R;
import com.test.sheetal.mytest.modules.m.pojo.Fact;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FactListAdapter extends RecyclerView.Adapter<FactListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Fact> factArrayList;
    private LayoutInflater mInflater;

    public FactListAdapter(Context mContext, ArrayList<Fact> facts) {
        this.mContext = mContext;
        this.factArrayList = facts;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_fact_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Fact model = factArrayList.get(holder.getAdapterPosition());
        holder.textTitle.setText(model.getTitle());

        if (TextUtils.isEmpty(model.getDescription())) {
            holder.textDescription.setVisibility(View.GONE);
        } else {
            holder.textDescription.setText(model.getDescription());
            holder.textDescription.setVisibility(View.VISIBLE);
        }

        Glide.with(mContext).
                load(model.getImageHref())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        holder.imageView.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        holder.imageView.setVisibility(View.VISIBLE);
                        return false;
                    }
                })
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return factArrayList.size();
    }

    public void setItems(ArrayList<Fact> facts) {
        this.factArrayList = facts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.texTitle)
        TextView textTitle;
        @BindView(R.id.textDescription)
        TextView textDescription;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
