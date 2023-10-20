package tn.enis.membre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enis.membre.services.IMembreService;
import tn.enis.membre.entities.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class MembreRestController {


    IMembreService membreService;
    @RequestMapping(value="/membres", method= RequestMethod.GET)
    public List<Membre> findMembres (){
        return membreService.findAll();
    }
    @GetMapping(value="/membres/{id}")
    public Membre findOneMemberById(@PathVariable Long id){
        return membreService.findMembre(id);
    }

    @GetMapping(value="/membres/search/cin")
    public Membre findOneMemberByCin(@RequestParam String cin)
    {
        return membreService.findByCin(cin);
    }
    @GetMapping(value="/membres/search/email")
    public Membre findOneMemberByEmail(@RequestParam String email)
    {
        return membreService.findByEmail(email);
    }

    @PostMapping(value="/membres/enseignant")
    public Membre addMembre(@RequestBody EnseignantChercheur m)
    {
        return membreService.addMembre(m);
    }
    @PostMapping(value="/membres/etudiant")
    public Membre addMembre(@RequestBody Etudiant e)
    {
        return membreService.addMembre(e);
    }

    @DeleteMapping(value="/membres/{id}")
    public void deleteMembre(@PathVariable Long id)
    {
        membreService.deleteMembre(id);
    }

    @PutMapping(value="/membres/etudiant/{id}")
    public Membre updatemembre(@PathVariable Long id, @RequestBody
    Etudiant p)
    {
        p.setId(id);
        return membreService.updateMembre(p);
    }
    @PutMapping(value="/membres/enseignant/{id}")
    public Membre updateMembre(@PathVariable Long id, @RequestBody
    EnseignantChercheur p)
    {
        p.setId(id);
        return membreService.updateMembre(p);
    }

}
