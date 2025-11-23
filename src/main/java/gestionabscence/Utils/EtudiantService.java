package gestionabscence.Utils;

import gestionabscence.DTOs.EtudiantCreate;
import gestionabscence.DTOs.EtudiantResponse;
import gestionabscence.DTOs.EtudiantUpdate;
import gestionabscence.Entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant create(EtudiantCreate etudiant);
    Etudiant Update(Long id, EtudiantUpdate etudiant);
    Void delete(Long id);
    EtudiantResponse findOne(Long id);
    List<EtudiantResponse> findAll();

    String  affecterDepartement(Long idEtudiant, Long  idDepartement);


}
