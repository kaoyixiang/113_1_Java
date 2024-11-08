public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    // 构造函数1：仅接受ID和姓名
    public SalesPerson(String id, String name) {
        // 调用另一个构造函数，默认销售额和佣金率为0
        this(id, name, 0, 0);
    }

    // 构造函数2：接受ID、姓名、销售额和佣金率
    public SalesPerson(String id, String name, double grossSales, double commissionRate) {
        this.id = id;
        this.name = name;
        setGrossSales(grossSales); // 使用set方法来设置销售额
        setCommissionRate(commissionRate); // 使用set方法来设置佣金率
    }

    // 获取ID
    public String getId() {
        return id;
    }

    // 获取姓名
    public String getName() {
        return name;
    }

    // 设置销售额，确保为正值
    public void setGrossSales(double grossSales) {
        if (grossSales >= 0) {
            this.grossSales = grossSales;
        } else {
            throw new IllegalArgumentException("銷售金額必須為正值！");
        }
    }

    // 设置佣金率，确保在0到1之间
    public void setCommissionRate(double commissionRate) {
        if (commissionRate >= 0 && commissionRate <= 1) {
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException("獎金比例必須在0到1之間！");
        }
    }

    // 计算薪资
    public double salary() {
        return grossSales * commissionRate;
    }

    // 重写toString方法以打印业务员信息
    @Override
    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.2f%n薪資：%.1f%n",
                this.id, this.name, this.grossSales, this.commissionRate, salary());
    }
}
