package me.hectorhalpizar.android.reviews.root;

import javax.inject.Singleton;

import dagger.Component;
import me.hectorhalpizar.android.reviews.ui.ReviewsActivity;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(ReviewsActivity target);
}
