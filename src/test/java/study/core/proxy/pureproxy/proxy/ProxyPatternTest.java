package study.core.proxy.pureproxy.proxy;

import org.junit.jupiter.api.Test;
import study.core.proxy.pureproxy.proxy.code.CacheProxy;
import study.core.proxy.pureproxy.proxy.code.ProxyPatternClient;
import study.core.proxy.pureproxy.proxy.code.RealSubject;

import static org.junit.jupiter.api.Assertions.*;

class ProxyPatternTest {
    @Test
    void noProxyTest(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(realSubject);
        proxyPatternClient.execute();
        proxyPatternClient.execute();
        proxyPatternClient.execute();
    }

    @Test
    void cacheProxyTest(){
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(cacheProxy);

        proxyPatternClient.execute();
        proxyPatternClient.execute();
        proxyPatternClient.execute();
    }
}