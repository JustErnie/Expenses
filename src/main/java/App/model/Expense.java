package App.model;

public class Expense {
    private final String name;
    private final double value;

    public Expense(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ExpenseModel{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
