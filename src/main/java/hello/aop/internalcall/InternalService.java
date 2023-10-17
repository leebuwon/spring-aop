package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InternalService {

    // 구조를 변경
    public void internal() {
        log.info("call internal");
    }
}
