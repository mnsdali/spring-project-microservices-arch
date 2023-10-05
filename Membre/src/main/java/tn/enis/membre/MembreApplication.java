package tn.enis.membre;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.enis.membre.dao.MembreRepository;
import tn.enis.membre.entities.EnseignantChercheur;
import tn.enis.membre.entities.Etudiant;
import tn.enis.membre.entities.Membre;
import tn.enis.membre.services.IMembreService;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class MembreApplication implements CommandLineRunner {
    MembreRepository memberRepository;
    IMembreService membreService;
    public static void main(String[] args) {
        SpringApplication.run(MembreApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Etudiant etd1=Etudiant.builder()
                .cin("123456")
                .dateInscription(new Date())
                .dateNaissance(new Date())
                .diplome("mastère")
                .email("etd1@gmail.com")
                .password("pass1")
                .encadrant(null)
                .cv("cv1")
                .nom("abid")
                .prenom("youssef)")
                .sujet("blockhain")
                .build();
        Etudiant etd2=Etudiant.builder()
                .cin("135790")
                .dateInscription(new Date())
                .dateNaissance(new Date())
                .diplome("ingénieur")
                .email("etd2@gmail.com")
                .password("pass2")
                .encadrant(null)
                .cv("cv2")
                .nom("benrhouma")
                .prenom("hama")
                .sujet("AI")
                .build();
        EnseignantChercheur ens1= EnseignantChercheur.builder()
                .cin("052111")
                .dateNaissance(new Date())
                .email("ens1@gmail.com")
                .password("pass3")
                .cv("cv3")
                .nom("mnassar")
                .prenom("dali")
                .etablissement("enis")
                .grade("senior").build();

        EnseignantChercheur ens2= EnseignantChercheur.builder()
                .cin("052222")
                .dateNaissance(new Date())
                .email("ens2@gmail.com")
                .password("pass4")
                .cv("cv4")
                .nom("rebai")
                .prenom("omar")
                .etablissement("enis")
                .grade("dr").build();

        memberRepository.save(etd1);
        memberRepository.save(etd2);
        memberRepository.save(ens1);
        memberRepository.save(ens2);

        /*List<Membre> members = memberRepository.findAll();
        for (Membre member: members){
            System.out.println(member.getCin());
            System.out.println(member.getNom()+" "+member.getPrenom());
        }

        Membre member = memberRepository.findById(1L).get();
        System.out.println(member.getEmail());*/

        Membre m= membreService.findMembre(1L);
        m.setCv("cv1.pdf");
        membreService.updateMembre(m);
        membreService.deleteMembre(2L);

        membreService.affectEtudiantToEncadrant(1L,3L);
        List<Etudiant> etds = membreService.findByEncadrant(ens1);
        for (Etudiant etd: etds){
            System.out.println(etd.getEmail());
        }
    }

}
