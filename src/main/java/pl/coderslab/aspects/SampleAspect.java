package pl.coderslab.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {

    Logger log = LoggerFactory.getLogger(SampleAspect.class);

    @After("within(pl.coderslab.web.*)")
    public void doAlwaysAfterServices() {
        log.info("log from SampleAspect");
    }
}
