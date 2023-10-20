package tn.enis.outil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.outil.entities.Outil;

import java.util.List;

public interface OutilRepository extends JpaRepository<Outil,Long>
{

    Outil findBySource(String source);
    List<Outil> findByNomStartingWith(String caractere);


}

