package me.hectorhalpizar.android.moviesfeed;

import android.app.Application;

import me.hectorhalpizar.android.moviesfeed.http.MovieExtraInfoApisModule;
import me.hectorhalpizar.android.moviesfeed.movie.MoviesModule;
import me.hectorhalpizar.android.moviesfeed.root.ApplicationComponent;
import me.hectorhalpizar.android.moviesfeed.root.ApplicationModule;
import me.hectorhalpizar.android.moviesfeed.root.DaggerApplicationComponent;

public class MoviesFeedApplication extends Application {

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
