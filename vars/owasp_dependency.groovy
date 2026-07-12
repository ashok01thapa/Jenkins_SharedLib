def call() {
    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
        withEnv(["JAVA_OPTS=-Xmx512m"]) {
            dependencyCheck additionalArguments: '--scan . --format XML --project bitlinks --nvdApiKey ' + NVD_API_KEY + ' --nvdApiDelay 6000 --data /home/ubuntu/.dependency-check-data',
                             odcInstallation: 'OWASP'
        }
    }
    dependencyCheckPublisher pattern: 'dependency-check-report.xml'
}
