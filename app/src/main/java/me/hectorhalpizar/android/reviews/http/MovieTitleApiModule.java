package me.hectorhalpizar.android.reviews.http;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class MovieTitleApiModule {
    public final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public final String API_KEY = "b32455bdad1f82c65b2dd689c3b323f7";

    @Provides
    public OkHttpClient provideClient() {
        return null;
    }

    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client) {
        return null;
    }

    @Provides
    public MoviesApiService provideApiService() {
        return provideRetrofit(BASE_URL, provideClient()).create(MoviesApiService.class);
    }
}
