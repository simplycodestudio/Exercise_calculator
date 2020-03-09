package calculation_steps;

import java.util.List;

public interface CalculatingStepsContract {
	
	List<Step> getInstructions();

	void analyzeSteps();

	Step createSingleStep(String operator, String number);

}
