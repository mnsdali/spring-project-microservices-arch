package tn.enis.member.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;
import tn.enis.member.entities.Member;
import tn.enis.member.services.IMemberService;


import java.util.List;

@AllArgsConstructor
@RestController
public class MembreRestController {


    IMemberService memberService;
    @RequestMapping(value="/membres", method= RequestMethod.GET)
    public List<Member> findMembres (){
        return memberService.findAll();
    }
    @GetMapping(value="/membres/{id}")
    public Member findOneMemberById(@PathVariable Long id){
        return memberService.findMember(id);
    }

    @GetMapping(value="/membres/search/cin")
    public Member findOneMemberByCin(@RequestParam String cin)
    {
        return memberService.findByCin(cin);
    }
    @GetMapping(value="/membres/search/email")
    public Member findOneMemberByEmail(@RequestParam String email)
    {
        return memberService.findByEmail(email);
    }

    @PostMapping(value="/membres/enseignant")
    public Member addMembre(@RequestBody EnseignantChercheur m)
    {
        return memberService.addMember(m);
    }
    @PostMapping(value="/membres/etudiant")
    public Member addMembre(@RequestBody Etudiant e)
    {
        return memberService.addMember(e);
    }

    @DeleteMapping(value="/membres/{id}")
    public void deleteMembre(@PathVariable Long id)
    {
        memberService.deleteMember(id);
    }

    @PutMapping(value="/membres/etudiant/{id}")
    public Member updatemembre(@PathVariable Long id, @RequestBody
    Etudiant p)
    {
        p.setId(id);
        return memberService.updateMember(p);
    }
    @PutMapping(value="/membres/enseignant/{id}")
    public Member updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p)
    {
        p.setId(id);
        return memberService.updateMember(p);
    }

    @GetMapping("/fullmember/{id}")
    public Member findAFullMember(@PathVariable(name="id") Long id)
    {

        Member mbr= memberService.findMember(id);
        mbr.setPubs(memberService.findPublicationparauteur(id));

        return mbr;
    }
}
