package com.bai.langshi.util.http;

import com.bai.langshi.pojo.AppInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bai on 2017/10/7.
 */

public interface VService {
    @GET("apiv3/index/index")
    Call<List<AppInfo>> getAppInfo();
}
