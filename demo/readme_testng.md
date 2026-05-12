1. TestNG Execution Order
TestNG has the most granular lifecycle. If all annotations are present in a single class, they execute in this specific sequence: 

LinkedIn
·Ayushi Malviya
 +3
@BeforeSuite: Runs once before all tests in the entire suite.
@BeforeTest: Runs once before any <test> tag defined in the XML file.
@BeforeClass: Runs once before the first test method in the current class.
@BeforeMethod: Runs before each @Test method.
@Test: The actual test logic.
@AfterMethod: Runs after each @Test method.
@AfterClass: Runs after all test methods in the current class are finished.
@AfterTest: Runs after all test methods inside the XML <test> tag have finished.
@AfterSuite: Runs once after all tests in the suite have completed.

STCM-T-MCTS

TestNG priority
Priority determines the sequence in which test methods run. Lower numbers (including negatives) execute first.
Default Priority: If no priority is set, it defaults to 0.
Tie-breaking: If two tests have the same priority, TestNG runs them alphabetically by method name.
public class PriorityExample {
    @Test(priority = -1)
    public void setupEnv() { /* Runs first */ }

    @Test(priority = 0)
    public void login() { /* Runs second */ }

    @Test(priority = 1)
    public void checkout() { /* Runs third */ }
}

2. Grouping Test Cases
Groups allow you to categorize tests (e.g., "Smoke", "Regression") so you can run specific subsets of your suite.
java
public class GroupExample {
    @Test(groups = {"smoke", "regression"})
    public void testLogin() { ... }

    @Test(groups = {"regression"})
    public void testProfileUpdate() { ... }

    @Test(groups = {"smoke"})
    public void testLogout() { ... }
}

3. Combining Priority and Groups
You can use both together to ensure your grouped tests run in a specific order:
java
@Test(priority = 1, groups = "smoke")
public void validateHomePage() { ... }

4. How to Run Specific Groups
To execute only specific groups from the terminal using Maven, use the following command:
bash
mvn test -Dgroups="smoke"
Use code with caution.
To run multiple groups, use a comma-separated list: -Dgroups="smoke,regression"
Crucial Note on Parallelism: If you run tests in parallel (as we discussed earlier), the priority attribute is respected within the same thread, but may not guarantee strict order across different threads.

Basic Group Filtering
You use the <groups> and <run> tags to specify which groups should be executed or ignored
<test name="Selective Group Run">
    <groups>
        <run>
            <include name="smoke" />
            <exclude name="broken" />
        </run>
    </groups>
    <classes>
        <class name="com.example.LoginTests" />
    </classes>
</test>

Managing Execution Order
To control order across classes, use preserve-order="true" within the <test> tag.
<suite name="Suite">
    <test name="Smoke" preserve-order="true">
        <groups><run><include name="smoke"/></run></groups>
        <classes><class name="com.example.Tests"/></classes>
    </test>
    <test name="Regression">
        <groups><run><exclude name="broken"/></run></groups>
        <classes><class name="com.example.Tests"/></classes>
    </test>
</suite>
===============================






