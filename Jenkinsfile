#!/usr/bin/env groovy 

node {
      // Notify, new build started!
      stage("Build Started") {
      }
	  
	    stage("Checkout") {
        checkout scm
      }
      
      //Build project and export jacoco reports.
      stage("Build Project") {
        sh "mvn clean package"
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