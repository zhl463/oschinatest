#coding = utf - 8
import os
import os.path
import glob

os.system("adb shell rm -f /sdcard/report.xml")
os.system("adb shell rm -f /sdcard/crash.txt")
if os.path.exists("report.xml"):
	os.remove("report.xml")
re_run = True
count = 0
re_generate_test = False
while re_run:
	exe_str = "adb shell am instrument -w -e reportDir sdcard -e reportFile report_" + str(count) + ".xml -e reorganize " + str(re_generate_test) + " net.oschina.app.test/net.oschina.app.Runner2"
	os.system(exe_str)
	os.system("adb pull /sdcard/report_" + str(count) + ".xml")
	os.system("adb pull /sdcard/crash.txt")
	if os.path.exists("crash.txt"):
		print("crash happen")
		f1 = open('crash.txt', 'r')
		name = f1.readline()
		f1.close()
		f2 = open('total.txt', 'a')
		f2.write(name)
		f2.write("\n")
		f2.close()
		os.remove("crash.txt")
		re_generate_test = True
		count += 1
	else :
		re_run = False

def check(filename, text):
	datafile = open(filename)
	found = False
	for line in datafile:
		if text in line:
			return True
	return False

for infile in glob.glob(os.path.join(".", "report*.xml")):
	if not check(infile, "</testsuites>"):
		f = open(infile, 'a')
		f.write("</testsuites>")
		f.close()