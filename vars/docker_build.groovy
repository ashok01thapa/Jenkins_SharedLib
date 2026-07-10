// Define function
// def call(String ProjectName, String ImageTag, String DockerHubUser){
//   sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
// }


def call(String imageName, String tag, String dockerHubUser, String nextPublicHost, String mongoCredentialsId) {
    withCredentials([string(credentialsId: "${mongoCredentialsId}", variable: 'MONGODB_URI')]) {
        sh """
            docker build \
              --build-arg NEXT_PUBLIC_HOST=${nextPublicHost} \
              --build-arg MONGODB_URI=\$MONGODB_URI \
              -t ${dockerHubUser}/${imageName}:${tag} .
        """
    }
}
