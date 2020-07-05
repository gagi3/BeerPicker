# BeerPicker
Rule-based expert system that recommends beer based on food.

### Demo



### Running the app

#### Requirements:

1. JDK (https://www.oracle.com/java/technologies/javase-jdk11-downloads.html#license-lightbox)
2. Maven (https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)
3. Node.js i NPM (https://nodejs.org/download/release/v10.15.1/)
4. Cloned repository

It is important to add JDK, Maven, Node.js to Environment/Path Variables.

#### Running:

##### Back end

1. Open Command Prompt/Terminal/Powershell
2. Change directory to `/server` (inside the cloned project directory)
3. Type `mvn spring-boot:run` and press Enter - alternatively, double-click RUN.bat

If you are using an IDE, it is important to install the lombok plugin and enable annotation preprocessing.

##### Front end

1. Open a new Command Prompt/Terminal/Powershell instance
2. Change directory to `/client` (inside the cloned project directory)
3. Type `npm install` and press Enter - alternatively, double-click INSTALL.bat
4. Once the command finishes execution, type `npm start` and press Enter - alternatively, double-click RUN.bat
