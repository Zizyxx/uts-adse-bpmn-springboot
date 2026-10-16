package id.ac.uinjkt.adse.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("checkSksDelegate")
public class CheckSksDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(CheckSksDelegate.class);
    private static final int MINIMUM_SKS = 100;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String nim = (String) execution.getVariable("nim");
        String nama = (String) execution.getVariable("namaMahasiswa");
        Object rawSks = execution.getVariable("totalSks");

        long totalSks = 0L;
        if (rawSks instanceof Long) {
            totalSks = (Long) rawSks;
        } else if (rawSks instanceof Integer) {
            totalSks = ((Integer) rawSks).longValue();
        } else if (rawSks instanceof String) {
            totalSks = Long.parseLong((String) rawSks);
        }

        boolean isEligible = totalSks >= MINIMUM_SKS;
        execution.setVariable("isEligible", isEligible);

        log.info("[VALIDASI SKS] Mahasiswa: {} ({}) | Total SKS: {} | Status Memenuhi: {}",
                nama, nim, totalSks, isEligible);
    }
}
