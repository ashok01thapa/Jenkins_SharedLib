// Define function
// def call(String ProjectName, String ImageTag, String DockerHubUser){
//   sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
// }


def call(String Project, String ImageTag, String DockerHubUser, String NextPublicHost, String MongoCredId){
    withCredentials([string(credentialsId: MongoCredId, variable: 'MONGODB_URI')]) {
        sh """
            docker build \
                --build-arg NEXT_PUBLIC_HOST=${NextPublicHost} \
                --build-arg MONGODB_URI=\$MONGODB_URI \
                -t ${DockerHubUser}/${Project}:${ImageTag} .
        """
    }
}
