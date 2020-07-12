package me.hectorhalpizar.android.reviews.movie;

import io.reactivex.Observable;

public interface MoviesMVP {
    interface Model {
        Observable<ViewModel> getResult();
    }

    interface View {
        void updateData(ViewModel viewModel);
        void showSnackBar(String message);
    }

    interface Presenter {
        void loadData();
        void unsubscribeRxJava();
        void setView(MoviesMVP.View view);
    }
}
