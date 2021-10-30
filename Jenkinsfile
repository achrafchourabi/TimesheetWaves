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
   
     stage("mail") {
          steps {
          mail bcc: '', body: '''Hello User the build of your project successed.
            Jenkins.''', cc: '', from: '', replyTo: '', subject: 'Build succed', to: 'haifa.ghabri@esprit.tn'
          }	
       }
    
}
