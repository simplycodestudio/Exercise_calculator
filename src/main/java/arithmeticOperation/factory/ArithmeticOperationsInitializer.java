package arithmeticOperation.factory;

import arithmeticOperation.ArithmeticOperation;

public class ArithmeticOperationsInitializer {

    private ArithmeticOperation strategyClass = null;

    public ArithmeticOperation createProperOperation(String strategy) throws ClassNotFoundException {
        Class<?> arithmeticClass = null;
        arithmeticClass = Class.forName("arithmeticOperation." + strategy.trim());
        try {
            strategyClass = (ArithmeticOperation) arithmeticClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return strategyClass;
    }


}
