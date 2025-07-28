# Jenkins Pipeline for Transaction API

This repository includes a Jenkins Pipeline (`Jenkinsfile`) that automates the CI process for the **Transaction API** project. It performs static code analysis, security vulnerability scanning, and Docker image creation.

Pipeline Overview

The pipeline contains the following key stages:

SonarQube Analysis

- Purpose: Performs static code analysis using SonarQube to identify code smells, bugs, and vulnerabilities.
- **Tools Required:** 
  - SonarQube server (`sonar`) configured in Jenkins.
  - Sonar Scanner tool installed on the Jenkins node (named `sonar` in Jenkins Global Tools).

OWASP Dependency-Check

- Purpose: Scans for known vulnerabilities in project dependencies using the OWASP Dependency-Check plugin.
- Uses the dependency-check tool (configured as OWASP Dependency-Check in Jenkins).
- Publishes the report using dependencyCheckPublisher.


Complete the pipeline by packaging the application with Docker.
