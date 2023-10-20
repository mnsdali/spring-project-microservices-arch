package tn.enis.evenement.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Evenement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Long id;

    @NonNull
    private String titre;
    @NonNull
    private Date date;
    @NonNull
    private String lieu;

}
