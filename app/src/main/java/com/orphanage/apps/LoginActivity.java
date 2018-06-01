package com.orphanage.apps;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

public class LoginActivity extends BaseActivity {

    private LinearLayout llLogin;

    @Override
    int getRootLayout() {
        return R.layout.activity_login;
    }

    @Override
    void initGUI() {
        llLogin = findViewById(R.id.llLogin);
    }

    @Override
    void initData() {
        llLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
