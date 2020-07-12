package me.hectorhalpizar.android.reviews.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.hectorhalpizar.android.reviews.R;
import me.hectorhalpizar.android.reviews.movie.ViewModel;
import me.hectorhalpizar.android.reviews.movie.MoviesMVP;

public class ReviewsActivity extends AppCompatActivity implements MoviesMVP.View {

    @BindView(R.id.root_activity_view)
    LinearLayout rootActivityView;

    @BindView(R.id.recycler_view_movies)
    RecyclerView recyclerViewMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        ButterKnife.bind(this);
    }

    @Override
    public void updateData(ViewModel viewModel) {

    }

    @Override
    public void showSnackBar(String message) {

    }
}