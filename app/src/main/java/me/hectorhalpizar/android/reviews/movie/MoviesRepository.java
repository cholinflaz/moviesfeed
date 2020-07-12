package me.hectorhalpizar.android.reviews.movie;

import io.reactivex.Observable;
import me.hectorhalpizar.android.reviews.http.MovieExtraInfoApisService;
import me.hectorhalpizar.android.reviews.http.MoviesApiService;
import me.hectorhalpizar.android.reviews.http.apimodel.Result;

public class MoviesRepository implements Repository {

    private MovieExtraInfoApisService movieExtraInfoApisService;
    private MoviesApiService movieTitleApiModule;

    public MoviesRepository(MovieExtraInfoApisService movieExtraInfoApisService,
                            MoviesApiService movieTitleApiModule) {
        this.movieExtraInfoApisService = movieExtraInfoApisService;
        this.movieTitleApiModule = movieTitleApiModule;
    }

    @Override
    public Observable<Result> getResultData() {
        return null;
    }

    @Override
    public Observable<String> getCountryData() {
        return null;
    }
}
