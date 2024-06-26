I) Introduction: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    1. This is a simple application to help users watch some funny videos every day.
Not only users can watch news videos from other people but also they can upload and share their favorite videos. <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    2. The purpose is only to build a mini-application, for both FE and BE sites from scratch,
so it has some simple features such as: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- User can register or log in ( if the username not exist, a system will create a new user from the user's information) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Pages will show all videos, that are uploaded and saved from DB ( only text from DB :)) ) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- User can share new videos ( only 'title', not real video, of course :)) ) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- The system will push a notification for all logged-in users to know, that maybe some new video has been uploaded by someone recently <br>

II) Prerequisites:  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    1. JDK (ver 1.8) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    2. MySQL (ver 8.0.27) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    3. Spring Boots (ver 5.2.22 with all : WS, JPA, WS, Websocket, Thymeleft ...) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    4. SockJs-client (ver 1.6.1) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    5. Stomp (ver 2.3.3) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    6. Docker, Docker Compose (ver 20.10.22) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    7. Maven (ver 3.6.3) <br>

III) Installation & Configuration:  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    1. Download and install JDK 1.8 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    2. Install docker & docker compose <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    https://docs.docker.com/engine/install/ <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    3. Install maven (it should be 3.6.xx version) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    https://maven.apache.org/docs/3.6.3/release-notes.html <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    4. Clone project from github:  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    git clone https://github.com/quanghuy192/dev-project.git <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    5. Open project by Visual Code, InteliiJ, ... or run terminal from project .../dev-project and run: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    mvn -U clean install (force clean and download all dependencies) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    6. Run docker compose <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    docker-compose up -d <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    *** Note: Maybe you want to change MySQL infor, you can fell free change it on `docker-compose.yml`, then update it on `application.properties` file, as below: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    spring.datasource.url=jdbc:mysql://localhost:{your_port}/{your_database}?useSSL=false <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    spring.datasource.username={your_username} <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    spring.datasource.password={your_password} <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    7. Run project (Main in DevProjectApplication.java) <br>

IV) Database Setup:  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    1. We do not need seeding fake data, the seed data will be appended new 10 for users and 20 for movies when we run the application,
we just ensure above step must success (run docker-compose success, the database created success) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    2. We have 2 master user, as below: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    - name1/pass123@1 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    - name2/pass123@2 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    Otherwise, connect DB to see more <br>

V) Running the Application:  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    1. Using Spring Boots with thymeleaf so we just only run Main in DevProjectApplication.java, then we can access the web browser: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    http://localhost:8080/ <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    2. We only create 3 template: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    -  http://localhost:8080/index : The first page when user need to register or login <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    -  http://localhost:8080/register: When user login success or register success <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    -  http://localhost:8080/share: When user want to share their video <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    -  http://localhost:8080/error: When something error, system will redirect to this page <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    ***Note: We can not go direct above url <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    3. You can run all test suite as below: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    mvn clean verify <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    4. You can run test with 1 class as below: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    mvn test -Dtest="TestClassName" <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    ex: mvn test -Dtest="DevProjectApplicationTests" <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    5. You can run 1 test case in class as below: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    mvn test -Dtest="TestClassName#TestMethodName" <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    ex: mvn test -Dtest="DevProjectApplicationTests#givenUser_whenGetAll_thenStatus200" <br>

VI) (BE/FS) Docker Deployment:  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    Only using docker to run database on local <br>

VII) Usage: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    Everything may not a same when we run in each other OS  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    (Everything is OK on Mac OS and Linux, but on Window OS, when should config JAVA_HOME and MAVEN_HOME environment firstly https://phoenixnap.com/kb/install-maven-windows) <br>

VIII) Troubleshooting: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    1. Maybe you can not download the lib SockJs-client, Stomp fails due to your network (I register on HTML code) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    => You can download the manual and import it to an external library <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    2. When you use docker on MacOS M1 (You should append to docker-compose.yml as below: `platform: linux/x86_64`). Otherwise is not needed <br>
