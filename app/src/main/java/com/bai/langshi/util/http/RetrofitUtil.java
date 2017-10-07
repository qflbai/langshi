package com.bai.langshi.util.http;

import android.util.Log;

import com.bai.langshi.pojo.AppInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by bai on 2017/10/7.
 */

public class RetrofitUtil {
    public static void getInfo(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.vmovier.com/")
                .build();

        VService vService = retrofit.create(VService.class);
        Call<List<AppInfo>> call = vService.getAppInfo();
        call.enqueue(new Callback<List<AppInfo>>() {
            @Override
            public void onResponse(Call<List<AppInfo>> call, Response<List<AppInfo>> response) {
                Log.i("Tag","iiii"+response.body());
            }

            @Override
            public void onFailure(Call<List<AppInfo>> call, Throwable t) {

            }
        });

    }
}
