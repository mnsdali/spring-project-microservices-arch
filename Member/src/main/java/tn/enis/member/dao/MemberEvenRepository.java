package tn.enis.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Member_Even_Id;
import tn.enis.member.entities.Member_Evenement;


import java.util.List;

public interface MemberEvenRepository extends
        JpaRepository<Member_Evenement, Member_Even_Id> {
    List<Member_Evenement> findByMember(Member member);
}
