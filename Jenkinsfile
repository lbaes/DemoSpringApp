pipeline {
    environment {
        registryCredential = 'dockerHub'
    }

    agent none

    stages {
        stage('Maven Build') {
            agent {
                docker {
                    image 'maven:3.6.3-openjdk-15'
                    args '--user root -v /root/.m2:/root/.m2'
                }
            }

            steps {
                echo 'Starting application build'
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage ('Test') {
            agent {
                docker {
                    image 'maven:3.6.3-openjdk-15'
                    args '--user root -v /root/.m2:/root/.m2'
                }
            }

            steps {
                echo 'Running tests'
                sh 'mvn test'
            }
        }

        stage ('Deliver') {
            agent none
            steps {
                echo 'build and push image'
                script {
                    def siteImage = docker.build("lbaes/spring-rest-calculator:latest", "./Docker/app/")
                    docker.withRegistry( '', registryCredential ) {
                        siteImage.push()
                    }
                }
                echo 'site finished'

            }
        }
    }

}
