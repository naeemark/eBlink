package com.eblink.android.app.view;

/**
 * Created by Naeem(naeemark@gmail.com)
 * On 07/11/2017.
 * For eBlink
 */

public interface BaseView {

    void showLoading();

    void showLoading(String message);

    void hideLoading();

    void showErrorWithMessage(String errorText);

    void showErrorLoading();

    void showToast(String message);

    void showNetworkError();
}
