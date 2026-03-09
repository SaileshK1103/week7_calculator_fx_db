pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
          PATH = "/usr/local/bin:${env.PATH}"
          DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
          DOCKERHUB_REPO = 'saileshk1103/week7_calculator_fx_db'
          DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
               // Ensure this points to your NEW Week 7 repository
               git branch: 'main', url: 'https://github.com/SaileshK1103/week7_calculator_fx_db.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build and Push Multi-Arch Image') {
             steps {
                 script {
                     withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS_ID, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                         // Secure Login
                         sh "echo ${PASS} | docker login -u ${USER} --password-stdin"

                         // Builds for both Intel (AMD64) and Mac/M1 (ARM64)
                         // This is the "Gold Standard" for your assignment!
                         sh "docker buildx build --platform linux/amd64,linux/arm64 -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} . --push"
                     }
                 }
             }
        }
    }
}