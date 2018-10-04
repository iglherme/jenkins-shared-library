#!/usr/bin/env groovy

def call(String buildResult, String channel) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", channel: channel, message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful. \nCheck results <${env.RUN_DISPLAY_URL}|here>."
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger",channel: channel, message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed. \nCheck results <${env.RUN_DISPLAY_URL}|here>. "
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning",channel: channel, message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable. \nCheck results <${env.RUN_DISPLAY_URL}|here>."
  }
  else {
    slackSend color: "danger",channel: channel, message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear. \nCheck results <${env.RUN_DISPLAY_URL}|here>."	
  }
}
