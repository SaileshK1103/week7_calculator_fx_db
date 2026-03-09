pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                // This compiles your code and creates the target folder
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                // Replace 'saileshk1103' with your Docker Hub username
                sh 'docker build -t saileshk1103/week7_calculator_fx_db .'
            }
        }
    }
}