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
        bat "mvn clean package"
      }
          
      //Deploy in SonarQube.
      stage("Code Quality Analysis") {
        withSonarQubeEnv() {
          bat "mvn sonar:sonar"
        }
      }

      // Notify, new build started!
      stage("Build Succeed") {
      }
  
}