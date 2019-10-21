import java.io.IOException;

public class FunctionsJava {
    public static void main(String[] args) {
        FunctionUtil.extensionFunction("hello");
        System.out.println(FunctionUtil.topLevelFunction());
        FunctionUtil.methodWithDefaultParameters("abc", "(");
        kotlinMethodThrowingExplicitException();
    }

    private static void kotlinMethodThrowingExplicitException() {
        try {
            IdiomsUtil.throwsAnExplicitException();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
