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
    }
    post {
        always {
            junit 'results/*_result.xml'
            cleanWs()
        }
    }
}
