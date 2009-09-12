@ECHO %1
@ECHO %2
@ECHO %3
@ECHO %4
for /f %%i in ("%0") do set curpath=%%~dpi
cd /d %curpath%
java -Xms128m -Xmx256m -cp ..\lib\pixelmed.jar;..\lib\jdom.jar;..\lib\DicomUtil.jar;..\lib\mime-util.jar; RECISTFollowUpAdjudicator %1 %2 %3 %4
EXIT