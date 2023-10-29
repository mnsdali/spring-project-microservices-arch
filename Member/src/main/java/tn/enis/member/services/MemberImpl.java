package tn.enis.member.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.member.beans.EvenementBean;
import tn.enis.member.beans.OutilBean;
import tn.enis.member.beans.PublicationBean;
import tn.enis.member.dao.*;
import tn.enis.member.entities.*;
import tn.enis.member.proxies.EvenementProxyService;
import tn.enis.member.proxies.OutilProxyService;
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
    PublicationProxyService pubProxy;

    MemberEvenRepository memberEvenRepository;
    EvenementProxyService evenProxy;

    MemberOutilRepository memberOutilRepository;
    OutilProxyService outilProxy;

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
                    pubs.add(pubProxy.findPublicationById(s.getId().getPublication_id()));
                }
        );
        return pubs;
    }

    public void affecterUserToOutil(Long userid, Long outilid)
    {
        Member user= memberRepository.findById(userid).get();
        Member_Outil mbo= new Member_Outil();
        mbo.setUser(user);
        mbo.setId(new Member_Outil_Id(outilid, userid));
        memberOutilRepository.save(mbo);
    }

    public List<OutilBean> findOutilsByUser(Long user_id) {
        List<OutilBean> outils= new ArrayList<>();
        Member user= memberRepository.findById(user_id).get();
        List< Member_Outil>
                idoutils=memberOutilRepository.findByUser(user);
        idoutils.forEach(s->{
                    System.out.println(s);
                outils.add(outilProxy.findOutil(s.getId().getOutil_id()));
                }
        );
        return outils;
    }

    public void affecterMemberToEvenement(Long memberid, Long eventid)
    {
        Member member= memberRepository.findById(memberid).get();
        Member_Evenement mbe= new Member_Evenement();
        mbe.setMember(member);
        mbe.setId(new Member_Even_Id(eventid, memberid));
        memberEvenRepository.save(mbe);
    }

    public List<EvenementBean> findEvenementsByMember(Long memberid) {
        List<EvenementBean> events= new ArrayList<>();
        Member member= memberRepository.findById(memberid).get();
        List< Member_Evenement>
                idevents=memberEvenRepository.findByMember(member);
        idevents.forEach(s->{
                    System.out.println(s);
            events.add(evenProxy.findEvenementById(s.getId().getEvenement_id()));
                }
        );
        return events;
    }
}
