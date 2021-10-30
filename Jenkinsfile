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
                
                    bat "mvn deploy"
                }
            
        }
        
    
}