@ECHO %1
@ECHO %2
@ECHO %3
@ECHO %4
for /f %%i in ("%0") do set curpath=%%~dpi
cd /d %curpath%
cd ../../../..
rem java edu.wustl.xipApplication.samples.XIPAppLazyRetrieveTest %1 %2 %3 %4
java -agentlib:jdwp=transport=dt_socket,address=localhost:8000,server=y,suspend=y edu.wustl.xipApplication.samples.XIPAppLazyRetrieveTest %1 %2 %3 %4
PAUSE
EXIT