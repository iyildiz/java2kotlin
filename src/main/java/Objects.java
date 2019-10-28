import oo.CompanionOuter;
import oo.Constants;
import oo.SingletonCustomer;

public class Objects {

    public static void main(String[] args) {
        System.out.println("Kotlin Singleton from Java : " + SingletonCustomer.INSTANCE.getName());
        System.out.println("Kotlin Companion Object from Java : " + CompanionOuter.Companion.getName());
        System.out.println("Kotlin Companion Object from Java (JvmStatic) : " + CompanionOuter.getAddress());
        System.out.println("Kotlin (JvmField) : " + Constants.jvmField);
        System.out.println("Kotlin (JvmStatic) : " + Constants.getJvmStatic());
    }

}
