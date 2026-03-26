package oving6.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {

    private final Map<Employee, List<String>> history = new HashMap<>();

    public void printDocument(String document, Employee employee) {
        if (document == null || employee == null) {
            throw new IllegalArgumentException("document og employee kan ikke være null");
        }
        System.out.println(document);

        history.computeIfAbsent(employee, e -> new ArrayList<>()).add(document);
    }

    public List<String> getPrintHistory(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("employee kan ikke være null");
        }

        List<String> h = history.get(employee);

        if (h == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(h);
    }
}