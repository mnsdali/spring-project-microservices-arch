package tn.enis.membre.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.membre.entities.Etudiant;
import tn.enis.membre.entities.Membre;

import java.util.List;

public interface MembreRepository extends JpaRepository<Membre,Long>
{

    Membre findByCin(String cin);
    List<Membre> findByNomStartingWith(String caractere);
    Membre findByEmail(String email);

    List<Membre> findByNom(String nom);

}