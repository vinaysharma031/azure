#!/usr/bin/env groovy
def email() {

mail body: "Please visit ${env.BUILD_URL} for further information.",
subject: "Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) success.",
to: 'vinkumar@qasource.com'

}

return return [
    email: this.&email
]