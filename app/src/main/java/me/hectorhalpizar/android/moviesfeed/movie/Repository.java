package me.hectorhalpizar.android.moviesfeed.movie;

import io.reactivex.Observable;
import me.hectorhalpizar.android.moviesfeed.http.apimodel.Result;

public interface Repository {
    Observable<Result> getResultFromNetwork();
    Observable<Result> getResultFromCache();
    Observable<Result> getResultData();

    Observable<String> getCountryFromNetwork();
    Observable<String> getCountryFromCache();
    Observable<String> getCountryData();
}
