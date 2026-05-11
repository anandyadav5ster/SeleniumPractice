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


Q) public static void main(String[] args)
public-->access specifier
public makes it globally available. It is made public so that JVM can invoke it from outside the class as it is not present in the current class.
static --keyword.
The main() method is static so that JVM can invoke it without instantiating the class.
void --return type
It is a keyword and is used to specify that a method doesn’t return anything. As the main() method doesn’t return anything, its return type is void
main-->method name.
it is the name of the Java main method. It is the identifier that the JVM looks for as the starting point of the Java program
String[] -->Arrays of string type.
It stores Java command-line arguments and is an array of type java.lang.String class



Q)System.out.println()
System: It is a final class defined in the java.lang package.
out: This is an instance of PrintStream type, which is a public and static member field of the System class.
println(): As all instances of the PrintStream class have a public method println()

====================================================================================
Difference between StringBuffer and StringBuilder
Java provides three classes to represent a sequence of characters: String, StringBuffer, and StringBuilder. The String class is an immutable class whereas StringBuffer and StringBuilder classes are mutable.
--->StringBuffer is synchronized i.e. thread safe. It means two threads can't call the methods of StringBuffer simultaneously.
-->StringBuilder is non-synchronized i.e. not thread safe. It means two threads can call the methods of StringBuilder simultaneously.
-->StringBuffer is less efficient than StringBuilder.
-->StringBuilder is more efficient than StringBuffer.
-->StringBuffer was introduced in Java 1.0
-->StringBuilder was introduced in Java 1.5


Exception is selenium
1. ElementNotSelectableException
2. ElementNotInteractableException
3. ElementNotVisibleException
4. NoSuchElementException
5. NoSuchFrameException
6. NoSuchWindowException
7. NoAlertPresentException
8. SessionNotFoundException
9. StaleElementReferenceException
10. TimeOutException
11. WebDriverException 
12. InvalidSelectorException(When the xpath syntax is wrong)

--->Difference between interface and Astract class
Astract class--
1. Abstract class cannot be intantiated.
2. Abstract class contains both abstract and not abstarct method.
3. Abstact methods have only declaration no implmentation.
4. Abstract class have modifiers as public, protected and private.
5. Abstract class have member variables.
6. Abstract class can have final, non-final and static variables.
7. Abstrat class using extends keyword.

Interface:
1. It a contract where all  methods must implement.
2. All methods in interface have abstract and must be implemented by any class that implement the interface.
3. interface can have only public access.
4. Interface cannnot have member variables.
5. Only final and static variables.
6. Implement using implements keyword
7. Multiple inheritance can be achive using interface, but not with abstrat class.


Q) Where you will use HashMap and HashTable
HashMap implements map interface and store the value in key and value.
it contains unique values.
it can contains one null key and multiple null values.
it maintains no order.
if we applied same key , than latest key value will be added.

Hashtable class is synchronized, which can result in slower performance compared to other implementations of the Map interface.

HashSet: 
1)implements set interface.
2. No duplicate value allowed.
3. maintain no insertion order.
4. one null element is allowed in hashset.
5. HashSet also implements Serializable and Cloneable interfaces.



Q) Constructor chaning

Q) What it is the difference between Action and Actions class.
Action:
In Selenium, Action is an interface representing 1 user-interaction. It only has 1 method and that method is perform. The Actions class has a lot of methods like build, dragAndDrop, dragAndDropBy, keyDown, keyUp, moveToElement, and it also has perform. 

Q) What is framework ?
Framework is a set of rules, guideline and best practices that are followed to get the desired result.
-->should suport more than one brower
-->should support multiple platform.
-->should run on multple programming language.
--> Efficent handling of test data.


    
   ============== Concepts of OOPS in Selenium Automation Framework=====================
   Concepts of OOPS in Selenium Automation Framework
#1. ABSTRACTION
#2. INTERFACE
#3. INHERITANCE
#4. POLYMORPHISM
#1. METHOD OVERLOADING
#2. METHOD OVERRIDING
#5. ENCAPSULATION
Other Selenium Automation Framework Concepts
#1. WEB ELEMENT
#2. WEBDRIVER
#3. FIND BY
#4. FIND ELEMENT

#1. ABSTRACTION
Abstraction is the methodology of hiding the implementation of internal details and showing the functionality to the users.
In Page Object Model design pattern, we write locators (such as id, name, xpath etc.,) and the methods in a Page Class. We utilize these locators in tests but we can’t see the implementation of the methods. Literally we hide the implementations of the locators from the tests.

#2. INTERFACE
In Java, abstraction is achieved by interfaces and abstract classes. Using interfaces, we can achieve 100% abstraction.
Selenium is WebDriver driver = new FirefoxDriver();
WebDriver itself is an Interface. So based on the above statement WebDriver driver = new FirefoxDriver(); 
It means we are creating a reference variable (driver) of the interface (WebDriver) and creating an Object.
Here WebDriver is an Interface as mentioned earlier and FirefoxDriver is a class.

