package pl.wiciu.commons;

public class ServiceCallingMock {

    MockProvider.MockProviderBuilder providerBuilder = MockProvider.builder();

    void callMock() {
        System.out.println("provider called");
        MockProvider mockProvider = providerBuilder.build();
        MockClass mock = mockProvider.getMock();

        mock.callMe();

    }

    public void setProviderBuilder(MockProvider.MockProviderBuilder providerBuilder) {
        this.providerBuilder = providerBuilder;
    }
}
