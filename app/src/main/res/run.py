#coding=utf-8
import os
import os.path

os.system("adb shell rm -f /sdcard/report.xml")
if os.path.exists("report.xml"):
	os.remove("report.xml")
os.system("adb uninstall com.example.add.test")
os.system("adb uninstall com.example.add")

os.system("ant clean debug")
os.system("adb install ../Calculate/bin/Calculate-debug.apk")
os.system("adb install ./bin/CalculateTest-debug.apk")

os.system("adb shell am instrument -w -e reportDir sdcard -e reportFile report.xml com.example.add.test/com.zutubi.android.junitreport.JUnitReportTestRunner")
os.system("adb pull /sdcard/report.xml")