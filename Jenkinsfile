pipeline {
    agent any
    environment {
        registry = 'tushaar28/nagp_devops_exam'
        registryCredential = 'dockerhub'
        dockerImage = ''
        dockerImageLatest = ''
    }
    tools {
        maven 'Maven3'
    }
    stages {
        stage('Test') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage ('Build project') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage ('Build docker image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":${BUILD_NUMBER}"
                    dockerImageLatest = docker.build registry + ":latest"
                }
            }
        }
        stage ('Login to docker and push') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'username')]) {
                    dockerImage.push()
                    dockerImageLatest.push()
                }
                }
            }
        }
        stage ('Docker deployment') {
            steps {
                bat 'docker run --name nagp_devops_exam -d -p 7400:8080 tushaar28/nagp_devops_exam:latest'
            }
        }
    }
}
