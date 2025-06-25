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
                    withSonarQubeEnv(credentialsId:'e2184ea6-883f-4d6a-8549-5cb468de22e9', installationName: 'sonar') {
                                  sh 'mvn clean package org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922:sonar'

                    
                }
            }
        }
    }
}
