package id.ac.uinjkt.adse.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("notifikasiPenolakanDelegate")
public class NotifikasiPenolakanDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(NotifikasiPenolakanDelegate.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String nim = (String) execution.getVariable("nim");
        String nama = (String) execution.getVariable("namaMahasiswa");
        Boolean isEligible = (Boolean) execution.getVariable("isEligible");
        String catatan = (String) execution.getVariable("catatanKaprodi");

        String alasan;
        if (Boolean.FALSE.equals(isEligible)) {
            alasan = "Total SKS belum mencapai batas minimum 100 SKS.";
        } else {
            alasan = "Ditolak pada tahap peninjauan Kaprodi. Catatan: " + (catatan != null ? catatan : "Topik tidak sesuai.");
        }

        log.warn("[PENOLAKAN PROPOSAL] Mahasiswa: {} ({}) | Alasan: {}", nama, nim, alasan);
    }
}
