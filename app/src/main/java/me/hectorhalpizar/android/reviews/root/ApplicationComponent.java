package me.hectorhalpizar.android.reviews.root;

import javax.inject.Singleton;

import dagger.Component;
import me.hectorhalpizar.android.reviews.http.MovieExtraInfoApisModule;
import me.hectorhalpizar.android.reviews.http.MovieTitleApiModule;
import me.hectorhalpizar.android.reviews.ui.ReviewsActivity;

@Singleton
@Component(modules = {
                        ApplicationModule.class,
                        MovieTitleApiModule.class,
                        MovieExtraInfoApisModule.class
                      })
public interface ApplicationComponent {

    void inject(ReviewsActivity target);
}
