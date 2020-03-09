package controller;


import arithmeticOperation.ArithmeticOperation;
import arithmeticOperation.factory.ArithmeticOperationContract;
import calculation_steps.CalculatingStepsContract;
import calculation_steps.Step;

import java.util.List;
import java.util.Map;

public class CalculatorController {

    private ArithmeticOperationContract operations;
    private CalculatingStepsContract calculatingSteps;

    public CalculatorController(ArithmeticOperationContract operations, CalculatingStepsContract calculatingSteps) {
        this.operations = operations;
        this.calculatingSteps = calculatingSteps;
    }

	public void setCalculatingSteps(CalculatingStepsContract calculatingSteps) {
		this.calculatingSteps = calculatingSteps;
	}

    public int startCalculation() {
        List<Step> steps =calculatingSteps.getInstructions();
        if (steps == null) {
            throw new NullPointerException("Steps not been passed");
        }
        int presentValue = steps.get(steps.size()-1).getNumber();
        Map<String, ArithmeticOperation> operators = this.operations.getOperators();

        for (int i = 0; i < steps.size() - 1; i++) {
            String operator = steps.get(i).getOperator();
            int secondValue = steps.get(i).getNumber();

            if (!operators.containsKey(operator))
                throw new IllegalArgumentException(operator + " not exist in filesystem");
            presentValue = singlePipeline(operators.get(operator),presentValue, secondValue);
        }
        return presentValue;
    }

    private int singlePipeline(ArithmeticOperation operation, int topValue, int secondValue) {
        return operation.calculate(topValue, secondValue);
    }

}
