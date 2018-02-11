package pl.wiciu.commons;

public class ContextProvider {

    public static ContextForTest contextForTest = new ContextForTest();

    public static ContextForTest getContextForTest() {
        return contextForTest;
    }
}
