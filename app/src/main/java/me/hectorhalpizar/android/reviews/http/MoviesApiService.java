package me.hectorhalpizar.android.reviews.http;

import io.reactivex.Observable;
import me.hectorhalpizar.android.reviews.http.apimodel.TopRatedMovies;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiService {
    @GET("top_rated")
    Observable<TopRatedMovies> getTopRatedMovies(@Query("api_key") String apiKey,
                                                 @Query("page") Integer page);



}
