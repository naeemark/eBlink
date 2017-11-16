package com.eblink.android.features.catalog.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eblink.android.R;
import com.eblink.android.features.catalog.view.holder.RecyclerViewItemHolder;
import com.eblink.android.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naeem(naeemark@gmail.com)
 * On 16/11/2017.
 * For eBlink
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewItemHolder> {

    private List<Book> mList = new ArrayList<>();

    @Override
    public RecyclerViewItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewItemHolder holder, int position) {
        holder.bindData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void clearList() {
        mList.clear();
        notifyDataSetChanged();
    }

    public void addList(List<Book> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }
}
