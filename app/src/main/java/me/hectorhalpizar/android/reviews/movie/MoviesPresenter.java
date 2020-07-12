package me.hectorhalpizar.android.reviews.movie;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MoviesPresenter implements MoviesMVP.Presenter {

    private MoviesMVP.View view;
    private MoviesMVP.Model model;

    private Disposable disposable = null;

    public MoviesPresenter(MoviesMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        disposable = model.getResult()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DisposableObserver<ViewModel>() {
                                @Override
                                public void onNext(ViewModel viewModel) {
                                    if (view != null) {
                                        view.updateData(viewModel);
                                    }
                                }

                                @Override
                                public void onError(Throwable e) {
                                    e.printStackTrace();
                                    if (view != null) {
                                        view.showSnackBar("Error retrieving data");
                                    }
                                }

                                @Override
                                public void onComplete() {
                                    if (view != null) {
                                        view.showSnackBar("Data retrieve successfully!");
                                    }
                                }
                            });
    }

    @Override
    public void unsubscribeRxJava() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void setView(MoviesMVP.View view) {

    }
}
