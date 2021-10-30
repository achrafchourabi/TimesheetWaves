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
                bat "mvn clean install -DskipTests"
            }
        }

	
	 stage("Sonar") {
           	steps {
            	   bat "mvn sonar:sonar"
            }
        }
        
    stage("Nexus") {
            steps {
                   bat "mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=3.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-3.0.jar"
                 }
            
        }
    }

    
        
    
}