public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    private Order[] orderArray = new Order[3];  // 存储订单的数组
    private int orderCount = 0;  // 当前已存储的订单数量

    // 构造函数：默认佣金比例为 0.01
    public SalesPerson(String id, String name) {
        this(id, name, 0.01);  // 调用另一个构造函数，设置默认佣金比例
    }

    // 构造函数：允许设置自定义佣金比例
    public SalesPerson(String id, String name, double commissionRate) {
        this.id = id;
        this.name = name;
        this.commissionRate = commissionRate;
        this.grossSales = 0;  // 初始销售额为 0
    }

    // 获取 ID
    public String getId() {
        return id;
    }

    // 获取姓名
    public String getName() {
        return name;
    }

    // 设置佣金比例
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // 设置订单信息
    public void setOrderArray(String itemName, double itemPrice, int amount) {
        // 如果订单数组已满，扩展数组
        if (orderCount >= orderArray.length) {
            Order[] newOrderArray = new Order[orderArray.length * 2];
            System.arraycopy(orderArray, 0, newOrderArray, 0, orderArray.length);
            orderArray = newOrderArray;
        }

        // 添加新的订单
        Order newOrder = new Order(itemName, itemPrice, amount);
        orderArray[orderCount++] = newOrder;  // 将新订单加入数组并增加订单计数
    }

    // 计算总销售额
    public double getGrossSales() {
        double totalSales = 0;
        // 遍历所有订单，累加销售额
        for (int i = 0; i < orderCount; i++) {
            totalSales += orderArray[i].getItemPrice() * orderArray[i].getAmount();
        }
        return totalSales;
    }

    // 获取所有订单的详细信息
    public String getOrders() {
        StringBuilder orders = new StringBuilder();
        for (int i = 0; i < orderCount; i++) {
            orders.append(orderArray[i].toString()).append("\n");
        }
        return orders.toString();
    }

    // 计算薪资
    public double salary() {
        return getGrossSales() * commissionRate;
    }

    // 重写 toString 方法，输出业务员的信息
    @Override
    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.2f%n薪資：%.1f%n",
                this.id, this.name, getGrossSales(), this.commissionRate, salary());
    }

    // 订单类 (Order)，用于存储每个订单的内容
    public static class Order {
        private String itemName;  // 项目名称
        private double itemPrice;  // 项目价格
        private int amount;  // 项目数量

        public Order(String itemName, double itemPrice, int amount) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.amount = amount;
        }

        // 获取项目名称
        public String getItemName() {
            return itemName;
        }

        // 获取项目价格
        public double getItemPrice() {
            return itemPrice;
        }

        // 获取项目数量
        public int getAmount() {
            return amount;
        }

        // 重写 toString 方法，输出订单的内容
        @Override
        public String toString() {
            return String.format("項目名稱：%s, 單價：%.2f, 數量：%d, 小計：%.2f",
                    itemName, itemPrice, amount, itemPrice * amount);
        }
    }
}
