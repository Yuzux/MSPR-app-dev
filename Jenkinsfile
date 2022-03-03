pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building....'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing....'
            }
        }
        stage('Deploy') {
            steps {
                sh 'javac generator.java'
                sh 'java generator'
            }
        }
    }
}
