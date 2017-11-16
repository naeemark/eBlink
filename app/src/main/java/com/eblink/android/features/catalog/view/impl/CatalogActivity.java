package com.eblink.android.features.catalog.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.eblink.android.R;
import com.eblink.android.app.injection.AppComponent;
import com.eblink.android.app.presenter.loader.PresenterFactory;
import com.eblink.android.app.view.impl.BaseActivity;
import com.eblink.android.features.catalog.injection.CatalogViewModule;
import com.eblink.android.features.catalog.injection.DaggerCatalogViewComponent;
import com.eblink.android.features.catalog.presenter.CatalogPresenter;
import com.eblink.android.features.catalog.view.CatalogView;
import com.eblink.android.features.catalog.view.adapter.RecyclerViewAdapter;
import com.eblink.android.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public final class CatalogActivity extends BaseActivity<CatalogPresenter, CatalogView> implements CatalogView {
    @Inject
    PresenterFactory<CatalogPresenter> mPresenterFactory;

    @BindView(R.id.recyclerView)
    protected RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;

    private List<Book> mList = new ArrayList<>();

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerCatalogViewComponent.builder()
                .appComponent(parentComponent)
                .catalogViewModule(new CatalogViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<CatalogPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_catalog;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        initList();
    }

    private void initList() {

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void loadList(List<Book> list) {
        mList.addAll(list);
        showList();
    }

    /**
     * resets list of Adapter
     */
    private void showList() {
        mAdapter.clearList();
        mAdapter.addList(mList);
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setVisibility(View.VISIBLE);
    }
}
