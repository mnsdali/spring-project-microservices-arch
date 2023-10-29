package tn.enis.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Member_Outil;
import tn.enis.member.entities.Member_Outil_Id;

import java.util.List;

public interface MemberOutilRepository extends
        JpaRepository<Member_Outil, Member_Outil_Id> {
    List<Member_Outil> findByUser(Member user);
}
