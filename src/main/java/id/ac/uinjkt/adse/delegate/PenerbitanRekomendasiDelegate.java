package id.ac.uinjkt.adse.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("penerbitanRekomendasiDelegate")
public class PenerbitanRekomendasiDelegate implements JavaDelegate {
    private static final Logger log = LoggerFactory.getLogger(PenerbitanRekomendasiDelegate.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String nim = (String) execution.getVariable("nim");
        String nama = (String) execution.getVariable("namaMahasiswa");
        String judul = (String) execution.getVariable("judulSkripsi");
        String dosenPembimbing = (String) execution.getVariable("dosenPembimbing");

        if (dosenPembimbing == null || dosenPembimbing.isBlank()) {
            dosenPembimbing = "Drs. M. Rizal Broer Bahaweres, M.Sc.";
        }

        log.info("==================================================================");
        log.info("[SURAT REKOMENDASI TERBIT] Proposal skripsi resmi disetujui!");
        log.info("Mahasiswa        : {} ({})", nama, nim);
        log.info("Judul Disetujui  : {}", judul);
        log.info("Dosen Pembimbing : {}", dosenPembimbing);
        log.info("==================================================================");
    }
}
