pipeline {
    environment {
        registryCredential = 'dockerHub'
    }
    agent {
        dockerfile { 
                filename 'Dockerfile'
         }
    }
    stages {
        stage('Maven Build') {
            steps {
                echo 'Starting application build'
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage ('Test') {
            steps {
                echo 'Running tests'
                sh 'mvn test'
            }
        }

        stage ('Deliver') {
            steps {
                echo 'build and push image'
                script {
                    def siteImage = docker.build("lbaes/spring-rest-calculator:latest", "./app/")
                    docker.withRegistry( '', registryCredential ) {
                        siteImage.push()
                    }
                }
                echo 'site finished'

            }
        }
    }

}
