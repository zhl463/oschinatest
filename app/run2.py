#coding = utf - 8
import os
import os.path
import glob

os.system("adb shell rm -f /sdcard/report.xml")
os.system("adb shell rm -f /sdcard/crash.txt")
if os.path.exists("report.xml"):
	os.remove("report.xml")

exe_str = "adb shell am instrument -w -e reportDir sdcard -e reportFile report.xml net.oschina.app.test/net.oschina.app.Runner2"
os.system(exe_str)
os.system("adb pull /sdcard/report.xml")