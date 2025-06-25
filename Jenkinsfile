pipeline {
    agent { 
        node {
            label 'built-in'
            }
      }
    stages {
        stage('Build') {
            steps {
                echo "Building.."
                sh '''
                ls -a
                '''
                
            }
        }
        stage('Test') {
            steps {
                echo "Testing.."
               
            }
        }
        stage('Code Analysis') {
            
            steps {
                    withSonarQubeEnv(installationName: 'sonar') {
                                  sh 'mvn clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922:sonar'

                    
                }
            }
        }
    }
}
