package com.eblink.android.features.catalog.view.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eblink.android.R;
import com.eblink.android.model.entity.Book;
import com.eblink.android.utils.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Naeem(naeemark@gmail.com)
 * On 16/11/2017.
 * For eBlink
 */

public class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageView_poster)
    protected ImageView mLogoImageView;
    @BindView(R.id.img_progress)
    protected ProgressBar imageProgressBar;

    @BindView(R.id.textview_name)
    protected TextView mNameTextView;
    @BindView(R.id.textview_gender)
    protected TextView mGenderTextView;
    @BindView(R.id.textview_email)
    protected TextView mEmailTextView;
    @BindView(R.id.textview_phone)
    protected TextView mPhoneTextView;
    @BindView(R.id.textview_address)
    protected TextView mAddressTextView;


    private Context mContext;
    private Book mBook;

    public RecyclerViewItemHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();

        ButterKnife.bind(this, itemView);
    }

    public void bindData(Book book) {
        mBook = book;
        setValues();
    }

    private void setValues() {
        mNameTextView.setText(mBook.getTitle());

        ImageUtils.loadImage(mContext, mLogoImageView, imageProgressBar,  mBook.getCoverUrl());

    }
}
