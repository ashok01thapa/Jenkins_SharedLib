// vars/owasp_dependency_check.groovy
def call() {
    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
        dependencyCheck additionalArguments: "--scan . --format XML --project bitlinks --nvdApiKey ${NVD_API_KEY} --nvdApiDelay 6000",
                         odcInstallation: 'OWASP'
    }
    dependencyCheckPublisher pattern: 'dependency-check-report.xml'
}
