package tn.enis.member.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member_Evenement {
    @EmbeddedId
    private Member_Even_Id id;
    @ManyToOne
    @MapsId("member_id")
    private Member member;
}
