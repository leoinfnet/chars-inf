pipeline {
    agent any
    tools {
        maven 'mvn'

    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn clean package -DSkipTests '
                sh "git rev-parse --short HEAD > commit-id"
                tag = readFile('commit-id').replace("\n", "").replace("\r", "")

                    // configura o nome da aplicação, o endereço do repositório e o nome da imagem com a versão
                appName = "jenkins-docker-kubectl"
                registryHost = "127.0.0.1:30400/"
                imageName = "${registryHost}${appName}:${tag}"
                echo imageName
            }
        }
    }
}