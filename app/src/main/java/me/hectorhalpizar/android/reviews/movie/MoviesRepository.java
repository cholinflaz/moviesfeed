package me.hectorhalpizar.android.reviews.movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import me.hectorhalpizar.android.reviews.http.MovieExtraInfoApisService;
import me.hectorhalpizar.android.reviews.http.MoviesApiService;
import me.hectorhalpizar.android.reviews.http.apimodel.OmdbApi;
import me.hectorhalpizar.android.reviews.http.apimodel.Result;
import me.hectorhalpizar.android.reviews.http.apimodel.TopRatedMovies;

public class MoviesRepository implements Repository {

    private MovieExtraInfoApisService movieExtraInfoApisService;
    private MoviesApiService movieTitleApiModule;

    private List<String> countries;
    private List<Result> results;
    private long lastTimestamp;

    private static final long CACHE_LIFETIME = 20 * 1000; // Cache will last 20 seconds

    public MoviesRepository(MovieExtraInfoApisService movieExtraInfoApisService,
                            MoviesApiService movieTitleApiModule) {
        this.movieExtraInfoApisService = movieExtraInfoApisService;
        this.movieTitleApiModule = movieTitleApiModule;

        this.lastTimestamp = System.currentTimeMillis();

        this.countries = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public boolean isUpdated() {
        return System.currentTimeMillis() - lastTimestamp < CACHE_LIFETIME;
    }

    @Override
    public Observable<Result> getResultFromNetwork() {
        Observable<TopRatedMovies> topRatedMoviesObservable = movieTitleApiModule.getTopRatedMovies(1)
                .concatWith(movieTitleApiModule.getTopRatedMovies(2))
                .concatWith(movieTitleApiModule.getTopRatedMovies(3));
        return topRatedMoviesObservable.concatMap(new Function<TopRatedMovies, ObservableSource<Result>>() {

            @Override
            public ObservableSource<Result> apply(TopRatedMovies topRatedMovies) {
                return Observable.fromIterable(topRatedMovies.getResults());
            }
        }).doOnNext(new Consumer<Result>() {
            @Override
            public void accept(Result result) {
                results.add(result);
            }
        });
    }

    @Override
    public Observable<Result> getResultFromCache() {
        if (isUpdated()) {
            return Observable.fromIterable(results);
        } else {
            lastTimestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Result> getResultData() {
        return getResultFromCache().switchIfEmpty(getResultFromNetwork());
    }

    @Override
    public Observable<String> getCountryFromNetwork() {
        return getResultFromNetwork().concatMap(new Function<Result, ObservableSource<OmdbApi>>() {
            @Override
            public ObservableSource<OmdbApi> apply(Result result) {
                return movieExtraInfoApisService.getMovieExtraInfo(result.getTitle());
            }
        }).concatMap(new Function<OmdbApi, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(OmdbApi omdbApi) {
                return Observable.just(omdbApi.getCountry());
            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String country) throws Exception {
                countries.add(country);
            }
        });
    }

    @Override
    public Observable<String> getCountryFromCache() {
        if (isUpdated()) {
            return Observable.fromIterable(countries);
        } else {
            lastTimestamp = System.currentTimeMillis();
            countries.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<String> getCountryData() {
        return getCountryFromCache().switchIfEmpty(getCountryFromNetwork());
    }
}
