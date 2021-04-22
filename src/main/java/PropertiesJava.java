public class PropertiesJava {

    public static void main(String[] args) {
        Person personKotlin = new Person("name", 15);
        System.out.println("Kotlin property from Java : " + personKotlin.getName());
        System.out.println("Kotlin property from Java : " + personKotlin.getAge());
        System.out.println("Kotlin custom accessor from Java : " + personKotlin.isChild());
        personKotlin.appendCharToName('!');
        System.out.println("Kotlin custom method from Java : " + personKotlin.getName());
        StringBuilder sb = new StringBuilder("hello");
        System.out.println("Kotlin extensionProperty getter Java : " + personKotlin.getLastChar(sb));
        personKotlin.setLastChar(sb, '!');
        System.out.println("Kotlin extensionProperty setter Java : " + sb);
    }

}
