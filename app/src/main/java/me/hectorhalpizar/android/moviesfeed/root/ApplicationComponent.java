package me.hectorhalpizar.android.moviesfeed.root;

import javax.inject.Singleton;

import dagger.Component;
import me.hectorhalpizar.android.moviesfeed.http.MovieExtraInfoApisModule;
import me.hectorhalpizar.android.moviesfeed.http.MovieTitleApiModule;
import me.hectorhalpizar.android.moviesfeed.movie.MoviesModule;
import me.hectorhalpizar.android.moviesfeed.ui.MoviesFeedActivity;

@Singleton
@Component(modules = {
                        ApplicationModule.class,
                        MoviesModule.class,
                        MovieExtraInfoApisModule.class,
                        MovieTitleApiModule.class
                      })
public interface ApplicationComponent {

    void inject(MoviesFeedActivity target);
}
