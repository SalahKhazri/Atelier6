package gestionabscence.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "abscence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Abscence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAbscence")
    private Long idAbscence;

    @Column(nullable = false)
    private String module;

    @Column(nullable = false)
    private LocalDate date_abscence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etudiant", nullable = false)
    private Etudiant etudiant;

}
