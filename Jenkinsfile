#!/usr/bin/env groovy 

/* Only keep the 2 most recent builds. */ 
def projectProperties = [
  buildDiscarder(logRotator(numToKeepStr: '2')),
  disableConcurrentBuilds(),
] 

properties(projectProperties) 

node {
  ws("workspace/${env.JOB_NAME}/${env.BRANCH_NAME}") {
    try {

      // Notify, new build started!
      stage("Build Started") {
      }
	  
	    stage("Checkout") {
        checkout scm
      }
	    
      //Prepara el servicio
	    stage("Prepare") {
	  	  def pom = readMavenPom file: 'pom.xml'
		    PROJECT_ARTIFACT_ID = pom.artifactId
		    PROJECT_VERSION = pom.version
	
        def mvnHome = tool 'Maven-3.6.1'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
	    }
      
      //Build project and export jacoco reports.
      stage("Build Project") {
        sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent package"
      }
          
      //Deploy in SonarQube.
      stage("Code Quality Analysis") {
        withSonarQubeEnv(credentialsId: 'sonar') {
          sh "mvn sonar:sonar"
        }
      }

      // Notify, new build started!
      stage("Build Succeed") {
      }

    } catch(err) {
      currentBuild.result = 'FAILURE'
	    throw err
    }
  }
}