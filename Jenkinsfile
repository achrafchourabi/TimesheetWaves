pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
               git branch:"ghofrane", url:"https://github.com/achrafchourabi/TimesheetWaves.git"; 
            }
        }

       stage("Build") {
           steps {
                bat "mvn -version"
                bat "mvn clean install"
            }
            
        }
       stage("Sonar") {
        steps {
           bat "mvn sonar:sonar"
         }
       }
       stage("nexus") {
        steps {
           bat "mvn deploy -Dmaven.test.skip"
         }
       }
       stage("mail sending") {
        steps {
            mail bcc: '', body: 'pipeline terminé avec succès !!!!! ', subject: 'pipeline ', to: 'ghofrane043@gmail.com'
         }
       }
       
   }  
   
}