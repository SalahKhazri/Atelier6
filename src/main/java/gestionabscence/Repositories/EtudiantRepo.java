package gestionabscence.Repositories;

import gestionabscence.Entities.Departement;
import gestionabscence.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByDepartement(Departement departement);
}
