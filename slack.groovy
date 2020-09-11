#!/usr/bin/env groovy
// Slack Notification
def notifySlack(buildStatus = 'PIPELINE BUILD STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'PIPELINE BUILD SUCCESS'
    //Getting Curernt Build Details
    
    // Defining Colors with respect to Build Status.
    def slackMessage = "${buildStatus} \n Jenkins Job : `${env.JOB_NAME}`\n Jenkins Job Number : `#${env.BUILD_NUMBER}`\n Job triggered by : \n Please find more info at: ${env.BUILD_URL}"
    def color
    def applicationUrl
    if (buildStatus == 'PIPELINE BUILD STARTED') {
        color = '#D4DADF'
    } else if (buildStatus == 'PIPELINE BUILD SUCCESS') {
        color = '#228B22'
    } else if (buildStatus == 'TEST DEPLOYMENT PASSED') {
        color = '#BDFFC3'
        applicationUrl = "\n Application Test URL: ${AppURL}"
    } else if (buildStatus == 'API TESTS PASSED') {
        color = '#BDFFC3'
    } else if (buildStatus == 'UI TEST EXECUTOR CONNECTED') {
        color = '#BDFFC3'
    } else if (buildStatus == 'WEB UI TESTS PASSED') {
        color = '#BDFFC3'
    } else if (buildStatus == 'DELIVERY PASSED') {
        color = '#BDFFC3'
    } else if (buildStatus == 'PRODUCTION DEPLOYMENT PASSED') {
        color = '#BDFFC3'
        applicationUrl = "\n Application Production URL: ${AppURL}"
    } else if (buildStatus == 'PIPELINE BUILD UNSTABLE') {
        color = '#FFFE89'
    } else {
        color = '#FF9FA1'
    }
   // Dynamic Message Defination for Slack Notification.
    if (buildStatus == 'TEST DEPLOYMENT PASSED' || 'PRODUCTION DEPLOYMENT PASSED') {
        slackSend(channel: '#general',color: color , message: slackMessage + applicationUrl)
    } else {
        slackSend(channel: '#general',color: color , message: slackMessage)
    }
}

return [
    notifySlack: this.&notifySlack
]
