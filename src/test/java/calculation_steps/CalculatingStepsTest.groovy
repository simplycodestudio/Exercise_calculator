package calculation_steps


import spock.lang.Shared
import spock.lang.Specification

class CalculatingStepsTest extends Specification {
    @Shared
    Scanner scanner
    CalculatingStepInitializer calculatingStepInitializer
    CalculatingStepsContract calculatingStepsInterface

    void setup() {
        this.calculatingStepInitializer = new CalculatingStepInitializer()
    }

    def "check if instruction is matching when appropriate file passed"()
    {
        scanner = new Scanner(new FileReader("input/initPipeline.txt"))
        calculatingStepsInterface = new CalculatingSteps(calculatingStepInitializer, scanner)
        calculatingStepsInterface.analyzeSteps()
        when:
        List<Step> steps = calculatingStepsInterface.getInstructions()

        then:
        assert "add".equals(steps.get(0).getOperator())
        assert "multiply".equals(steps.get(1).getOperator())
        assert "divide".equals(steps.get(2).getOperator())
        assert "subtract".equals(steps.get(3).getOperator())
        assert(steps.get(4).getOperator().equals("apply"))

        assert(steps.get(0).getNumber().equals(2))
        assert(steps.get(1).getNumber().equals(3))
        assert(steps.get(2).getNumber().equals(4))
        assert(steps.get(3).getNumber().equals(8))
        assert(steps.get(4).getNumber().equals(3))

    }

    def "expect NPE when non-steps file passed"() {
        scanner = new Scanner(new FileReader("input/emptyfile.txt"))
        CalculatingStepsContract instructions = new CalculatingSteps(calculatingStepInitializer, scanner)
        when:
        instructions.analyzeSteps()

        then:
        thrown(NullPointerException)
    }


}
