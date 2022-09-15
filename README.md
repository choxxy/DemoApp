# Demo APP

This is an android demo project trying to demonstrates best practices, however due to time
constraint a lot has been left unfinished.

* No tests have been added
* A lot of code repetitions and bad practises

Basically this is work in progress

## Environment Setup

First off, you require the latest Android Studio Chipmunk (or newer) to be able to build the app.

## Architecture

The architecture of the application is based, apply and strictly complies with each of the following
5 points:

- A single-activity architecture.
- [Android architecture components](https://developer.android.com/topic/libraries/architecture/),
  part of Android Jetpack for give to project a robust design, testable and maintainable.
- Pattern  [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)  (
  MVVM) facilitating a [separation](https://en.wikipedia.org/wiki/Separation_of_concerns) of
  development of the graphical user interface.
- [S.O.L.I.D](https://en.wikipedia.org/wiki/SOLID)  design principles intended to make software
  designs more understandable, flexible and maintainable.
- [Modular app architecture](https://proandroiddev.com/build-a-modular-android-app-architecture-25342d99de82)
  allows to be developed features in isolation, independently from other features.

## Tech-stack

Min API level is set to 21, so the presented approach is suitable for over 98% of devices running
Android. This project takes advantage of many popular libraries and tools of the Android ecosystem.
Most of the libraries are in the stable version unless there is a good reason to use non-stable
dependency.

- [Jetpack](https://developer.android.com/jetpack):
    - [Android KTX](https://developer.android.com/kotlin/ktx.html)  - provide concise, idiomatic
      Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx)  - major improvement to the
      original
      Android  [Support Library](https://developer.android.com/topic/libraries/support-library/index)
      , which is no longer maintained.
    - [View Binding](https://developer.android.com/topic/libraries/view-binding)  - allows you to
      more easily write code that interacts with views/
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)  - perform
      actions in response to a change in the lifecycle status of another component, such as
      activities and fragments.
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)  -
      lifecycle-aware, meaning it respects the lifecycle of other app components, such as
      activities, fragments, or services.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)  - designed
      to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows
      data to survive configuration changes such as screen rotations.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)  - managing
  background threads with simplified code and reducing needs for callbacks.
- [Coroutines Flow](https://kotlinlang.org/docs/reference/coroutines-overview.html)  - cold
  asynchronous data stream that sequentially emits values and completes normally or with an
  exception
- [Dagger2](https://dagger.dev/)  - dependency injector for replacement all Factory classes.
- [Retrofit](https://square.github.io/retrofit/)  - type-safe HTTP client.
