package com.orphanage.apps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootLayout());
        initGUI();
        initData();
    }

    abstract int getRootLayout();
    abstract void initGUI();
    abstract void initData();

    public void showToast(String message) {
        Toast.makeText(BaseActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
