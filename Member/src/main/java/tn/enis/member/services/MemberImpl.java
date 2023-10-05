package tn.enis.member.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.member.dao.EnseignantChercheurRepository;
import tn.enis.member.dao.EtudiantRepository;
import tn.enis.member.dao.MemberRepository;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;
import tn.enis.member.entities.Member;

import java.util.List;

@AllArgsConstructor
@Service
public class MemberImpl implements IMemberService{
    MemberRepository memberRepository;
    EtudiantRepository etudiantRepository;
    EnseignantChercheurRepository enseignantChercheurRepository;

    public Member addMember(Member m){
        memberRepository.save(m);
        return m;
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }

    public Member updateMember(Member m){
        return memberRepository.saveAndFlush(m);
    }

    public Member findMember(Long id){
        return (Member)memberRepository.findById(id).get();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();}
    public Member findByCin(String cin) {
        return memberRepository.findByCin(cin);}
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);}
    public List<Member> findByNom(String nom) {
        return memberRepository.findByNom(nom);}
    public List<Etudiant> findByDiplome(String diplome) {
        return etudiantRepository.findByDiplome(diplome);
    }

    public List<EnseignantChercheur> findByGrade() {
        return findByGrade(null);
    }

    public List<EnseignantChercheur> findByGrade(String grade) {
        return enseignantChercheurRepository.findByGrade(grade);
    }
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return enseignantChercheurRepository.findByEtablissement(etablissement);
    }

    @Override
    public List<Etudiant> findByEncadrant(EnseignantChercheur enseignantChercheur) {

        return etudiantRepository.findEtudiantsByEncadrant(enseignantChercheur);
    }

    @Override
    public void affectEtudiantToEncadrant(Long id_etd, Long id_ens) {
        Etudiant etd = etudiantRepository.findById(id_etd).get();
        EnseignantChercheur ens = enseignantChercheurRepository.findById(id_ens).get();
        etd.setEncadrant(ens);
        etudiantRepository.save(etd);
    }
}
