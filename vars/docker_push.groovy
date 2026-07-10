// def call(String Project, String ImageTag, String dockerhubUser){
//     withCredentials([usernamePassword(credentialsId: 'docker',
//                                      passwordVariable: 'DOCKER_PASS',
//                                      usernameVariable: 'DOCKER_USER')]) {
//         sh """
//             docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}
//             docker push ${dockerhubUser}/${Project}:${ImageTag}
//         """
//     }
// }

def call(String Project, String ImageTag, String dockerhubUser){
    withCredentials([usernamePassword(credentialsId: 'docker',
                                     passwordVariable: 'DOCKER_PASS',
                                     usernameVariable: 'DOCKER_USER')]) {
        sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
    }
    sh "docker push ${dockerhubUser}/${Project}:${ImageTag}"
}
