package com.orphanage.apps;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orphanage.apps.model.OrphanageRegistrationModel;
import com.orphanage.apps.utils.AppConstents;
import com.orphanage.apps.utils.DialogUtils;
import com.orphanage.apps.utils.OkHttpUtils;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SplashActivity extends BaseActivity {

    @Override
    int getRootLayout() {
        return R.layout.activity_splash;
    }

    @Override
    void initGUI() {

    }

    @Override
    void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },500);

//        postDataToServer();
    }


    private boolean isPosted = false;
    private boolean postDataToServer() {
        try {
            OkHttpClient client = OkHttpUtils.getOkHttpClient();
            OrphanageRegistrationModel.Data data = new OrphanageRegistrationModel.Data();
            data.fullName = "vivekananda";
            data.registerNumber = "123456";
            data.managerName = "surendra";
            data.numberKids = "20";
            data.address = "Banjara Hills";
            data.phoneNumber1 = "8008127830";
            data.phoneNumber2 = "27830";
            data.emailID = "ashokareddy@techouts.com";
            data.socialMedia = "http://www.google.com";
            data.device = "Android";
            data.type = "orphanage";
            OrphanageRegistrationModel.RegisterData registerData = new OrphanageRegistrationModel.RegisterData();
            registerData.setData(data);
            registerData.setAPIkey("4d5d9e4f0ac3c62059f8eaa45a516328");
            OrphanageRegistrationModel orphanageRegistrationModel = new OrphanageRegistrationModel();
            orphanageRegistrationModel.setRegisterData(registerData);
            String body = getJsonString(orphanageRegistrationModel);
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body);
            Request.Builder builder = new Request.Builder();
            builder.url("http://giveorphanages.org/registerweb")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .post(requestBody);
            Request request = builder.build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    final String body = response.body().string().toString();
                   runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if (response.message().equalsIgnoreCase("OK")) {
                                } else {
                                    isPosted = false;
                                    DialogUtils.showDialog(SplashActivity.this, getResources().getString(R.string.error_message),
                                           "", false);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean isValid = isPosted;
        return isValid;
    }

    public String getJsonString(Object object) {
        Gson gson = null;
        try {
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gson.toJson(object);
    }

}
