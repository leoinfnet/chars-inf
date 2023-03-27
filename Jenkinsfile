node {
    checkout scm

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
    withMaven {
          maven: 'mvn'
          sh "mvn clean package"
        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
      }




    stage "Push"

        customImage.push()


    stage "Deploy PROD"

        //input "Deploy to PROD?"
        //customImage.push('latest')
        //sh "kubectl set image deployment jenkins jenkins=${imageName} --record"
}