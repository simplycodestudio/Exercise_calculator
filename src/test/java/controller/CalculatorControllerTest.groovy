package controller

import arithmeticOperation.factory.ArithmeticOperationContract
import arithmeticOperation.factory.ArithmeticOperationsInitializer
import arithmeticOperation.factory.ArithmeticsOperations
import calculation_steps.CalculatingStepInitializer
import calculation_steps.CalculatingSteps
import calculation_steps.CalculatingStepsContract
import spock.lang.Specification

class CalculatorControllerTest extends Specification {


    CalculatorController calculator
    Scanner scanner
    ArithmeticOperationsInitializer operationsInitializer = new ArithmeticOperationsInitializer()
    CalculatingStepInitializer calculatingStepInitializer = new CalculatingStepInitializer()
    CalculatingStepsContract calculatingStepsContract

    void setup() {
        scanner = new Scanner(new FileReader("input/initOperators.txt"))
        ArithmeticOperationContract operatorSet = new ArithmeticsOperations(operationsInitializer, scanner)
        operatorSet.readInputFile()
        calculator = new CalculatorController(operatorSet, null)

    }

    def "test should return 15 when loading file number 1"() {

        scanner = new Scanner(new FileReader("input/testFile1.txt"))
        calculatingStepsContract = new CalculatingSteps(calculatingStepInitializer, scanner)

        when:
        calculatingStepsContract.analyzeSteps();
        calculator.setCalculatingSteps(calculatingStepsContract);
        then:
        assert(calculator.startCalculation().equals(15));
    }

    def "test should return 45 when loading file number 2"() {

        scanner = new Scanner(new FileReader("input/testFile2.txt"))
        calculatingStepsContract = new CalculatingSteps(calculatingStepInitializer, scanner)

        when:
        calculatingStepsContract.analyzeSteps();
        calculator.setCalculatingSteps(calculatingStepsContract);
        then:
        assert(calculator.startCalculation().equals(45));
    }

    def "test should return 24 when loading file number 3"() {

        scanner = new Scanner(new FileReader("input/testFile3.txt"))
        calculatingStepsContract = new CalculatingSteps(calculatingStepInitializer, scanner)

        when:
        calculatingStepsContract.analyzeSteps();
        calculator.setCalculatingSteps(calculatingStepsContract);
        then:
        assert(calculator.startCalculation().equals(24));
    }

    def "test should return 120 when loading file number 4"() {

        scanner = new Scanner(new FileReader("input/testFile4.txt"))
        calculatingStepsContract = new CalculatingSteps(calculatingStepInitializer, scanner)

        when:
        calculatingStepsContract.analyzeSteps();
        calculator.setCalculatingSteps(calculatingStepsContract);
        then:
        assert(calculator.startCalculation().equals(45));
    }



//    void cleanup() {
//    }

//    def "SetCalculatingSteps"() {
//    }
//
//    def "StartCalculation"() {
//    }
}
