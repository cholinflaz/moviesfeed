package me.hectorhalpizar.android.moviesfeed.http;

import io.reactivex.Observable;
import me.hectorhalpizar.android.moviesfeed.http.apimodel.TopRatedMovies;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiService {
    @GET("top_rated")
    Observable<TopRatedMovies> getTopRatedMovies(@Query("page") Integer page);
}
