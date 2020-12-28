package com.tutorial.rx;

import io.reactivex.Maybe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;

/**
 * Can emit single item  or empty response.
 * When empty response then onComplete() is executed
 */
public class MayBeObservable {

  static Maybe<String> createMayBeObservable() {
    return Maybe.just("Hello Rx !!");
  }

  static Maybe<String> createEmptyMayBeObservable() {
    return Maybe.just("Hello Rx !!");
  }

  static Maybe<String> createMayBeObservableForException() {
    return Maybe.error(new Throwable("Rx Exception Occurred !!"));
  }

  public static void main(String[] a) throws InterruptedException {
    //create a MayBe observable
    Maybe<String> maybeObservable = createMayBeObservable();
    //create an observer
    Disposable disposable = maybeObservable.subscribeWith(new DisposableMaybeObserver<String>() {
      @Override
      public void onSuccess(@NonNull String s) {
        System.out.println("Message is : " + s);
      }

      @Override
      public void onError(@NonNull Throwable e) {
        e.printStackTrace();
      }

      @Override
      public void onComplete() {
        System.out.println("Message Processing complete !!");
      }
    });
    Thread.sleep(1000);
  }
}
