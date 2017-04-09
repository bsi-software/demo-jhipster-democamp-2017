JHipster IDE Presentation
=========================

The ten steps to get a JHipster project up and running:

1. Installation:
	- [Install JHipster](https://jhipster.github.io/installation/)
	- [Download](http://www.eclipse.org/downloads/) and install an Eclipse distro (we suggest to use Eclipse IDE for Java Developers)
	- [Install JHipster IDE from Eclipse Marketplace](https://marketplace.eclipse.org/content/jhipster-ide)
	- [Install Eclipse Terminal (TM) feature from Eclipse Marketplace](https://marketplace.eclipse.org/content/tm-terminal)
	
2. Create a new JDL project 

3. Open the `src/model/Model.jdl` file and replace the last part with the following snippet:
---
	paginate JobHistory, Employee with infinite-scroll
	paginate Job with pagination
	dto * with mapstruct
	service * with serviceClass
	microservice * with mymicroservice
---
	
4. Start a terminal shell in the top folder of your Eclipse project and execute the following lines:

   `$ yo jhipster`</br>
   `$ ./mvnw clean install` 
	
5. Import JDL model and generate artifacts:

   `$ yo jhipster:import-jdl src/model/Model.jdl`

6. Refresh project in Eclipse and convert it to a maven project (right click on project name -> Configure -> Convert to Maven Project)

7. Change project settings (src and output folders)

8. Build again with `./mvnw clean install -Pdev` or run the app by just call `./mvnw`

9. Copy `*.war` from output (target) folder to `src/main/docker` and build a docker image

10. Run image from Xdocker Image Browser & open app from Xdocker Container Browser View
