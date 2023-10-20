package tn.enis.membre.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.membre.entities.EnseignantChercheur;
import tn.enis.membre.entities.Etudiant;
import tn.enis.membre.entities.Membre;

import java.util.List;


public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String diplome);

    List<Etudiant> findEtudiantsByEncadrant(EnseignantChercheur enseignantChercheur);
}
