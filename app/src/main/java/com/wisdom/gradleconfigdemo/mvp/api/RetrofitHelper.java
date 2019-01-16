package com.wisdom.gradleconfigdemo.mvp.api;

import android.util.Log;

import com.wisdom.gradleconfigdemo.MyApplication;
import com.wisdom.gradleconfigdemo.readassets.utils.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hukun on 2018/1/18.
 */

public class RetrofitHelper {
    private static final String TAG = "RetrofitHelper";
    private static final int DEFAULT_TIME_OUT = 5000;

    private final IMovieServer mIMovieServer;

    public static class Instance {
        private static final RetrofitHelper instance = new RetrofitHelper();
    }

    public static RetrofitHelper getInstance() {
        return Instance.instance;
    }

    private RetrofitHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttpClient())
                .build();
        mIMovieServer = retrofit.create(IMovieServer.class);
    }

    private OkHttpClient mOkHttpClient () {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//设置连接超时的时间
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.addInterceptor(LoggerInterceptor);
        //设置缓存路径
        File httpCacheDir = new File(MyApplication.sContext.getCacheDir(), "okHttpCache");
        //设置缓存大小
        Cache cache = new Cache(httpCacheDir, 10 * 1024 * 1024);
        builder.cache(cache);
        builder.addInterceptor(LoggerInterceptor);
        builder.addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
        builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
        return builder.build();
    }

    private Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            /*-----------------------方案1：有网和无网都是读取缓存------------------------*/
            //            Request request = chain.request();
            //            Response response = chain.proceed(request);
            //            String cacheControl = request.cacheControl().toString();
            //            if (TextUtils.isEmpty(cacheControl)) {
            //                cacheControl = "public, max-age=60";;
            //            }
            //            return response.newBuilder().header("cache-control",cacheControl).removeHeader("Pragma").build();


            /*-----------------------方案2：无网读缓存，有网根据过期时间重新请求------------------------*/
            boolean connectNetWork = NetWorkUtils.isNetConnected(MyApplication.sContext);
            Request request = chain.request();
            if (!connectNetWork) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response response = chain.proceed(request);
            if (connectNetWork) {
                String cacheControl = request.cacheControl().toString();
                response.newBuilder().removeHeader("Pragma").header("cache-control", cacheControl).build();
            } else {
                int maxStale = 60 * 60 * 24 * 7;//缓存时长
                response.newBuilder().removeHeader("Pragma").header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale).build();
            }
            return response;
        }
    };

    private Interceptor LoggerInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long time1 = System.nanoTime();
            Response response = chain.proceed(request);
            long time2 = System.nanoTime();
            MediaType mediaType = response.body().contentType();
            String string = response.body().string();
            Log.i(TAG, "-----LoggingInterceptor----- :\n" + "request url:" + request.url() + "\n" + "time:" + (time2 - time1) / 1e6d + "\n" + "body:" + string + "\n");
            return response.newBuilder().body(ResponseBody.create(mediaType, string)).build();
        }
    };
}
