RandomName Unit Tests
===================

Unit tests for the [RandomName Android Application](http://github.com/otternq/RandomName)

Spoon Execution:
====

* download Spoon Runner at : http://square.github.com/spoon/
* add spoon client to your test project 
* sppon client jar can be found at: http://square.github.com/spoon/
* run following command: 
```
java -jar ./spoon-runner-1.0.2-jar-with-dependencies.jar --apk MainActivity.apk --test-apk RandomNameUnitTests.apk --sdk your-android-sdk-path
```

(MainActivity.apk & RandomNameUnitTests.apk can be found in your workspace under bin directory) 
