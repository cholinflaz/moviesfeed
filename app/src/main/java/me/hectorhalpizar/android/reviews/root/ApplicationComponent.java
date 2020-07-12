package me.hectorhalpizar.android.reviews.root;

import javax.inject.Singleton;

import dagger.Component;
import me.hectorhalpizar.android.reviews.http.MovieExtraInfoApisModule;
import me.hectorhalpizar.android.reviews.http.MovieTitleApiModule;
import me.hectorhalpizar.android.reviews.movie.MoviesModule;
import me.hectorhalpizar.android.reviews.ui.ReviewsActivity;

@Singleton
@Component(modules = {
                        ApplicationModule.class,
                        MoviesModule.class,
                        MovieExtraInfoApisModule.class,
                        MovieTitleApiModule.class
                      })
public interface ApplicationComponent {

    void inject(ReviewsActivity target);
}
