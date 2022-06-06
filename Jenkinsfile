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
    }
    post {
        always {
            junit 'results/*_result.xml'
            cleanWs()
            echo 'Sending email'
            mail to: "youssefbenmansour@gmail.com",
            subject: "Failure Job",
            body: "Error ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} "
        }
    }
}
