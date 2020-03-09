package arithmeticOperation.factory;

import arithmeticOperation.ArithmeticOperation;
import common.CommonSplitter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@ToString
public class ArithmeticsOperations implements ArithmeticOperationContract, CommonSplitter {

	private Map<String, ArithmeticOperation> operators;
	private ArithmeticOperationsInitializer factory;
	private Scanner scanner;

	public ArithmeticsOperations(ArithmeticOperationsInitializer factory, Scanner scanner) {
		this.scanner = scanner;
		this.operators = new HashMap<>();
		this.factory = factory;
	}

	@Override
	public Map<String, ArithmeticOperation> getOperators() {
		return this.operators;
	}

	@Override
	public void readInputFile() throws ClassNotFoundException {
		String presentLine;
		while(scanner.hasNextLine()) {
			presentLine = scanner.nextLine();
			String[] splittedLine = splitLine(presentLine);
			ArithmeticOperation arithmetic = createArithmetic(splittedLine[1]);
			this.operators.put(splittedLine[0].trim(), arithmetic);
		}
	}

	@Override
	public ArithmeticOperation createArithmetic(String arithmeticOperation) throws ClassNotFoundException {
		return this.factory.createProperOperation(arithmeticOperation);
	}

	@Override
	public String[] splitLine(String presentLine) {
		String[] splittedLine = presentLine.split(" ");
		if (splittedLine.length > 2){
			throw new IllegalArgumentException("Issue with file content");
		}
		return splittedLine;
	}

}
