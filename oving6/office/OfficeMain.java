package oving6.office;

import java.util.List;

public class OfficeMain {

    public static void main(String[] args) {
        Printer printer = new Printer();

        // Nederst: clerks
        Clerk c1 = new Clerk(printer);
        Clerk c2 = new Clerk(printer);
        Clerk c3 = new Clerk(printer);

        // 1 nivå manager
        Manager m1 = new Manager(List.of(c1, c2, c3));
        runSomeWork(m1);
        System.out.println("1 nivå: effektivitet = " +
                (m1.getTaskCount() / (double) m1.getResourceCount()));

        // 2 nivåer managers
        Manager mLow1 = new Manager(List.of(c1, c2));
        Manager mLow2 = new Manager(List.of(c3));
        Manager mTop = new Manager(List.of(mLow1, mLow2));

        runSomeWork(mTop);
        System.out.println("2 nivå: effektivitet = " +
                (mTop.getTaskCount() / (double) mTop.getResourceCount()));

        // 3 nivåer (enda mer overhead i toppen)
        Manager mMid = new Manager(List.of(mLow1, mLow2));
        Manager mCEO = new Manager(List.of(mMid));

        runSomeWork(mCEO);
        System.out.println("3 nivå: effektivitet = " +
                (mCEO.getTaskCount() / (double) mCEO.getResourceCount()));
    }

    private static void runSomeWork(Employee e) {
        // litt blandet arbeid
        for (int i = 0; i < 10; i++) {
            e.doCalculations((a, b) -> a + b, i, 2 * i);
            e.printDocument("Dokument #" + i);
        }
    }
}