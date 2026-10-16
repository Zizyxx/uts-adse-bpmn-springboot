package id.ac.uinjkt.adse.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("helloWorldDelegate")
public class HelloWorldDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldDelegate.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("==================================================================");
        log.info("[TEST-HELLO-WORLD] Camunda BPMN Engine terhubung sukses ke Spring Boot!");
        log.info("Execution ID : {}", execution.getId());
        log.info("Process Key  : {}", execution.getProcessBusinessKey());
        log.info("==================================================================");
    }
}
