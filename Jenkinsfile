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
            sh 'javac generator.java'
            sh 'java generator'
            echo 'Deploying....'
        }
    }
  }
}
