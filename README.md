##Calculator Task: JAVA

##Guidelines:

Write some code to calculate a result from a set of instructions.
Instructions comprise of a keyword and a number that are separated by a space per
line. Instructions are loaded from file and results are output to the screen. Any number
of Instructions can be specified. Instructions can be any binary operators of your choice
(e.g., add, divide, subtract, multiply etc). The instructions will ignore mathematical
precedence. The last instruction should be “apply” and a number (e.g., “apply 3”). The
calculator is then initialised with that number and the previous instructions are applied
to that number.
This project is an implementation of a coding exercise, used in a hiring process. It should give a feedback for interested candidates, how the "nearly ideal" solution should look like.

##Description:


+ Project include Java 1.8 with Maven.

+ The code was implemented when trying to work with the TDD approach.

+ Additional libraries included in the project are:

  - **Spock** for unit Testing
  - **Lombok** to reduce boilerplate
  
+ The code was created using an abstraction layer to increase the level od losely coupling

##Test case
 Code does not have a runtime layer in physical form. 
 Dependencies are merged and run during 9 short unit tests (4 of the tests are physical calculations: CalculatorControllerTest)

Test case no.4:

 **Input:**
```
   add 10
   subtract 5
   multiply 6
   divide 2
   apply 10
```
**Output:**
```
45
```
**Explanation:**

```
10 + (10 - 5) * 6 / 2 = 45
```

##Executing

simply test passing: `mvn test`

The best way for check corectness of implementation is running each test separately.
In case of preferred way of displaying the results, I can create a shell script to print result on screen.

