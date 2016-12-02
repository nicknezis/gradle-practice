node {
   stage('Preparation') {
      checkout scm 
   }
   stage('Build') {
      if (env.BRANCH_NAME == 'master') {
         sh "./gradlew -Prelease.useLastTag=true clean buildRpm final"
      } else if (env.BRANCH_NAME =~ /release\/\d+(\.\d+)+/) {
         sh "./gradlew clean buildRpm candidate"
      } else {
         sh "./gradlew clean buildRpm"
      }
   }
   stage('Results') {
      archiveArtifacts artifacts: 'packaging/build/distributions/*.rpm', fingerprint: true
   }
}
