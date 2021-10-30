pipeline {

    agent any


    stages {
    //   stage ('GIT') {
     //       steps {
      //         echo "Getting Project from Git"; 
       //        git branch:"ghofrane",
                 url : "https://github.com/achrafchourabi/TimesheetWaves.git"; 
       //     }
        //}

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
    }
       
    
}