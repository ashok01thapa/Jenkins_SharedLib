def call(String Project, String ImageTag, String dockerhubUser){
  withCredentials([usernamePassword(credentialsId: 'docker',
                                   passwordVariable: 'dockerhubPass', 
                                   userVariable: 'dockerhubUser')]) {
    sh "docker login -u ${dockerhubUser} -p ${dockerhubPass}"
  sh "docker push ${dockerhubUser}/${Project}:${ImageTag}"
  }
}
    
