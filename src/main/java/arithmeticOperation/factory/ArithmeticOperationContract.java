package arithmeticOperation.factory;

import arithmeticOperation.ArithmeticOperation;
import java.util.Map;

public interface ArithmeticOperationContract {
	Map<String, ArithmeticOperation> getOperators();

	void readInputFile() throws ClassNotFoundException;

	ArithmeticOperation createArithmetic(String arithmeticOperation) throws ClassNotFoundException;
}
