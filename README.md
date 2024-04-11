I) Introduction:
    1. This is a simple application to help users watch some funny videos every day.
Not only users can watch news videos from other people but also they can upload and share their favorite videos.
    2. The purpose is only to build a mini-application, for both FE and BE sites from scratch,
so it has some simple features such as:
        - User can register or log in ( if the username not exist, a system will create a new user from the user's information)
        - Pages will show all videos, that are uploaded and saved from DB ( only text from DB :)) )
        - User can share new videos ( only 'title', not real video, of course :)) )
        - The system will push a notification for all logged-in users to know, that maybe some new video has been uploaded by someone recently

II) Prerequisites: 
    1. JDK (ver 1.8)
    2. MySQL (ver 8.0.27)
    3. Spring Boots (ver 5.2.22 with all : WS, JPA, WS, Websocket, Thymeleft ...)
    4. SockJs-client (ver 1.6.1)
    5. Stomp (ver 2.3.3)
    6. Docker, Docker Compose (ver 20.10.22)
    7. Maven (ver 3.6.3)

III) Installation & Configuration: 
    1. Download and install JDK 1.8
        https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html
    2. Install docker & docker compose
        https://docs.docker.com/engine/install/
    3. Install maven (it should be 3.6.xx version)
        https://maven.apache.org/docs/3.6.3/release-notes.html
    4. Clone project from github: 
        git clone https://github.com/quanghuy192/dev-project.git
    5. Open project by Visual Code, InteliiJ, ... or run terminal from project .../dev-project and run:
        mvn -U clean install (force clean and download all dependencies)
    6. Run docker compose
        docker-compose up -d
    *** Note: Maybe you want to change MySQL infor, you can fell free change it on `docker-compose.yml`, then update it on `application.properties` file, as below:
        spring.datasource.url=jdbc:mysql://localhost:{your_port}/{your_database}?useSSL=false
        spring.datasource.username={your_username}
        spring.datasource.password={your_password}
    7. Run project (Main in DevProjectApplication.java)

IV) Database Setup: 
    We do not need seeding fake data, the seed data will be appended new 10 for users and 20 for movies when we run the application,
we just ensure above step must success (run docker-compose success, the database created success)

V) Running the Application: 
    1. Using Spring Boots with thymeleaf so we just only run Main in DevProjectApplication.java, then we can access the web browser:
        http://localhost:8080/
    2. We only create 3 template:
    -  http://localhost:8080/index : The first page when user need to register or login
    -  http://localhost:8080/register: When user login success or register success
    -  http://localhost:8080/share: When user want to share their video
    -  http://localhost:8080/error: When something error, system will redirect to this page
    ***Note: We can not go direct above url
    3. You can run all test suite as below:
        mvn clean verify
    4. You can run test with 1 class as below:
        mvn test -Dtest="TestClassName"
        ex: mvn test -Dtest="DevProjectApplicationTests"
    5. You can run 1 test case in class as below:
        mvn test -Dtest="TestClassName#TestMethodName"
        ex: mvn test -Dtest="DevProjectApplicationTests#givenUser_whenGetAll_thenStatus200"

VI) (BE/FS) Docker Deployment: 
    Only using docker to run database on local

VII) Usage:
    Everything may not a same when we run in each other OS 
(Everything is OK on Mac OS and Linux, but on Window OS, when should config JAVA_HOME and MAVEN_HOME environment firstly https://phoenixnap.com/kb/install-maven-windows)
    
A brief guide outlining how to use the application, including any specific features or functionality the reviewer should be aware of.

VIII) Troubleshooting:
    1. Maybe you can not download the lib SockJs-client, Stomp fails due to your network (I register on HTML code)
=> You can download the manual and import it to an external library
    2. When you use docker on MacOS M1 (You should append to docker-compose.yml as below: `platform: linux/x86_64`). Otherwise is not needed
