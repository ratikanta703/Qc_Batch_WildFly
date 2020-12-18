set projectLocation=D:\Qc_Batch_WildFly\QC_ILP
cd %projectLocation%

java org.testng.TestNG %projectLocation%\testng.xml
pause