package com.tutorial.rx;

import io.reactivex.Flowable;

//This class tests whether the RX dependencies are properly installed in project or not.
public class TestRX {

  public static void main(String[] args) {
    Flowable.just("Hello Rahul !!").subscribe(System.out::println);
  }
}
