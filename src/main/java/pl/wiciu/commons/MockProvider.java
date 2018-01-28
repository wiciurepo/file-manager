package pl.wiciu.commons;

public class MockProvider {

    private String name;
    private int id;

    private MockProvider(String name, int id) {
        this.name = name;
        this.id = id;
    }

    MockClass getMock() {

        return new MockClass();

    }

    public static MockProviderBuilder builder() {
        return new MockProviderBuilder();
    }

    static class MockProviderBuilder {

        private String name;
        private int id;

        public MockProviderBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MockProviderBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public MockProvider build() {
            return new MockProvider(name, id);
        }
    }
}
