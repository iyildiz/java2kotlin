import oop.CompanionOuter;
import oop.Constants;
import oop.SingletonCustomer;

public class Objects {

    public static void main(String[] args) {
        System.out.println("Kotlin Singleton from Java : " + SingletonCustomer.INSTANCE.getName());
        System.out.println("Kotlin Companion Object from Java : " + CompanionOuter.Companion.getName());
        System.out.println("Kotlin Companion Object from Java (JvmStatic) : " + CompanionOuter.getAddress());
        System.out.println("Kotlin Companion Object from Java (JvmField) : " + CompanionOuter.postCode);
        System.out.println("Kotlin (JvmField) : " + Constants.jvmField);
        System.out.println("Kotlin (JvmStatic) : " + Constants.getJvmStatic());
    }

}
