package oving6.office;

import java.util.function.BinaryOperator;

public interface Employee {
    double doCalculations(BinaryOperator<Double> operation, double value1, double value2);
    void printDocument(String document);

    //Hvor mange oppgaver (beregninger + print) som er blitt utført av eller på vegne av dette Employee-objektet.
    
    int getTaskCount();

    //Antall employees tilgjengelig i hierarkiet, inkludert "this".

    int getResourceCount();
}