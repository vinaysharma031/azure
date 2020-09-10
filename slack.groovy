#!/usr/bin/env groovy
def notifySlack(String buildStatus = 'STARTED') {
  buildStatus = buildStatus ?: 'SUCCESS'
  def color
  if (buildStatus == 'STARTED') {
    color = '#D4DADF'
  } else if (buildStatus == 'SUCCESS') {
    color = '#218734'
  } else if (buildStatus == 'UNSTABLE') {
    color = '#FFFE89'
  } else {
    color = '#EE204D'
  }
  def msg = "${buildStatus}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"
  slackSend(channel: '#general',color: color , message: msg)
}

return [
    notifySlack: this.&notifySlack
]

