import java.util.List;
import oop.GenericsUtil;

public class Generics {

    public static void main(String[] args) {
        System.out.println(GenericsUtil.averageGenerics(List.of(1, 2, 3, 4, 5)));
        //Compiler error
        //System.out.println(GenericsUtil.averageGenerics(List.of(1.1,2.2,3.3,4.4,5.5)));
        System.out.println(GenericsUtil.averageGenericsDouble(List.of(1.1,2.2,3.3,4.4,5.5)));
    }

}
