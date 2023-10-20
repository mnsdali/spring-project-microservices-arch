package tn.enis.membre.services;

import tn.enis.membre.entities.EnseignantChercheur;
import tn.enis.membre.entities.Etudiant;
import tn.enis.membre.entities.Membre;

import java.util.List;

public interface IMembreService {
    //Crud sur les membres
    public Membre addMembre(Membre m);
    public void deleteMembre(Long id) ;
    public Membre updateMembre(Membre p) ;
    public Membre findMembre(Long id) ;
    public List<Membre> findAll();

    //Filtrage par propriété
    public Membre findByCin(String cin);
    public Membre findByEmail(String email);
    public List<Membre> findByNom(String nom);

    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);

    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);
    public List<EnseignantChercheur> findByEtablissement(String
                                                                 etablissement);
    public List<Etudiant> findByEncadrant(EnseignantChercheur enseignantChercheur);

    public void affectEtudiantToEncadrant(Long id_etd, Long id_ens);
}