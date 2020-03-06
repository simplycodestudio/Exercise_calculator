package arithmeticOperation.factory

import arithmeticOperation.AddOperation
import arithmeticOperation.ArithmeticOperation
import arithmeticOperation.DivideOperation
import arithmeticOperation.MultiplyOperation
import arithmeticOperation.SubtractOperation
import spock.lang.Shared
import spock.lang.Specification

class ArithmeticsOperationsTest extends Specification {

    @Shared
    Scanner scanner
    ArithmeticOperationsInitializer factory
    ArithmeticOperationContract operationContract

    def "Test should return true when key #key of map agrees with its object names #object"() {

        scanner = new Scanner(new FileReader("input/initOperators.txt"))
        factory = new ArithmeticOperationsInitializer()
        operationContract = new ArithmeticsOperations(factory, scanner)
        operationContract.readInputFile()
        Map<String, ArithmeticOperation> map = operationContract.getOperators()

        when:
        boolean addOperation=  map.get("add") instanceof AddOperation
        boolean divideOperation =  map.get("divide") instanceof DivideOperation
        boolean multiplyOperation =  map.get("multiply") instanceof MultiplyOperation
        boolean substractOperation =  map.get("subtract") instanceof SubtractOperation
        def instances = new ArrayList<Boolean>()
        instances.addAll(addOperation,divideOperation,multiplyOperation,substractOperation)

        then:
        for(Boolean instance: instances){
            assert instance
        }
    }

    def "Test should assertTrue when assumpt that empty file of math operands returns map of null operands"()
    {
        when:
        scanner = new Scanner(new FileReader("input/emptyfile.txt"))
        factory = new ArithmeticOperationsInitializer()
        operationContract = new ArithmeticsOperations(factory, scanner)
        operationContract.readInputFile()
        Map<String, ArithmeticOperation> map = operationContract.getOperators()

        then:
        assert(map.isEmpty())
    }

    def "Test should throws exception when operations in given file has wrong form"()
    {
        when:
        scanner = new Scanner(new FileReader("input/wrongPipeline.txt"))
        factory = new ArithmeticOperationsInitializer()
        operationContract = new ArithmeticsOperations(factory, scanner)
        operationContract.readInputFile()

        then:
        thrown(ClassNotFoundException)
    }

}
