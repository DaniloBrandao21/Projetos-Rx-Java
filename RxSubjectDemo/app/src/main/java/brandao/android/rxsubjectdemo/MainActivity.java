package brandao.android.rxsubjectdemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "myApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ayncSubjectDeemo1();
//        ayncSubjectDeemo2();

//        behaviorSubjectDemo1();
//        behaviorSubjectDemo2();

//        publishSubjectDemo1();
//        publishSubjectDemo2();

//        replaySubjectDemo1();
          replaySubjectDemo2();
    }

    void ayncSubjectDeemo1() {
        Observable<String> observable = Observable.just("Java", "Kotlin", "XML", "Json");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        observable.subscribe(asyncSubject);

        asyncSubject.subscribe(getFirstObserver());
        asyncSubject.subscribe(getSecondObserver());
        asyncSubject.subscribe(getThirdObserver());
    }


    void ayncSubjectDeemo2() {
        AsyncSubject<String> asyncSubject = AsyncSubject.create();

        asyncSubject.subscribe(getFirstObserver());

        asyncSubject.onNext("Java");
        asyncSubject.onNext("Kotlin");
        asyncSubject.onNext("XML");

        asyncSubject.subscribe(getSecondObserver());
        asyncSubject.onNext("Json");
        asyncSubject.onComplete();

        asyncSubject.subscribe(getThirdObserver());
    }

    void behaviorSubjectDemo1() {
        Observable<String> observable = Observable.just("Java", "Kotlin", "XML", "Json");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();

        observable.subscribe(behaviorSubject);

        behaviorSubject.subscribe(getFirstObserver());
        behaviorSubject.subscribe(getSecondObserver());
        behaviorSubject.subscribe(getThirdObserver());
    }

    void behaviorSubjectDemo2() {


        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();

        behaviorSubject.subscribe(getFirstObserver());

        behaviorSubject.onNext("Java");
        behaviorSubject.onNext("Kotlin");
        behaviorSubject.onNext("XML");

        behaviorSubject.subscribe(getSecondObserver());
        behaviorSubject.onNext("Json");
        behaviorSubject.onComplete();

        behaviorSubject.subscribe(getThirdObserver());
    }

    void publishSubjectDemo1() {
        Observable<String> observable = Observable.just("Java", "Kotlin", "XML", "Json");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        PublishSubject<String> publishSubject = PublishSubject.create();

        observable.subscribe(publishSubject);

        publishSubject.subscribe(getFirstObserver());
        publishSubject.subscribe(getSecondObserver());
        publishSubject.subscribe(getThirdObserver());
    }

    void publishSubjectDemo2() {


        PublishSubject<String> publishSubject = PublishSubject.create();

        publishSubject.subscribe(getFirstObserver());

        publishSubject.onNext("Java");
        publishSubject.onNext("Kotlin");
        publishSubject.onNext("XML");

        publishSubject.subscribe(getSecondObserver());
        publishSubject.onNext("Json");
        publishSubject.onComplete();

        publishSubject.subscribe(getThirdObserver());
    }

    void replaySubjectDemo1() {
        Observable<String> observable = Observable.just("Java", "Kotlin", "XML", "Json");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        ReplaySubject<String> replaySubject = ReplaySubject.create();

        observable.subscribe(replaySubject);

        replaySubject.subscribe(getFirstObserver());
        replaySubject.subscribe(getSecondObserver());
        replaySubject.subscribe(getThirdObserver());
    }

    void replaySubjectDemo2() {
        Observable<String> observable = Observable.just("Java", "Kotlin", "XML", "Json");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        ReplaySubject<String> replaySubject = ReplaySubject.create();

        observable.subscribe(replaySubject);

        replaySubject.subscribe(getFirstObserver());
        replaySubject.subscribe(getSecondObserver());
        replaySubject.subscribe(getThirdObserver());
    }


    private Observer<String> getFirstObserver() {

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

                Log.i(TAG, "First observer onSubscribe");

            }

            @Override
            public void onNext(String s) {

                Log.i(TAG, "First observer Received " + s);

            }

            @Override
            public void onError(Throwable e) {

                Log.i(TAG, "First observer onError");

            }

            @Override
            public void onComplete() {

                Log.i(TAG, "First observer onComplete");

            }
        };

        return observer;
    }

    private Observer<String> getSecondObserver() {

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

                Log.i(TAG, "Second observer onSubscribe");

            }

            @Override
            public void onNext(String s) {

                Log.i(TAG, "Second observer Received " + s);

            }

            @Override
            public void onError(Throwable e) {

                Log.i(TAG, "Second observer onError");

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "Second observer onComplete");

            }
        };

        return observer;
    }

    private Observer<String> getThirdObserver() {

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

                Log.i(TAG, "Third observer onSubscribe");

            }

            @Override
            public void onNext(String s) {

                Log.i(TAG, "Third observer Received " + s);

            }

            @Override
            public void onError(Throwable e) {

                Log.i(TAG, "Third observer onError");

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "Third observer onComplete");

            }
        };

        return observer;
    }


}