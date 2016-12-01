node {
   stage('Preparation') {
      checkout scm 
   }
   stage('Build') {
      if (env.BRANCH_NAME == 'master') {
         sh "./gradlew -Prelease.useLastTag=true clean package final"
      } else if (env.BRANCH_NAME =~ /release\/\d+(\.\d+)+/) {
         sh "./gradlew clean package candidate"
      } else {
         sh "./gradlew clean package"
      }
   }
   stage('Results') {
      archiveArtifacts artifacts: 'build/*.tar.gz', fingerprint: true
   }
}
