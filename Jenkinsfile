pipeline {
    agent any

    tools {
        // This allows Jenkins to find your Maven installation
        maven 'Maven3'
    }

    environment {
        // This ensures your Mac's local paths are visible to Jenkins
        PATH = "/usr/local/bin:${env.PATH}"
        DOCKER_HOST = "unix:///Users/${USER}/.docker/run/docker.desktop.sock"
    }

    stages {
        stage('Checkout') {
            steps {
                // 'checkout scm' is better for SCM-based pipelines
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                // Using clean package to create the JAR file
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                // This builds your specific week 7 image
                sh 'docker build -t saileshk1103/week7_calculator_fx_db .'
            }
        }
    }
}