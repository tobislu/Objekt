package oving6.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {

    private final List<Employee> employees;
    private int nextIndex = 0;   // round-robin
    private int taskCount = 0;   // oppgaver "på vegne av" manageren

    public Manager(Collection<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("employees kan ikke være tom");
        }
        for (Employee e : employees) {
            if (e == null) {
                throw new IllegalArgumentException("employees kan ikke inneholde null");
            }
        }
        this.employees = new ArrayList<>(employees);
    }

    private Employee pickEmployee() {
        Employee chosen = employees.get(nextIndex);
        nextIndex = (nextIndex + 1) % employees.size();
        return chosen;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        if (operation == null) {
            throw new IllegalArgumentException("operation kan ikke være null");
        }
        taskCount++;
        return pickEmployee().doCalculations(operation, value1, value2); // delegering
    }

    @Override
    public void printDocument(String document) {
        if (document == null) {
            throw new IllegalArgumentException("document kan ikke være null");
        }
        taskCount++;
        pickEmployee().printDocument(document); // delegering
    }

    @Override
    public int getTaskCount() {
        return taskCount;
    }

    @Override
    public int getResourceCount() {
        int sum = 1; // manageren selv
        for (Employee e : employees) {
            sum += e.getResourceCount();
        }
        return sum;
    }
}