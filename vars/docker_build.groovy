// Define function
def call(String ProjectName, String ImageTag, StringDockerHubUser){
  sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
}
