package me.hectorhalpizar.android.reviews.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.hectorhalpizar.android.reviews.R;
import me.hectorhalpizar.android.reviews.ReviewApplication;
import me.hectorhalpizar.android.reviews.movie.ViewModel;
import me.hectorhalpizar.android.reviews.movie.MoviesMVP;

public class ReviewsActivity extends AppCompatActivity implements MoviesMVP.View {

    @BindView(R.id.root_activity_view)
    LinearLayout rootActivityView;

    @BindView(R.id.recycler_view_movies)
    RecyclerView recyclerViewMovies;

    ListAdapter listAdapter;
    List<ViewModel> listResult;

//    @Inject
//    MoviesMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        ButterKnife.bind(this);

        ((ReviewApplication) getApplication()).getApplicationComponent().inject(this);

        listResult = new ArrayList<>();
        listAdapter = new ListAdapter(listResult);

        recyclerViewMovies.setAdapter(listAdapter);
        recyclerViewMovies.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerViewMovies.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMovies.setHasFixedSize(true);
        recyclerViewMovies.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {

        super.onResume();

//        presenter.setView(this);
//        presenter.loadData();
    }

    @Override
    public void updateData(ViewModel viewModel) {

    }

    @Override
    public void showSnackBar(String message) {

    }
}