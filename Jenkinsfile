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
   	stage("Deploy") {
     	 steps{
              // If you are using Windows then you should use "bat" step
              // Since unit testing is out of the scope we skip them
      bat "mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=2.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-2.0.jar"
                }
            }
stage('Email Notifications'){
                 steps{
                 mail bcc: '', body: '''Hello , 
                A Build has been executed on Your Project Timesheet , if you notice any bugs or abnormal behaviour please contact your team leader
                Best Regards , 
                Bouhmid''', 
                cc: '', from: '', replyTo: '', subject: 'A Build was executed on timesheet', to: 'haifa.ghabri@esprit.tn'
             
                 }
                 } 
        	
    }
}
