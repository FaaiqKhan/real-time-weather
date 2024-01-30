# Real Time Weather Application
This is a weather application that shows realtime weather with forecast for the next 1 week and 
weather history of 2 weeks.

It is developed using Jetpack compose.

# Dependency Management

Separated dependencies in **buildSrc** for better management, re-usability and easy maintenance. 
This approach is most effected when project has multiple modules therefore, the common dependencies 
can be implemented in **buildSrc** which can be used in all modules.