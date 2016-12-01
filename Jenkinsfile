node {
   stage('Preparation') {
      checkout scm 
   }
   stage('Build') {
      sh "./gradlew clean package"
   }
   stage('Results') {
      archive 'build/*.tar.gz'
   }
}
