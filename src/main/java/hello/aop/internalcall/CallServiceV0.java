package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class CallServiceV0 {

    public void external() {
        log.info("call external");;
        // java에서 대상을 지정하지 않으면 내부 메서드가 호출되기 때문에 this가 생략되더라도 문제가 없다.
        internal();;
    }

    public void internal() {
        log.info("call internal");
    }
}
