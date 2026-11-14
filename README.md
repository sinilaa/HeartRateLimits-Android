# Heart Rate Limits Calculator

## Description

This is a simple Android application that calculates heart rate limits for exercising based on the user's age.

The user enters their age, and the application automatically calculates the lower and upper heart rate limits.

## Formulas

The heart rate limits are calculated using the following formulas:

- **Lower limit:** (220 - age) * 0.65
- **Upper limit:** (220 - age) * 0.85

The results are displayed in beats per minute.

## Input validation

If the input is empty or contains a non-numeric value, both heart rate limits are displayed as 0.

## Technologies used

- Kotlin
- Android Studio
- Jetpack Compose

## Running the application

1. Clone the repository.
2. Open the project in Android Studio.
3. Wait for Gradle to sync the project.
4. Connect an Android phone with USB debugging enabled, or start an Android emulator.
5. Click the Run button in Android Studio to launch the application.
