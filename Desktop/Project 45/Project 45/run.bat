@echo off 
javac -d bin src\*.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b
)
 
java -cp ".;lib/mysql-connector-j-9.1.0.jar;bin" RestaurantSystem
pause
