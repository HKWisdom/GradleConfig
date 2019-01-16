package com.wisdom.gradleconfigdemo.mvp.api;

import com.wisdom.gradleconfigdemo.readassets.entity.MovieEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hukun on 2018/1/18.
 */

public interface IMovieServer {
    String BASE_URL = "https://api.douban.com/v2/movie/";

    @GET("top250")
    Observable<List<MovieEntity>> getMovie(@Query("start") int start, @Query("count") int count);
}
