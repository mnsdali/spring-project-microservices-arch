package tn.enis.evenement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.evenement.entities.Evenement;

import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement,Long>
{
    List<Evenement> findByNomStartingWith(String caractere);
    Evenement findByTitle(String title);

}