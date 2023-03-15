import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int numberOfCompanies = scanner.nextInt();
        double[] yearlyIncomes = new double[numberOfCompanies];
        double[] taxes = new double[numberOfCompanies];
        double mostTaxesPayed = 0;
        int companyChamp = 0;

        for (int i = 0; i < numberOfCompanies; i++) {
            yearlyIncomes[i] = scanner.nextInt();
        }

        for (int i = 0; i < numberOfCompanies; i++) {
            taxes[i] = scanner.nextInt();
        }

        for (int i = 0; i < numberOfCompanies; i++) {
            double taxesPayed = yearlyIncomes[i] * (taxes[i] / 100);
            if (mostTaxesPayed < taxesPayed) {
                mostTaxesPayed = taxesPayed;
                companyChamp = i+1;
            }
        }
        System.out.println(companyChamp);
    }
}
