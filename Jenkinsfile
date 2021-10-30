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
                     nexusArtifactUploader(
    			nexusVersion: 'nexus3',
   			 protocol: 'http',
   			 nexusUrl: 'localhost:8081',
   			 groupId: 'tn.esprit.spring',
   			 version: 2.0,
   			 repository: 'maven-releases',
    			 credentialsId: 'nexus-user-credentials',
    			 artifacts: [
      		             [artifactId: 'timesheet-ci',
        		      classifier: '',
         		     file: 'target/timesheet-' + version + '.jar',
         	             type: 'jar']
    ]
    }
       
    
}

