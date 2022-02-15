pipeline {
  agent any
  stages {
    stage('Test'){
      steps{
        echo 'Testing....'
      }
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
