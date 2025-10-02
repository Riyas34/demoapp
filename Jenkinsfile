pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "demoapp"
        DOCKER_CONTAINER = "demoapp-container"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Riyas34/demoapp.git'
            }
        }

       stage('Prepare Maven Wrapper') {
                   steps {
                       // Make sure mvnw is executable
                       sh 'chmod +x mvnw'
                   }
               }

       stage('Build JAR') {
           steps {
               sh './mvnw clean package -DskipTests'
           }
       }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t $DOCKER_IMAGE ."
                }
            }
        }

        stage('Deploy in Local Docker') {
            steps {
                script {
                    sh "docker rm -f $DOCKER_CONTAINER || true"
                    sh "docker run -d --name $DOCKER_CONTAINER -p 5080:5080 $DOCKER_IMAGE"
                }
            }
        }
    }
}
