# CBHackathon

---------------------------------------
Pre-Requisites to run the test suite
-------------------------------------------

   1. Apache Maven version 3.6.0 and above
		- Install maven 3.6.0 and set environment variable MAVEN_HOME='installed path' and Path = %MAVEN_HOME%\bin
	
   2. JDK version 8 update 221 and above
		- Install JDK 8u221 version and set environment variable JAVA_HOME='installed path' and Path = %JAVA_HOME%\bin
	
   3. GIT
   		- Repository: https://github.com/himanshusoni30/CBHackathon.git		
		- clone git repository on your system
		
   4. Browser:
		- Google Chrome Version 83.0.4103.106 (Official Build) (64-bit) as ChromeDriver version 83.0.4103.39 is used in test suite.
		- Mozilla Firefox Version 77.0.1 (64-bit) as GeckoDriver v0.26.0 is used in test suite.
		- Microsoft Edge Version 83.0.478.50 (Official build) (64-bit) as MSEdgeDriver Version 83.0.478.44 is used in test suite.

	
---------------------------------------
Steps to run test suite.
---------------------------------------
   - Launch command prompt
   - Go to the path where git repository is cloned
   - Check that pom.xml and testng.xml files are present in the path
   - run 'mvn clean test -Dsurefire.suiteXmlFiles=testng.xml' command

---------------------------------------
Applitools Test URL.
---------------------------------------
   - XXXXXXXXX
