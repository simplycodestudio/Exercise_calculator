package calculation_steps;


import common.CommonSplitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatingSteps implements CalculatingStepsContract, CommonSplitter {

    private List<Step> instructions;
    private CalculatingStepInitializer factory;
    private Scanner scanner;

    public CalculatingSteps(CalculatingStepInitializer factory, Scanner scanner) {
        this.factory = factory;
        this.instructions = new ArrayList();
        this.scanner = scanner;
    }

    @Override
    public void analyzeSteps() {
        String presentLine;
        String[] splittedLine = null;
        while (scanner.hasNextLine()) {
            presentLine = scanner.nextLine();
            splittedLine = splitLine(presentLine);
            Step singleStep = createSingleStep(splittedLine[0], splittedLine[1]);
            this.instructions.add(singleStep);
        }
        if (splittedLine != null) {
            checkStepscorrectness(splittedLine);
        } else {
            throw new NullPointerException("File is empty, calculation method can be invoked");
        }
    }

    @Override
    public Step createSingleStep(String operator, String number) {
        return this.factory.createNewStep(operator, number);
    }

    public void checkStepscorrectness(String[] splittedLine) {
        String operationDelimiter = "apply";
        if (!operationDelimiter.equals(splittedLine[0])) {
            throw new IllegalArgumentException("bad call queue");
        }
    }

    @Override
    public String[] splitLine(String presentLine) {
        String[] splittedLine = presentLine.split(" ");
        if (splittedLine.length > 2) {
            throw new IllegalArgumentException("Issue with file content");
        }
        return splittedLine;
    }

    @Override
    public List<Step> getInstructions() {
        return this.instructions;
    }

}
