package me.hectorhalpizar.android.moviesfeed.movie;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import me.hectorhalpizar.android.moviesfeed.http.apimodel.Result;

public class MoviesModel implements MoviesMVP.Model {

    private Repository repository;

    public MoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> getResult() {
        return Observable.zip(repository.getResultData(), repository.getCountryData(), new BiFunction<Result, String, ViewModel>() {
            @Override
            public ViewModel apply(Result result, String country) {
                return new ViewModel(result.getTitle(), country);
            }
        });
    }
}
