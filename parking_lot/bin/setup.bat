@echo OFF
cd ..
call gradlew.bat compileJava
xcopy /E /Y build\classes\java\main  bin\main
cd bin\main
echo  ----
echo  ----
echo -----  
echo ================TESTING==============

java -cp packages/junit-4.13-beta-2.jar;packages/hamcrest-all-1.3.jar;. com.huda.unittesting.TestRunner
cd ..