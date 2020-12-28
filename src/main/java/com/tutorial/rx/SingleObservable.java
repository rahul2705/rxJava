package com.tutorial.rx;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Emits 1 item or error. Does not emit onComplete event.
 * replacing createSingleObservable() with createSingleObservableForException() will cause onError() disposable block to be executed.
 */
public class SingleObservable {

  static Single<String> createSingleObservable() {
    return Single.just("Hello Rx !!");
  }

  static Single<String> createSingleObservableForException() {
    return Single.error(new Throwable("Rx Exception Occurred !!"));
  }

  public static void main(String[] a) throws InterruptedException {
    //create a single observable
    Single<String> singleObservable = createSingleObservable();
    //create observer
    Disposable disposable = singleObservable.delay(2, TimeUnit.SECONDS, Schedulers.io())
        .subscribeWith(new DisposableSingleObserver<String>() {
          @Override
          public void onSuccess(@NonNull String o) {
            System.out.println("Message is : " + o);
          }

          @Override
          public void onError(@NonNull Throwable e) {
            e.printStackTrace();
          }
        });
    Thread.sleep(3000);
    //clear or unsubscribe the observer
    disposable.dispose();
  }
}
