pipeline {

    agent any

    stages {

        stage ('Unit Tests') {
            //Inserte su declaracion aqui
                sh './gradlew build'
                junit 'build/test-results/test/*.xml'
        }

        stage ('SonarCloud Static Code Analysis') {
            //Inserte su declaracion aqui
            withSonarQubeEnv('sonarQube') { // Will pick the global server connection you have configured
                  sh './gradlew sonarqube'
                }
        }

        stage ('SonarCloud Quality Gate') {
            steps {
                withSonarQubeEnv('sonarQube') {
                    timeout(time: 5, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }


        stage('Build') {
            steps {
                sh './gradlew assemble'
                archiveArtifacts( artifacts: 'build/libs/*.jar', fingerprint: true)
            }
        }
    }
}