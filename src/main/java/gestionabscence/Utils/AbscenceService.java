package gestionabscence.Utils;

import gestionabscence.DTOs.AbscenceUpdate;
import gestionabscence.DTOs.EtudiantResponse;
import gestionabscence.Entities.Abscence;
import gestionabscence.Entities.Etudiant;

import java.util.List;

public interface AbscenceService {
    List<Abscence> findAll();
    String ajouterAbsence(Abscence abscence);
    List<Abscence> getAbsencesByEtudiant(Long idEtudiant);
    Abscence updateAbsence(Long idAbsence, AbscenceUpdate dto);
    String deleteAbsence(Long id);
    Etudiant convertir(EtudiantResponse etudiant);
}
