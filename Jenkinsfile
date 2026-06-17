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
                    reuseNode true
                }
            }
            steps {
                sh 'mvn clean package Dmaven.repo.local=/var/jenkins_home/.m2/repository'
                sh 'pwd'

                sh '''
                        echo "Usuario:"
                        id

                        echo "HOME:"
                        echo $HOME

                        echo "Repositorio local Maven:"
                        mvn help:evaluate -Dexpression=settings.localRepository -q -DforceStdout

                        echo "Contenido de /root/.m2:"
                        ls -la /root/.m2 || true

                        echo "Contenido de $HOME/.m2:"
                        ls -la $HOME/.m2 || true
                    '''
            }
        }

        stage('Crear imagen docker') {
            steps {
                sh 'docker build -t site-img .'
                sh 'echo $HOME'
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