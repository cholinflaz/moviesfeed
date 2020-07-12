package me.hectorhalpizar.android.reviews.movie;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.hectorhalpizar.android.reviews.http.MovieExtraInfoApisService;
import me.hectorhalpizar.android.reviews.http.MoviesApiService;

@Module
public class MoviesModule {
    @Provides
    public MoviesMVP.Presenter provideMoviesPresenter(MoviesMVP.Model moviesModel) {
        return new MoviesPresenter(moviesModel);
    }

    @Provides
    public MoviesMVP.Model provideMoviesModel(Repository repository) {
        return new MoviesModel(repository);
    }

    @Singleton
    @Provides
    public Repository providesMovieRepository(
            MoviesApiService moviesApiService,
            MovieExtraInfoApisService movieExtraInfoApisService) {
        return new MoviesRepository(movieExtraInfoApisService, moviesApiService);
    }
}
