public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    // 构造函数：初始化ID和姓名，销售额和佣金率默认值为0
    public SalesPerson(String id, String name) {
        this.id = id;
        this.name = name;
        this.grossSales = 0; // 默认销售金额为0
        this.commissionRate = 0; // 默认佣金比例为0
    }

    // 获取ID
    public String getId() {
        return this.id;
    }

    // 获取姓名
    public String getName() {
        return this.name;
    }

    // 设置销售金额，检查是否为正值
    public void setGrossSales(double grossSales) {
        if (grossSales >= 0) {
            this.grossSales = grossSales;
        } else {
            throw new IllegalArgumentException("销售金额必须为正值！");
        }
    }

    // 设置佣金比例，确保在0到1之间
    public void setCommissionRate(double commissionRate) {
        if (commissionRate >= 0 && commissionRate <= 1) {
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException("佣金比例必须在0到1之间！");
        }
    }

    // 计算薪资：销售额 * 佣金比例
    public double salary() {
        return this.grossSales * this.commissionRate;
    }

    // 重写toString方法，返回所有信息
    @Override
    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.1f%n薪資：%.1f%n",
                this.id, this.name, this.grossSales, this.commissionRate, salary());
    }
}
