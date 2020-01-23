### Steps to clone and run the test.
- git clone https://github.com/harshjhunjhunwala/AutomationPracticeTestForPlanit.git
- Navigate to config.properties file located at https://github.com/harshjhunjhunwala/AutomationPracticeTestForPlanit/tree/master/PlanitTest/src/main/java/com/automationpractice/config
  Update the username and password of your choice ( Since test@test.com is already used )
- cd PlanitTest
- mvn clean test

###Overview of test scenarios
#1. send message to customer service
- navigate to contact us page
- Fill the email, message and submit
- Validate the success message

#2. registerNewUserAndPerformValidations
- navigate to sign in page to move to authenticated page
- Click on create an account button to validate error message ,since email id was not provided
- Register new email Id
- Validate mandatory fields of registration page
- Register new user
- Validate My account page loaded
- Signout 

#3. loginWithNewUser
- navigate to sign in page to move to authenticated page
- login with new user
- Validate my account page loaded

#4. addItemToCartAndValidateTheRightItem and Remove the Item
- navigate to sign in page to move to authenticated page
- login with new user
- back to home page
- add one item to cart
- proceed to checkout
- validate product in summary page
- Remove the item 
- Validate no item is added

### Ouput would be something like this
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.automationpractice.testcases.HomePageTest
Configuring TestNG with: org.apache.maven.surefire.testng.conf.TestNG652Configurator@dcf3e99
Starting ChromeDriver 79.0.3945.36 (3582db32b33893869b8c1339e8f4d9ed1816f143-refs/branch-heads/3945@{#614}) on port 27852
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
[1579792544.859][WARNING]: Timed out connecting to Chrome, retrying...
Jan 23, 2020 3:15:47 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
[1579792549.177][WARNING]: Timed out connecting to Chrome, retrying...
Starting ChromeDriver 79.0.3945.36 (3582db32b33893869b8c1339e8f4d9ed1816f143-refs/branch-heads/3945@{#614}) on port 31047
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
[1579792574.832][WARNING]: Timed out connecting to Chrome, retrying...
Jan 23, 2020 3:16:16 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
[1579792578.892][WARNING]: Timed out connecting to Chrome, retrying...
Starting ChromeDriver 79.0.3945.36 (3582db32b33893869b8c1339e8f4d9ed1816f143-refs/branch-heads/3945@{#614}) on port 23076
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
[1579792614.879][WARNING]: Timed out connecting to Chrome, retrying...
Jan 23, 2020 3:16:56 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
[1579792618.907][WARNING]: Timed out connecting to Chrome, retrying...
Starting ChromeDriver 79.0.3945.36 (3582db32b33893869b8c1339e8f4d9ed1816f143-refs/branch-heads/3945@{#614}) on port 34048
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
[1579792648.419][WARNING]: Timed out connecting to Chrome, retrying...
Jan 23, 2020 3:17:30 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
[1579792652.583][WARNING]: Timed out connecting to Chrome, retrying...
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 146.845 sec

Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 02:40 min
[INFO] Finished at: 2020-01-23T15:18:03Z
[INFO] Final Memory: 20M/264M
[INFO] ------------------------------------------------------------------------




### Snapshot and video uploaded of automation results
- In the name of Snapshot of all test scenarios https://github.com/harshjhunjhunwala/AutomationPracticeTestForPlanit/tree/master/Automation%20Results
- Video captured (Video of automation scenarios.MOV) - https://github.com/harshjhunjhunwala/AutomationPracticeTestForPlanit/tree/master/Automation%20Results


### More things which can be achieved...
There is so much more which can be done as part of the automation.
1. Till the whole payment can be validated, Items can be searched ,to summarize all of the functionalities which are visible can be played around with it...
2. Different suites can be designed with using testNg - smoke , regression or environment specifics too...
3. Logging can be added....
4. Screenshots can be taken for things to be validated...
5. Reports can be generated in html formats with some external libraries.....
6. Add more validations and terminate them properly when required !
7. Send data dynamically more from text file instead of hardcoding them !
8. Waiting can be added to specific files...
