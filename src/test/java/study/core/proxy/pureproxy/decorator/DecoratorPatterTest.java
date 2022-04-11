package study.core.proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import study.core.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import study.core.proxy.pureproxy.decorator.code.MessageDecorator;
import study.core.proxy.pureproxy.decorator.code.RealComponent;
import study.core.proxy.pureproxy.decorator.code.TimeDecorator;

@Slf4j
public class DecoratorPatterTest {
    @Test
    void noDecorator(){
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(realComponent);

        decoratorPatternClient.execute();
        decoratorPatternClient.execute();
        decoratorPatternClient.execute();
    }

    @Test
    void decorator(){
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(messageDecorator);

        decoratorPatternClient.execute();
    }

    @Test
    void decorator2(){
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(timeDecorator);

        decoratorPatternClient.execute();
    }
}
