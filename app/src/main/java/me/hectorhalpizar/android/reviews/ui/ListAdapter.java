package me.hectorhalpizar.android.reviews.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.hectorhalpizar.android.reviews.R;
import me.hectorhalpizar.android.reviews.movie.ViewModel;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    List<ViewModel> viewModelList;

    public ListAdapter(List<ViewModel> viewModelList) {
        this.viewModelList = viewModelList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ViewModel viewModel = viewModelList.get(position);

        holder.movieName.setText(viewModel.getMovieName());
        holder.movieCountry.setText(viewModel.getMovieCountry());
    }

    @Override
    public int getItemCount() {
        return viewModelList != null ? viewModelList.size() : 0;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_name)
        public TextView movieName;

        @BindView(R.id.movie_country)
        public TextView movieCountry;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
