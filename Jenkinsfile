pipeline {
    agent any
    environment {
        registry = 'tushaar28/nagp_devops_exam'
        registryCredential = 'dockerhub'
        dockerImage = ''
        dockerImageLatest = ''
    }
    tools {
        maven 'Maven 3'
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
                dockerImage = docker.build registry + ":${BUILD_NUMBER}"
                dockerImage = docker.build registry + ":latest"
            }
        }
        stage ('Login to docker and push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'username')]) {
                    dockerImage.push()
                    dockerImageLatest.push()
                }
            }
        }
        stage ('Docker deployment') {
            steps {
                bat 'docker run --name nagp_devops_exam -d -p 8080:7400 tushaar28/nagp_devops_exam:latest'
            }
        }
    }
}