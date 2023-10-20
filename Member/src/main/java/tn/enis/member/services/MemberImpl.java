package tn.enis.member.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.member.beans.PublicationBean;
import tn.enis.member.dao.EnseignantChercheurRepository;
import tn.enis.member.dao.EtudiantRepository;
import tn.enis.member.dao.MemberPubRepository;
import tn.enis.member.dao.MemberRepository;
import tn.enis.member.entities.*;
import tn.enis.member.proxies.PublicationProxyService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class MemberImpl implements IMemberService{
    MemberRepository memberRepository;
    EtudiantRepository etudiantRepository;
    EnseignantChercheurRepository enseignantChercheurRepository;
    MemberPubRepository memberPubRepository;
    PublicationProxyService proxy;

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

    public void affecterauteurTopublication(Long idauteur, Long idpub)
    {
        Member mbr= memberRepository.findById(idauteur).get();
        Member_Publication mbs= new Member_Publication();
        mbs.setAuteur(mbr);
        mbs.setId(new Member_Pub_Id(idpub, idauteur));
        memberPubRepository.save(mbs);
    }

    public List<PublicationBean> findPublicationparauteur(Long idauteur) {
        List<PublicationBean> pubs=new ArrayList<PublicationBean>();
        Member auteur= memberRepository.findById(idauteur).get();
        List< Member_Publication>
                idpubs=memberPubRepository.findByAuteur(auteur);
        idpubs.forEach(s->{
                    System.out.println(s);
                    pubs.add(proxy.findPublicationById(s.getId().getPublication_id()));
                }
        );
        return pubs;
    }
}
