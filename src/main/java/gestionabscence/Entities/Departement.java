package gestionabscence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "departement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private Long id_departement;

    @Column(name = "nom_departement", nullable = false)
    private String nomDepartement;

    @OneToMany(mappedBy = "departement", cascade= CascadeType.ALL,  fetch = FetchType.LAZY)
    private List<Etudiant> etudiants;
}
