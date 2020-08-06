#!/bin/bash

#Installing chromedriver for currently installed chrome version
apt-get install -y google-chrome-stable


#check the install version of chrome and put first three values in a file ver.txt 
#using this first three value we will get to know to suitable version of chromedriver for the existing chrome version

google-chrome --version | awk {'print $3'} | cut -d "." -f 1-3 > /opt/ver.txt

#move to the file location that contain chrome version first three value 
cd /opt 

#Assign a veriable to that file ver.txt
VERSION=$(cat /opt/ver.txt)

#show the output of file using variable 
echo $VERSION

#Remove the file name start with LATEST_RELEASE because we need to download new file
rm -rf /opt/LATEST_RELEASE_*

#Download a file using this link which contain the version no. of chromedrive which is compatable with the installed chrome version 
wget https://chromedriver.storage.googleapis.com/LATEST_RELEASE_$VERSION

#Assign a variable to this file 
DRIVER_VERSION=$(cat /opt/LATEST_RELEASE_*)

echo $DRIVER_VERSION                                              

#Now download the exact chromedriver using the chromedriver version
wget https://chromedriver.storage.googleapis.com/${DRIVER_VERSION}/chromedriver_linux64.zip 

#Extract the downloaded zip file
unzip chromedriver_linux64.zip    

#Make the root ownership of the chromedriver
chown root:root /opt/chromedriver             

#Move this file to already added executable path
mv chromedriver /usr/bin/chromedriver     

#Make the chromedriver executable
chmod +x /usr/bin/chromedriver  


#Export path of executable chromedriver
export LINUX_CHROME=/usr/bin/chromedriver

echo $LINUX_CHROME 