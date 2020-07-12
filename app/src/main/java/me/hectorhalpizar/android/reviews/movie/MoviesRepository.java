package me.hectorhalpizar.android.reviews.movie;

import io.reactivex.Observable;

public interface MoviesRepository {
    Observable<Result> getResultData();
    Observable<String> getCountryData();
}
