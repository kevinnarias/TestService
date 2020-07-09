#!/usr/bin/env groovy 

/* Only keep the 2 most recent builds. */ 
def projectProperties = [
  buildDiscarder(logRotator(numToKeepStr: '2')),
  disableConcurrentBuilds(),
] 

properties(projectProperties) 

node {
      // Notify, new build started!
      stage("Build Started") {
      }
	  
	    stage("Checkout") {
        checkout scm
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

  
}