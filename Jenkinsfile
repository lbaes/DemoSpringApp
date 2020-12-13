pipeline {
    environment {
        registryCredential = 'dockerHub'
    }
    agent {
        docker {
            image 'maven:3.6.3-openjdk-11'
            args '--user root -v /root/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock -v /usr/bin/docker:/usr/bin/docker -e DATABASE_IP=172.17.0.2 -e DATABASE_PORT=3306'
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
                    def siteImage = docker.build("lbaes/spring-rest-calculator:latest", "./")
                    docker.withRegistry( '', registryCredential ) {
                        siteImage.push()
                    }
                }
                echo 'site finished'

            }
        }
    }

}