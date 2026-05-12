Common Commands
Run a single test class:
mvn test -Dtest=ClassName
Run a specific test method in a class:
mvn test -Dtest=ClassName#methodName
Run multiple specific methods in one class:
mvn test -Dtest=ClassName#method1+method2
Run multiple classes:
mvn test -Dtest=Class1,Class2
Run all tests in a specific package:
mvn test -Dtest="com.example.package.*"

To pass a browser name from the terminal using Maven, you use the -D flag to define a system property. 
mvn test -Dbrowser="chrome"


maven command to run parallel from terminal
mvn test -Dparallel=methods -DthreadCount=10
