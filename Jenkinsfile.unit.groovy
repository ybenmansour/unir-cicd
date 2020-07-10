pipeline {
    agent {
        label 'python'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building stage!'
                sh 'make build'
            }
        }
        stage('Unit tests') {
            steps {
                sh 'make test-unit'
                archiveArtifacts artifacts: 'results/unit-result.xml, results/coverage.xml'
            }
        }
    }
}