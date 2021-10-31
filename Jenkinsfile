pipeline {
    agent any
      
    environment {
        //DockerHub credential
        registry = "anestm/maven-project"
        registryCredential ='docker'
        dockerImage = ''
    }
triggers {
cron ( ' * * * * * ')
}
    stages {

        stage("clone repo") {
            steps {
                script {
                
                    git branch:"anes" , credentialsId: "github", url:'https://github.com/achrafchourabi/TimesheetWaves.git';
                }
            }
        }

        stage("mvn clean") {
            steps {
                script {
               
                    bat "mvn clean"
                }
            }
        }
        
    
        stage("Test stage") {
            steps {
                script {
             
                    bat "mvn test"
                }
            }
        }
    stage("mvn package ") {
            steps {
                script {
            
                    bat "mvn  package "
                }
            }
        }

  	    stage("Sonar ") {
            steps {
                script {
                  
                    bat "mvn sonar:sonar "
                     }
                }
            } 
           
        stage("Deployment stage") {
            steps {
                script {
                 pom = readMavenPom file: "pom.xml";
                   echo "${pom.artifactId}-${pom.version}.${pom.packaging}"
                   bat "mvn deploy:deploy-file -DgroupId=${pom.groupId} -DartifactId=${pom.artifactId} -Dversion=${pom.version}  -DgeneratePom=true -Dpackaging=${pom.packaging}  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/${pom.artifactId}-${pom.version}.${pom.packaging}"
                }
            }
        }
     stage('Building docker image') {
          steps{
               script {
                 // this step build docker image 
                 docker.build registry + ":$BUILD_NUMBER"
                }
         }    
        }
       stage('Deploy Image to Dockerhub') {
         steps{
           script {
                 // this step push the docker image builded to dockerhub
                 docker.withRegistry( '', registryCredential ) {	
	         bat "docker push $registry:$BUILD_NUMBER"
                 }
          }
        }
      }

        stage('Remove Unused docker image') {
          steps{
                // this step delete the image to cleanup your server space after build and deploy
	        bat "docker rmi $registry:$BUILD_NUMBER"
            }
        }
          
    }
    
      post {  
      
         success {  
         mail bcc: '', body: '''success Jenkins pipline .
             Jenkins.''', cc: '', from: '', replyTo: '', subject: 'Build succed', to: 'anestemani00@gmail.com'   
         }  
         failure {  
             mail bcc: '', body: '''failed Jenkins pipline .
             Jenkins.''', cc: '', from: '', replyTo: '', subject: 'Build failed', to: 'anestemani00@gmail.com'   
         } 
             always {
            cleanWs()
        }
      }
}