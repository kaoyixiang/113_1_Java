public abstract class Role {
    protected String name;
    protected int level;
    protected int blood;


    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void fight(){System.out.print("發動攻擊");}
    
    public String toString() {
        return  "(%s, %d, %d)".formatted(this.name, this.level, this.blood);
    }
}
