#!/usr/bin/env groovy

def deployment() {

// Email Notification for deployment
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/> <b>Test Deployment</b> has been completed. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true,
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "Test Deployment:- PASSED  :  Job ${env.JOB_NAME}"
}

def deploymentFailure() {

// Email Notification for Failure
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job for <b>API Results</b> has been completed. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true, attachmentsPattern: 'apiResults/API_Email_Report.html',
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "API Tests Report  :  FAILED  :  Job ${env.JOB_NAME}"
}

def APITESTPASS() {
// Email Notification for Pass
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job for <b>API Results</b> has been completed. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true, attachmentsPattern: 'apiResults/API_Email_Report.html',
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "API Tests Report  :  PASSED  :  Job ${env.JOB_NAME}"
}

def MVNTESTFAIL() {
// Email Notification for Failure
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job for <b>API Results</b> has been completed. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true,
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "API Tests  :  MAVEN TESTS FAILED  :  Job ${env.JOB_NAME}"
}

def UITESTFAIL() {
// Email Notification for Failure
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>UI Test executor connection  <b>Failed</b>. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true,
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "UI Test Executor Connection: Failed :  Job ${env.JOB_NAME}"
}

// Email Notification for Failure
def UIFAILREPORT() {
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job for <b>UI Automation Results</b> has been completed. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: false, attachmentsPattern: 'uiAutomationResults/Automation_Email_Report.html',
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "UI Automation Tests Report  :  FAILED  :  Job ${env.JOB_NAME}"
}


// Email Notification for Pass
def UIPASSREPORT() {
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job for <b>UI Automation Results</b> has been completed. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: false, attachmentsPattern: 'uiAutomationResults/Automation_Email_Report.html',
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "UI Automation Tests Report  :  PASSED  :  Job ${env.JOB_NAME}"
}

// Email Notification for Failure
def UIMVNFAIL() {
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job for <b>UI Automation Results</b> has been completed. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true,
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "UI Automation Tests   : MAVEN TESTS FAILED  :  Job ${env.JOB_NAME}"
}

// Email Notification for Pass
def ARTIFTRY() {
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job <b>${env.JOB_NAME}</b> has been <b style=\"color:green;\">Passed</b>. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><b>Artifactory Build URL</b>:</b> <a href=${ArtifactoryURL}>${ArtifactoryURL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true,
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "Job ${env.JOB_NAME}  :  SUCCESS  : Build Delivered to Artifactory"
}

// Email Notification for Failure
def FAIlARTIFTRY() {
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job <b>${env.JOB_NAME}</b> has been <b style=\"color:red;\">Failed</b>. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true,
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "Job ${env.JOB_NAME}  :  FAILED  : Build Delivered to Artifactory"
}

// Email Notification for Pass
def PRODEPLOY() {
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job <b>${env.JOB_NAME}</b> has been <b style=\"color:green;\">Passed</b>. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/><b>Deployed Application URL<b>:</b> <a href=${AppURL}>${AppURL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true,
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "Job ${env.JOB_NAME}   : PASSED  :  Build Deployed to Production"
}

// Email Notification for Failure
def PRODEPLOYFAIL() {
emailmessage = "<font face=\"garamond\">Hi Team,<br/><br/>Jenkins Job <b>${env.JOB_NAME}</b> has been <b style=\"color:red;\">Failed</b>. Please find <b>HTML Results/Logs</b> as attachment. <br/><br/>Below are the details:<br/><br/><b>Jenkins Job:</b> <a href=${env.BUILD_URL}>${env.BUILD_URL}</a><br/><br/><b>Deployed Application URL</b>:</b> <a href=${AppURL}>${AppURL}</a><br/><br/>--<br/>Thanks<br/>DevOps Team</font>"
emailext attachLog: true,
to: "${EmailRecipients}",
body: "${emailmessage}",
subject: "Job ${env.JOB_NAME}   : FAILED  :  Build Deployed to Production"
}

return [
    email: this.&email
    deployment: this.&deployment
    deploymentFailure: this.&deploymentFailure
    APITESTPASS: this.&APITESTPASS
    MVNTESTFAIL: this.&MVNTESTFAIL
    UITESTFAIL: this.&UITESTFAIL
    UIFAILREPORT: this.&UIFAILREPORT
    UIPASSREPORT: this.&UIPASSREPORT
    UIMVNFAIL: this.&UIMVNFAIL
    ARTIFTRY: this.&ARTIFTRY
    FAIlARTIFTRY: this.&FAIlARTIFTRY
    PRODEPLOY: this.&PRODEPLOY
    PRODEPLOYFAIL: this.&PRODEPLOYFAIL
]

	
	
