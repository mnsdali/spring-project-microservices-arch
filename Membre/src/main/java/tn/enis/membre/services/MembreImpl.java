package tn.enis.membre.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.membre.dao.EnseignantChercheurRepository;
import tn.enis.membre.dao.EtudiantRepository;
import tn.enis.membre.dao.MembreRepository;
import tn.enis.membre.entities.EnseignantChercheur;
import tn.enis.membre.entities.Etudiant;
import tn.enis.membre.entities.Membre;

import java.util.List;

@AllArgsConstructor
@Service
public class MembreImpl implements IMembreService{
    MembreRepository membreRepository;
    EtudiantRepository etudiantRepository;
    EnseignantChercheurRepository enseignantChercheurRepository;

    public Membre addMembre(Membre m){
        membreRepository.save(m);
        return m;
    }

    public void deleteMembre(Long id){
        membreRepository.deleteById(id);
    }

    public Membre updateMembre(Membre m){
        return membreRepository.saveAndFlush(m);
    }

    public Membre findMembre(Long id){
        return (Membre)membreRepository.findById(id).get();
    }

    public List<Membre> findAll() {
        return membreRepository.findAll();}
    public Membre findByCin(String cin) {
        return membreRepository.findByCin(cin);}
    public Membre findByEmail(String email) {
        return membreRepository.findByEmail(email);}
    public List<Membre> findByNom(String nom) {
        return membreRepository.findByNom(nom);}
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
