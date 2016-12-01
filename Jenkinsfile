node {
   stage('Preparation') {
      checkout scm 
      echo "Building branch: ${env.BRANCH_NAME}"
   }
   stage('Build') {
      sh "./gradlew clean package"
   }
   stage('Results') {
      archive 'build/*.tar.gz'
   }
}
