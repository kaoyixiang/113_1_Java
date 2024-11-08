import java.util.Scanner;

public class SalesDepartment {
    public static void main(String[] args) {
        SalesPerson[] salesTeam = new SalesPerson[3];
        SalesPerson sales1 = new SalesPerson("SE111", "周柏睿");
        SalesPerson sales2 = new SalesPerson("SE222", "黃敬宇");
        SalesPerson sales3 = new SalesPerson("SE333", "吳嘉文");
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
                    case 1: // 设置佣金比例
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入新的佣金比例： ");
                            double newCommissionRate = input.nextDouble();
                            targetSales.setCommissionRate(newCommissionRate);
                            System.out.println("佣金比例已更新！");
                        }
                        break;
                    case 2: // 新增订单
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入商品名稱： ");
                            String itemName = input.next();
                            System.out.print("請輸入商品單價： ");
                            double itemPrice = input.nextDouble();
                            System.out.print("請輸入商品數量： ");
                            int amount = input.nextInt();
                            targetSales.setOrderArray(itemName, itemPrice, amount);
                            System.out.println("訂單已新增！");
                        }
                        break;
                    case 3: // 查询薪资
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.printf("業務員 %s 的薪資為：%.1f\n", targetSales.getName(), targetSales.salary());
                        }
                        break;
                    case 4: // 订单查询
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.println("該業務員的所有訂單：");
                            System.out.println(targetSales.getOrders());
                        }
                        break;
                    default:
                        System.out.println("選項無效，請重新選擇！");
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            menu(); // 显示菜单
        }
    }

    public static SalesPerson selectedSales(SalesPerson[] salesTeam) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入業務員編號： ");
        String salesID = input.next();

        // 遍历销售团队，查找与输入 ID 匹配的销售人员
        for (SalesPerson sales : salesTeam) {
            if (sales.getId().equals(salesID)) {
                return sales; // 返回找到的销售人员
            }
        }

        System.out.println("編號輸入錯誤，請重新輸入！");
        return null; // 若没有找到匹配的业务员
    }

    public static void menu() {
        System.out.println("\n\nROC股份有限公司：");
        System.out.print("1.設定獎金比例\n2.新增訂單\n3.薪資查詢\n4.訂單查詢\n請輸入： ");
    }
}
