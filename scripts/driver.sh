#!/bin/bash

echo "installing chromedriver and dependency"
apt-get install -y unzip wget                           
apt-get install google-chrome-stable
cd /opt
google-chrome --version | awk {'print $3'} | cut -d "." -f 1-3 > /opt/ver.txt
VERSION=$(cat /opt/ver.txt)
echo $VERSION
rm -rf /opt/LATEST_RELEASE_*
wget https://chromedriver.storage.googleapis.com/LATEST_RELEASE_$VERSION
DRIVER_VERSION=$(cat /opt/LATEST_RELEASE_*)
echo $DRIVER_VERSION                                              
https://chromedriver.storage.googleapis.com/${DRIVER_VERSION}/chromedriver_linux64.zip 
unzip chromedriver_linux64.zip                 
mv chromedriver /usr/bin/chromedriver     
chown root:root /usr/bin/chromedriver     
chmod +x /usr/bin/chromedriver   