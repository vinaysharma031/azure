#!/bin/bash
echo "Please visit ${env.BUILD_URL} for further information." | mail -s "Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) success." vinkumar@qasource.com -A hello.txt
