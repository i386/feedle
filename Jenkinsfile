pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
        junit(testResults: 'target/**/*.xml', allowEmptyResults: true)
      }
    }
  }
}