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


    stage('Jacoco Build'){
      steps{
        step([$class: 'JacocoPublisher', 
                execPattern: 'target/*.exec',
                classPattern: 'target/classes',
                sourcePattern: 'src/main/java',
                exclusionPattern: 'src/test*'
        ])
      }
    }
	
	 stage("Sonar") {
           	steps {
            	   bat "mvn sonar:sonar"
            }
        }
        
    stage("Nexus") {
            steps {
                   bat "mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=5.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-5.0.jar"
                 }
            
        }



    }

    post {
        always {
            mail bcc: '', 
            body: '''Build completed successfully''', cc: '', from: '', replyTo: '', subject: 'Build successfull', to: 'tesnime.ammar@esprit.tn'
        }
    }
    
        
    
}