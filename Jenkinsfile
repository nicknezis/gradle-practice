node {
   stage('Preparation') {
      checkout scm 
   }
   stage('Build') {
      if (env.BRANCH_NAME == 'master') {
         sh "./gradlew clean package final"
      } else {
         sh "./gradlew clean package"
      }
   }
   stage('Results') {
      archiveArtifacts artifacts: 'build/*.tar.gz', fingerprint: true
   }
}
