package com.tutorial.rx;

import io.reactivex.Completable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;

/**
 * Completable Observable indicates when a processing is complete.
 */
public class CompletableObservable {

  public static void main(String[] a) throws InterruptedException {
    //create completable observable
    Completable completable = Completable.error(new Throwable());
    //create observer
    Disposable disposable = completable.subscribeWith(new DisposableCompletableObserver() {
      @Override
      public void onComplete() {
        System.out.println("Message processing Complete");
      }

      @Override
      public void onError(@NonNull Throwable e) {
        e.printStackTrace();
      }
    });
    Thread.sleep(2000);

  }
}
