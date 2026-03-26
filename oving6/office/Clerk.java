package oving6.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {

    private final Printer printer;
    private int taskCount = 0;

    public Clerk(Printer printer) {
        if (printer == null) {
            throw new IllegalArgumentException("printer kan ikke være null");
        }
        this.printer = printer;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        if (operation == null) {
            throw new IllegalArgumentException("operation kan ikke være null");
        }
        taskCount++;
        return operation.apply(value1, value2);
    }

    @Override
    public void printDocument(String document) {
        if (document == null) {
            throw new IllegalArgumentException("document kan ikke være null");
        }
        taskCount++;
        printer.printDocument(document, this); // delegering
    }

    @Override
    public int getTaskCount() {
        return taskCount;
    }

    @Override
    public int getResourceCount() {
        return 1;
    }
}