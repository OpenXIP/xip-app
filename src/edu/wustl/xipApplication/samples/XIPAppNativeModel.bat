@ECHO %1
@ECHO %2
@ECHO %3
@ECHO %4
for /f %%i in ("%0") do set curpath=%%~dpi
cd /d %curpath%
cd ../../../..
java edu.wustl.xipApplication.samples.XIPAppNativeModel %1 %2 %3 %4
EXIT