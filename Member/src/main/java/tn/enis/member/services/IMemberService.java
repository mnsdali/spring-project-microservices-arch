package tn.enis.member.services;

import tn.enis.member.beans.EvenementBean;
import tn.enis.member.beans.OutilBean;
import tn.enis.member.beans.PublicationBean;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;
import tn.enis.member.entities.Member;

import java.util.List;

public interface IMemberService {
    //Crud sur les membres
    public Member addMember(Member m);
    public void deleteMember(Long id) ;
    public Member updateMember(Member p) ;
    public Member findMember(Long id) ;
    public List<Member> findAll();

    //Filtrage par propriété
    public Member findByCin(String cin);
    public Member findByEmail(String email);
    public List<Member> findByNom(String nom);

    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);

    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);
    public List<EnseignantChercheur> findByEtablissement(String etablissement);


    public List<Etudiant> findByEncadrant(EnseignantChercheur enseignantChercheur);

    public void affectEtudiantToEncadrant(Long id_etd, Long id_ens);

    // publication auteur
    public void affecterauteurTopublication(Long idauteur, Long idpub);

    public List<PublicationBean> findPublicationparauteur (Long idauteur);

    // outil user
    public void affecterUserToOutil(Long userid, Long outilid);

    public List<OutilBean> findOutilsByUser (Long userid);

    // evenement member
    public void affecterMemberToEvenement(Long memberid, Long evenid);

    public List<EvenementBean> findEvenementsByMember (Long memberid);
}