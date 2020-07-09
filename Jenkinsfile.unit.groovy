node('agent01') {
    stage('Source') {
        git 'https://github.com/srayuso/unir-test.git'
    }
    stage('Build') {
        echo 'Building stage!'
        sh 'make build'
    }
    stage('Unit tests') {
        sh 'make test-unit'
        archiveArtifacts artifacts: 'results/unit-result.xml, results/coverage.xml'
    }
}