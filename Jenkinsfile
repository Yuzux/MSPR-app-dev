pipeline {
  agent none
  stages {
    stage('Test'){
      echo 'Testing....'
    }
    stage('Deploy') {
        steps {
            sh 'sudo javac generator.java'
            sh 'sudo java generator'
            echo 'Deploying....'
        }
    }
  }
}
