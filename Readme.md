# Summary
This repo covers the concepts of RxJava.

## RxJava
RxJava is java based extension of ReactiveX. **ReactiveX** is a project that aims to provide reactive programming concepts to various programming languages.

**Reactive Programming** is a event driven programming where in a program reacts as and when data appears.

## Components:

### **Observable :**
It is an object that emits 0 or more data, can send error message and whose speed can be controlled  while emitting a set of data.

We have following classes to create observables :

* Flowable : It has 0..N flows and can emit 0 to N items. Supports reactive streams and back pressure.
* Observalbe : It has 0..N flows as well but does not support back pressure.
* Single : It either emits 1 item or error.
* Completable : It does not emit item, but is used as signal of completion or error.
* MayBe : Either no item or 1 item is emitted.

### **Observer :**
It subscribes to Observable's data and reacts when ever a data comes to it.
 