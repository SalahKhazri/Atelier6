package gestionabscence.Repositories;

import gestionabscence.Entities.Abscence;
import gestionabscence.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbscenceRepo extends JpaRepository<Abscence,Long> {
    List<Abscence> findByEtudiant(Etudiant etudiant);
    List<Abscence> findByEtudiantIdEtudiant(Long idEtudiant);
}
