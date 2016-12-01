node {
   stage('Preparation') {
      checkout scm 
      sh 'env | sort'
   }
   stage('Build') {
      sh "./gradlew clean package"
   }
   stage('Results') {
      archive 'build/*.tar.gz'
   }
}
