pipeline {

    agent any


    stages {
    //   stage ('GIT') {
     //       steps {
      //         echo "Getting Project from Git"; 
       //        git branch:"Haifa", url : "https://github.com/achrafchourabi/TimesheetWaves.git"; 
       //     }
        //}

       stage("Build") {
           steps {
                bat "mvn -version"
                bat "mvn clean install -DskipTests"
            }
        }
       stage("Sonar") {
        steps {
           bat "mvn sonar:sonar"
         }
       }
     stage('uploading to nexus'){
                 steps{
                     nexusArtifactUploader artifacts: [
                        [artifactId: 'timesheet-ci',
                        classifier: '', 
                        file: 'target/timesheet-ci-2.0.jar', 
                        type: 'jar']], credentialsId: 'nexus-user-credentials', groupId: 'tn.esprit.spring', 
                        nexusUrl: 'localhost:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'maven-releases', 
			repositoryId=deploymentRepo,
                        version: '2.0'
                 }
             } 
    }
       
    
}