#3. INHERITANCE
The mechanism in Java by which one class acquires the properties (instance variables) and functionalities of another class is known as Inheritance.
We create a Base Class in the Automation Framework to initialize WebDriver interface, WebDriver waits, Property files, Excels, etc., in the Base Class.
We extend the Base Class in other classes such as Tests and Utility Class.

#4. POLYMORPHISM
Polymorphism allows us to perform a task in multiple ways.
Combination of overloading and overriding is known as Polymorphism. We will see both overloading and overriding below.

#1. METHOD OVERLOADING
We use Implicit wait in Selenium. Implicit wait is an example of overloading. In Implicit wait we use different time stamps such as SECONDS, MINUTES, HOURS etc.,

Action class in TestNG is also an example of overloading.
In simple words, actions class in selenium are used to perform multiple actions at the same time. For example, double-click, right-click, moving a mouse, drag & drop, etc.

Assert class in TestNG is also an example of overloading
Assert.assertEqual(String actual, String expected): 
Assert.assertEqual(String actual, String expected, String message):
Assert.assertEquals(boolean actual, boolean expected): 
Assert.assertTrue(condition): 
Assert.assertTrue(condition, message): 
Assert.assertFalse(condition): 
Assert.assertFalse(condition, message): 

#2. METHOD OVERRIDING
Declaring a method in child class which is already present in the parent class is called Method Overriding. Examples are get and navigate methods of different drivers in Selenium

#5. ENCAPSULATION
All the classes in a framework are an example of Encapsulation. In POM classes, we declare the data members using @FindBy and initialization of data members will be done using Constructor to utilize those in methods.

Encapsulation is a mechanism of binding code and data (variables) together in a single unit.


@DataProvider(name="data-provider")
public object[][] dpMethod()
{
	return new object[][]
	{
		"first-value",
		"second-value"
	}
}

@Test(dataProvider="dataProvider")
{
	public void MyTest(String val)
	{
		System.out.println(val)
	}
}
=======================

@Factory
public object[] myFactory()
{
	return new Object[]{
		new TestCase("K1"),
		new TestCase("k2")
	}
}
================

runtest cases parallaly

<suite name ="MyTestSuite" parallal="methods" thread-count="5">

==========================Read Excel file using fillo ======
@Test
	public static void read_excel_file()
	{
		String query = "select * from sheet1 where age=33";
		String filepath = "./TestData/data.xlsx";
		Fillo fillo = new Fillo();
		try {
			Connection connection = fillo.getConnection(filepath);
			Recordset recordset = connection.executeQuery(query);
			
			while(recordset.next()) {
				System.out.println(recordset.getField("ID")+" "+recordset.getField("FirstName")+" "+
						recordset.getField("LastName")+" "+recordset.getField("Age"));
			}
			connection.close();
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        How To Run Failed Test Cases Using TestNG In Selenium WebDriver
        Ans : IRetryAnalyzer
        
        ============================
        TestNG skip the test cases
        by using
@Test(enable=false)

----->Grouing the test cases
@Test(groups={"smoke","sanity"})
<suite name = "MytestSuite">
<test name ="Mytest">
<groups>
<run>
    <include name = "smoke"/>
    </run>
   </groups> 
   <classes>
   <class name ="Mytestclass"/>
   </classes>
   </test>
   </suite>
   
   ===============================
   preserve-order 
   If you want the classes and methods listed in this file to be run in an unpredictable order, set the preserve-order attribute to false,
   In TestNg bydefault the preserve-order attribute will be set to 'true', this means, TestNG will run your tests in the order they are found in the XML file.
   
   ==================================
   exclude tag
   TestNG is a testing framework and can use Maven as build tool. It helps to maintain dependencies and their version at one place in pom.xml

Maven provides flexibility to include or exclude a test group at run time. User can exclude test group or groups at run time in maven using surefire plugin.

In this tutorial, we will illustrate how to exclude a test group via surefire at runtime.

========================Cross browser testing================
Handle color in selenium webdriver
WebElement eleSearch = driver.findElement(By.xpath("//*[@class='navsearchbar']//div[2]//div"));

String rgbFormat = eleSearch.getCssValue("background-color");

System.out.println(rgbFormat);  

=================================================
Explain how you can use recovery scenario with Selenium?
By using the try,catch block we can recover the recovery scenario.
=============================================================
 List out the technical challenges with Selenium?
Technical challenges with Selenium are

Selenium supports only web based applications
It does not support the Bitmap comparison
For any reporting related capabilities have to depend on third party tools
No vendor support for tool compared to commercial tools like HP UFT
As there is no object repository concept in Selenium, maintainability of objects becomes difficult