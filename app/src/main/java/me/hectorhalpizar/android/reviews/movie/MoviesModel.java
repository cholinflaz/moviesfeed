package me.hectorhalpizar.android.reviews.movie;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class MoviesModel implements MoviesMVP.Model {

    private MoviesRepository repository;

    public MoviesModel(MoviesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> getResult() {
        return Observable.zip(repository.getResultData(), repository.getCountryData(), new BiFunction<Result, String, ViewModel>() {
            @Override
            public ViewModel apply(Result result, String country) {
                // TODO: Change result.toString once we get the POJO data
                return new ViewModel(result.toString(), country);
            }
        });
    }
}
