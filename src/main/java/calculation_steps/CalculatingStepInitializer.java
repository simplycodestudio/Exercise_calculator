package calculation_steps;

public class CalculatingStepInitializer {

	public Step createNewStep(String operator, String number) {
		return new Step(operator.trim(), Integer.parseInt(number.trim()));
	}

}
