package me.hectorhalpizar.android.moviesfeed.http;

import io.reactivex.Observable;
import me.hectorhalpizar.android.moviesfeed.http.apimodel.OmdbApi;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieExtraInfoApisService {
    @GET("/")
    Observable<OmdbApi> getMovieExtraInfo(@Query("t") String t);
}
