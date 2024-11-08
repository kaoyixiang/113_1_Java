import java.util.Scanner;

public class SalesDepartment {
    public static void main(String args[]) {
        SalesPerson[] salesTeam = new SalesPerson[3];
        SalesPerson sales1 = new SalesPerson("SE111", "林俊傑");
        SalesPerson sales2 = new SalesPerson("SE222", "張佳豪");
        SalesPerson sales3 = new SalesPerson("SE333", "劉威廷");
        salesTeam[0] = sales1;
        salesTeam[1] = sales2;
        salesTeam[2] = sales3;
        operation(salesTeam);
    }

    public static void operation(SalesPerson[] salesTeam) {
        SalesPerson targetSales;
        Scanner input = new Scanner(System.in);
        menu();

        while (input.hasNext()) {
            int choice = input.nextInt();
            try {
                switch (choice) {
                    case 1: // 设置销售金额
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("请输入销售金额：");
                            double grossSales = input.nextDouble();
                            targetSales.setGrossSales(grossSales);
                        }
                        break;

                    case 2: // 设置佣金比例
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("请输入佣金比例：");
                            double commissionRate = input.nextDouble();
                            targetSales.setCommissionRate(commissionRate);
                        }
                        break;

                    case 3: // 查询薪资
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.println("薪资：" + targetSales.salary());
                        }
                        break;

                    default:
                        throw new IllegalArgumentException("无效的选项，请重新输入！");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            menu();
        }
    }

    public static SalesPerson selectedSales(SalesPerson[] salesTeam) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入业务员编号： ");
        String salesID = input.next();

        // 查找业务员
        for (SalesPerson s : salesTeam) {
            if (s.getId().equals(salesID)) {
                return s;
            }
        }

        // 如果没有找到，打印错误信息
        System.out.println("编号输入错误");
        return null;
    }

    public static void menu() {
        System.out.println("\n\nROC股份有限公司：");
        System.out.println("1. 设置销售金额");
        System.out.println("2. 设置佣金比例");
        System.out.println("3. 薪资查询");
        System.out.print("请输入选项： ");
    }
}
