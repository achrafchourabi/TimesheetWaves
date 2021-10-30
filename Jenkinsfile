pipeline {

    agent any


    stages {
    //   stage ('GIT') {
     //       steps {
      //         echo "Getting Project from Git"; 
       //        git branch:"tesnimeammar", url : "https://github.com/achrafchourabi/TimesheetWaves.git"; 
       //     }
        //}

      	 stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean install "
            }
        }

	
	 stage("Sonar") {
           	steps {
            	   bat "mvn sonar:sonar"
            }
        }
        
    }

    stage("Nexus") {
            steps {
                script {
                    // If you are using Windows then you should use "bat" step
                    // Since unit testing is out of the scope we skip them
                    bat "mvn deploy"
                }
            }
        }
        
    
}