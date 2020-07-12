package me.hectorhalpizar.android.reviews;

import android.app.Application;

import me.hectorhalpizar.android.reviews.http.MovieExtraInfoApisModule;
import me.hectorhalpizar.android.reviews.movie.MoviesModule;
import me.hectorhalpizar.android.reviews.root.ApplicationComponent;
import me.hectorhalpizar.android.reviews.root.ApplicationModule;
import me.hectorhalpizar.android.reviews.root.DaggerApplicationComponent;

public class ReviewApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                                .builder()
                                .applicationModule(new ApplicationModule(this))
                                .moviesModule(new MoviesModule())
                                .movieExtraInfoApisModule(new MovieExtraInfoApisModule())
                                .moviesModule(new MoviesModule())
                                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
