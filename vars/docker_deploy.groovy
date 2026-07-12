// vars/docker_deploy.groovy
def call(String imageName, String tag, String composeFile) {
    withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            export IMAGE_NAME=${imageName}
            export IMAGE_TAG=${tag}
            docker compose -f ${composeFile} pull
            docker compose -f ${composeFile} up -d
        """
    }
}
