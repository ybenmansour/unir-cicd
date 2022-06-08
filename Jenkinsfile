pipeline {
    agent any
    stages {
        stage('Source') {
            steps {
                git 'https://github.com/ybenmansour/unir-cicd.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building stage!'
                sh 'make build'
            }
        }
        stage('Unit tests') {
            steps {
                sh 'make test-unit'
                archiveArtifacts artifacts: 'results/*.xml'
            }
        }
        stage('Api tests') {
            steps {
                sh 'make test-api'
                archiveArtifacts artifacts: 'results/*.xml'
            }
        }
        stage('E2E tests') {
            steps {
                sh 'make test-e2e'
                archiveArtifacts artifacts: 'results/*.xml'
            }
        }
    }
    post {
        always {
            junit 'results/*_result.xml'
            cleanWs()
            emailext body: 'A Test EMail', 
            recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], 
            to: 'youssefbenmansour@gmail.com',
            attachLog: true,
            body: 'Error ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} ', 
            compressLog: true,
            subject: 'Test'
        }
    }
}
