import java.util.Objects;

public class Pack {
    private double weight;
    private String description;

    public Pack(double weight, String description)
    {
        if(description != null)
        {
            this.description = description;
        }
        else
            throw new IllegalArgumentException("empty description");
        if(weight >0)
        {
            this.weight = weight;
        }
        else
            throw new IllegalArgumentException("Incorrect weight");
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pack pack = (Pack) o;
        return Double.compare(pack.weight, weight) == 0 && Objects.equals(description, pack.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, description);
    }

    @Override
    public String toString() {
        return "Pack{" +
                "weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }
}
