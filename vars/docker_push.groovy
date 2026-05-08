def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([uernamePassword(credentialsId: 'docker',
                                   passwordVariable: 'dockerhubpass', 
                                   userVariable: 'dockerhubuser')]) {
    sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
    
