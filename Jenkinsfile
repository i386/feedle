pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
        junit(testResults: 'target/**/*.xml', allowEmptyResults: true)
      }
    }
    stage('Test') {
      steps {
        echo 'asasas'
      }
    }
    stage('Deploy') {
      steps {
        sleep 4
      }
    }
  }
}