pipeline {
    agent any

    environment {
        IMAGE_NAME = "server-app"
        CONTAINER_NAME = "server-app"
        DB_CONTAINER_NAME = "server-mysql"
    }

    stages {
        stage('Build JAR') {
            steps {
                sh './gradlew build' // Если используете Gradle
                // sh 'mvn package -DskipTests' // Если используете Maven
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${IMAGE_NAME} .'
            }
        }

        stage('Run Docker Containers') {
            steps {
                sh 'docker-compose up -d'
            }
        }

        stage('Check Running Containers') {
            steps {
                sh 'docker ps'
            }
        }
    }

    post {
        always {
            echo 'Pipeline завершён'
        }
        failure {
            echo 'Что-то пошло не так...'
        }
    }
}
