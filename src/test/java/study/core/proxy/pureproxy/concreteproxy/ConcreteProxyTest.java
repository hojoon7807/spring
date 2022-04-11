package study.core.proxy.pureproxy.concreteproxy;

import org.junit.jupiter.api.Test;
import study.core.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import study.core.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import study.core.proxy.pureproxy.concreteproxy.code.TimeProxy;

public class ConcreteProxyTest {
    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);

        concreteClient.execute();
        concreteClient.execute();
    }

    @Test
    void addProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.execute();
    }
}
