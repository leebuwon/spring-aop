package hello.aop.proxyvs;

import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Member;

@Slf4j
public class ProxyCastingTest {

    @Test
    void jdkProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false); // JDK 프록시

        // 프록시를 인터페이스로 캐스팅 성공
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        // cannot be cast to class hello.aop.member.MemberServiceImpl -> 실패한다. ( 구체타입으로는 실패 ) ( ClassCastException )
        Assertions.assertThrows(ClassCastException.class, () -> {
            MemberServiceImpl castMemberService = (MemberServiceImpl) memberServiceProxy;
        });
    }


    @Test
    void cglProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); // CGLIB 프록시

        // 프록시를 인터페이스로 캐스팅 성공
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        // CGLIB 프록시를 캐스팅 구현 성공
        // CGLIB는 구체클래스를 기반으로 프록시 생성
        MemberServiceImpl castMemberService = (MemberServiceImpl) memberServiceProxy;
    }
}
