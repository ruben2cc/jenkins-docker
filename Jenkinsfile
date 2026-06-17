pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                checkout scm
            }
        }

        stage('Pruebas y Empaquetado')  {
            agent {
                docker {
                    image 'maven:3.9.9-eclipse-temurin-17'
                    args '-v /var/jenkins_home/.m2:/var/jenkins_home/.m2'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn clean package'
                sh 'pwd'
                echo $HOME
            }
        }

        stage('Crear imagen docker') {
            steps {
                sh 'docker build -t site-img .'
                echo $HOME
            }
        }

        stage('Ejecutar container') {
            steps {
                sh '''
                    docker rm -f site || true
                    docker run -d --name site -p 8180:8080 site-img
                '''
            }
        }
    }
}