package tn.enis.outil.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Outil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Long id;

    @NonNull
    private String source;
    @NonNull
    private Date date;
}
