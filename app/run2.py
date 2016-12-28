#coding = utf - 8
import os
import os.path
import glob

#os.system("adb shell rm -rf sdcard/report*.xml")
if os.path.exists('report*.xml'):
	os.remove('report*.xml')
if os.path.exists("total.txt"):
	os.remove("total.txt")
#os.system("adb shell rm -rf sdcard/crash.xml")
os.system("adb uninstall net.oschina.app")
os.system("adb uninstall net.oschina.app.test")
os.system("adb install .\\build\\outputs\\apk\\debug\\osc-android-v2.9.9(1609281026)-oschina-debug.apk")	
os.system("adb install .\\build\\outputs\\apk\\app-oschina-debug-androidTest-unaligned.apk")
re_run=True
count=0
re_genarate_test=False
while  re_run:
    os.system("adb shell am instrument -w -e reportDir sdcard -e reportFile report_"+str(count)+".xml -e isNeedReGenarate "+str(re_genarate_test)+" net.oschina.app.test/net.oschina.app.Runner2")
    os.system("adb pull sdcard/report_"+str(count)+".xml")
    os.system("adb pull sdcard/crash.txt")
    if os.path.exists("crash.txt"):
        print ("crash happened")
        f1=open("crash.txt",r)
        name=f1.readline()
        f1.close()
        f2.open("total.txt",a)
        f2.write(name)
        f2.write("\n")
        os.remove("crash.txt")
        re_genarate_test=True
        count+=1
    else:
        re_run=False