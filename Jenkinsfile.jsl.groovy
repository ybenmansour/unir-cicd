library(
      identifier: 'unir-jsl@master',
      retriever: modernSCM(
        [
          $class: 'GitSCMSource',
          remote: "https://github.com/srayuso/unir-jsl.git"
        ]
      )
    ) _

pipeline {
    agent any
    stages {
        stage('Info') {
            steps {
                jslInfo()
            }
        }
    }
}