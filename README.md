# Real Time Weather Application
This is a weather application that shows realtime weather with forecast for the next 1 week and 
weather history of previous 2 weeks.

## Dependency Management

Separated dependencies in **buildSrc** for better management, re-usability and easy maintenance. 
This approach is most effected when project has multiple modules therefore, the common dependencies 
can be implemented in **buildSrc** which can be used in all modules.

## Separation of DataClasses

UI dataclasses are separated from network dataclasses for the separation of concern.
This helps to maintain and easy-to handle data for both UI and API calls.

## Build with 🛠

OkHttp - A http client to make network calls.

Retrofit - A type-safe HTTP client for Android.

Coil - An image loading library for Android backed by Kotlin Coroutines.

Junit - A “Unit Testing” framework for Java Applications.

Jetpack composes - An Android’s recommended modern toolkit for building native UI that allows you to create automated UI tests for your Android app.

ViewModel - Stores UI-related data that isn't destroyed on UI changes.

Hilt - Easier way to incorporate Dagger DI into Android apps.

Kotlin - First class and official programming language for Android development.

Coroutines - For asynchronous and more..

StateFlow - A state-holder observable flow that emits the current and new state updates to its collectors.

Moshi - A modern JSON library that will give us powerful JSON serialization and deserialization in our code with little effort.

Mockk - Mocking library for kotlin.

Kotest - A flexible and elegant multi-platform test framework for Kotlin with extensive assertions.

Turbine - A small testing library for kotlinx.coroutines Flow.