package App.model;

public class Transaction {
    private final String name;
    private final double value;

    public Transaction(String name, double value) {
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
        return "Transaction{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
