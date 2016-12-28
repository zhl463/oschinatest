#coding = utf - 8
import os
import os.path
import glob

os.system("adb uninstall net.oschina.app")
os.system("adb uninstall net.oschina.app.test")
os.system("adb shell rm -f /sdcard/report.xml")
os.system("adb shell rm -f /sdcard/crash.txt")
# if os.path.exists("report.xml"):
# 	os.remove("report.xml")
os.system("adb install .\\build\\outputs\\apk\\debug\\osc-android-v2.9.9(1609281026)-oschina-debug.apk")	
os.system("adb install .\\build\\outputs\\apk\\app-oschina-debug-androidTest-unaligned.apk")	
exe_str = "adb shell am instrument -w -e reportDir sdcard -e reportFile report.xml net.oschina.app.test/net.oschina.app.Runner2"
os.system(exe_str)
os.system("adb pull /sdcard/report.xml")