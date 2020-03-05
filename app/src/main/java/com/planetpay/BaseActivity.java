package com.planetpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.planetpay.datastore.DataManager;
import com.planetpay.utils.Common;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataManager = ((Common)this.getApplicationContext()).getDataManager();

    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void showSnackBar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
                /*.setAction("Action", null)*/
                .show();
    }

    protected boolean checkNetworkState() {
        if (!Common.checkNetwork(this)) {
            showToast("You do not have a network connection");
            return false;
        }
        return true;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

}
