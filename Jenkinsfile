node {
    checkout scm
    def customImage
    // Pega o commit id para ser usado de tag (versionamento) na imagem
    sh "git rev-parse --short HEAD > commit-id"
    tag = readFile('commit-id').replace("\n", "").replace("\r", "")

    // configura o nome da aplicação, o endereço do repositório e o nome da imagem com a versão
    appName = "chars-inf"
    registryHost = "127.0.0.1:30400/"
    imageName = "${registryHost}${appName}:${tag}"

    // Configuramos os estágios
    stage ('Build') {
    //def customImage = docker.build("${imageName}")
        withMaven(maven: 'maven') {
              sh "mvn clean package"
        }
        customImage = docker.build("${imageName}")
    }
    stage('Push'){
         customImage.push()
         customImage.push('latest')

    }
    stage('Deploy'){
        customImage.push('latest')
        sh 'kubectl apply -f https://raw.githubusercontent.com/leoinfnet/chars-inf/main/k8s_app.yaml'
        sh "kubectl set image deployment chars chars=${imageName} --record"
        sh "kubectl rollout status deployment/chars"


    }
}