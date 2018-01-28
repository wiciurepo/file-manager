package pl.wiciu.commons

import spock.lang.Shared
import spock.lang.Specification

class ServiceCallingMockTest extends Specification {

    @Shared
    def callingMock = new ServiceCallingMock()

    def "should mock and return mocked response"() {
        given:
        def mockClass = Mock(MockClass)
        def mockProviderBuilder = Mock(MockProvider.MockProviderBuilder)
        def mockProvider = Mock(MockProvider)

        mockProviderBuilder.build() >> {System.out.println("provider builder build called"); return mockProvider}
        mockProvider.getMock() >> mockClass
        //mockClass.callMe() >> {System.out.println("Mock called")}

        callingMock.setProviderBuilder(mockProviderBuilder)

        when:
        callingMock.callMock()

        then:
        1 * mockClass.callMe() >> {System.out.println("Mock called")}

    }


}
