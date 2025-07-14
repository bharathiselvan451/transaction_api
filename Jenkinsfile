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
      
    stage('SonarQube analysis') {
      steps {
        script {
            scannerHome = tool 'sonar'// must match the name of an actual scanner installation directory on your Jenkins build agent
        }
        withSonarQubeEnv('sonar') {// If you have configured more than one global server connection, you can specify its name as configured in Jenkins
          sh " mvn compile "
          sh " ls -a "
          sh " ${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=transactions \
                            -Dsonar.projectName=transactions \
                            -Dsonar.projectVersion=1.0 \
                            -Dsonar.java.binaries=target \
                            -Dsonar.sources=."
                            

        }
      }
    }
        stage('OWASP Dependency-Check Vulnerabilities') {
      steps {
        dependencyCheck additionalArguments: ''' 
                    -o './'
                    -s './'
                    -f 'ALL' 
                    --prettyPrint''', odcInstallation: 'OWASP Dependency-Check'
        
        dependencyCheckPublisher pattern: 'dependency-check-report.xml'
      }
    }
        stage(' Build docker '){

          steps{

              sh " mvn clean package "
              sh " docker build -t bharathiselvanrajendran/transactions ."
              sh " docker push bharathiselvanrajendran/transactions ."

          
          }
            
        }
  }
            }
        
    
