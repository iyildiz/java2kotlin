import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomerJava {
    private int id;
    private String name;
    private String email;

    public String returnNull(){
        return null;
    }

    @NotNull
    public String notNullAnnotation(){
        return "notNull";
    }

    @Nullable
    public String nullableAnnotation(){
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
