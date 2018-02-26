import java.math.BigDecimal;
import java.util.Scanner;

public class AnonymousDownsite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sites = Long.parseLong(scanner.nextLine());
        long securityKey = Long.parseLong(scanner.nextLine());
        BigDecimal totalLoss = new BigDecimal(0);
        for (int i = 0; i < sites; i++) {
            String[] siteData = scanner.nextLine().split(" ");
            String siteName = siteData[0];
            BigDecimal siteVisits = new BigDecimal(siteData[1]);
            BigDecimal pricePerVisit = new BigDecimal(siteData[2]);
            BigDecimal sum = pricePerVisit.multiply(siteVisits);
            totalLoss = totalLoss.add(sum);
            System.out.println(siteName);
        }
        System.out.printf("Total Loss: %.20f", totalLoss);
        System.out.println();
        BigDecimal securityToken = securityTokenResult(securityKey,sites);
        System.out.printf("Security Token: " + securityToken);
    }

    public static BigDecimal securityTokenResult(long securityKey, long sites){
        BigDecimal temp = new BigDecimal(securityKey);
        for (int i = 1; i < sites; i++) {
            temp = temp.multiply(new BigDecimal(securityKey));
        }
        return temp;
    }
}
