package tn.enis.publication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import tn.enis.publication.entities.Publication;

import java.util.List;


@RepositoryRestController
public interface PublicationRepository extends JpaRepository<Publication,Long>
{


}

