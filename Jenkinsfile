node {

    checkout scm

    // Pega o commit id para ser usado de tag (versionamento) na imagem
    sh "git rev-parse --short HEAD > commit-id"
    tag = readFile('commit-id').replace("\n", "").replace("\r", "")

    // configura o nome da aplicação, o endereço do repositório e o nome da imagem com a versão
    appName = "chars-inf"
    registryHost = "127.0.0.1:30400/"
    imageName = "${registryHost}${appName}:${tag}"
    print(imageName)
    // Configuramos os estágios

    stage "Build"
        sh 'mvn -B -DskipTests clean package'
        //def customImage = docker.build("${imageName}")


    stage "Push"

        //customImage.push()
}
