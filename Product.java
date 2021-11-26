import java.util.Objects;

public class Product {
    private String name;
    private String description;
    public Product(String name, String description)
    {
        if(name != null) {
            this.name = name;
        } else
        {
            throw new IllegalArgumentException("Incorrect name");
        }
        if(description != null) {
            this.description = description;
        } else
        {
            throw new IllegalArgumentException("Incorrect description");
        }
    }

    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String
    toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
