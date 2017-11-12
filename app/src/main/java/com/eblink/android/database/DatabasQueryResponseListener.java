package com.eblink.android.database;

/**
 * An Interface to provide callback functions for Database queries
 * Created by Naeem(naeemark@gmail.com)
 * On 12/11/2017.
 * For eBlink
 */

public interface DatabasQueryResponseListener {
    void onCheckDataExistance(boolean flag);
}
