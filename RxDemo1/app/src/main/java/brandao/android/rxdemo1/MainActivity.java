package brandao.android.rxdemo1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "myApp";
    private String greeting = "Hello From RxJava";
    private Observable<String> myObservable;
    private DisposableObserver<String> myObserver;
    private DisposableObserver<String> myObserver2;

    private TextView textView;
    //  private Disposable disposable;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewGreeting);

        myObservable = Observable.just(greeting);


//        myObservable.subscribeOn(Schedulers.io());


//        myObservable.observeOn(AndroidSchedulers.mainThread());

//        myObserver = new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//                Log.i(TAG, "onSubscribe invoked");
//                disposable = d;
//
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                Log.i(TAG, "onNext invoked");
//
//                textView.setText(s);
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.i(TAG, "onError invoked");
//
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i(TAG, "onComplete invoked");
//
//            }
//        };

        myObserver = new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.i(TAG, "onNext invoked");

                textView.setText(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "onError invoked");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete invoked");
            }
        };

//        compositeDisposable.add(myObserver);
//        myObservable.subscribe(myObserver);

        compositeDisposable.add(
        myObservable.
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(myObserver)
        );

        myObserver2 = new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.i(TAG, "onNext invoked");

                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "onError invoked");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete invoked");
            }
        };
//        compositeDisposable.add(myObserver2);
//        myObservable.subscribe(myObserver2);

        compositeDisposable.add(
                myObservable.subscribeWith(myObserver2)
        );


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //   disposable.dispose();
//        myObserver.dispose();
//        myObserver2.dispose();
        compositeDisposable.clear();

    }
}