package me.hectorhalpizar.android.moviesfeed.movie;

public class ViewModel {
    private String movieName;
    private String movieCountry;

    public ViewModel(String movieName, String movieCountry) {
        this.movieName = movieName;
        this.movieCountry = movieCountry;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCountry() {
        return movieCountry;
    }

    public void setMovieCountry(String movieCountry) {
        this.movieCountry = movieCountry;
    }
}
