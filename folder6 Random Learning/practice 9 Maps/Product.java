
import java.util.List;
import java.util.Objects;


public class Product{

    private String name;
    private String description;
    private List<String> tags;

    public Product(){}

    public Product(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Product(String name, String description, List<String> tags){
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public List<String> getTags(){
        return this.tags;
    }

    public void setTags(List<String> tags){
        this.tags = tags;
    }

    public Product addTagsOfOtheProduct(Product product){
        this.tags.addAll(product.getTags());
        return this;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\n" +
            "Description: " + this.description + "\n";
    }

    //  ----------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object obj){
        if(obj == this){ return true; }
        else if(obj == null || obj.getClass() != this.getClass()){ return false; }

        Product p = (Product)obj;
        return Objects.equals(this.name, p.name) && Objects.equals(this.description, p.description);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, description);
    }
    //  ----------------------------------------------------------------------------------------------

}