package gestionabscence.Utils;

import gestionabscence.Entities.Departement;
import gestionabscence.Entities.Etudiant;

import java.util.List;

public interface DepartementService {
    String CreateDepartement(Departement departement);
    List<Departement> findAll();
    Departement findOne(Long id);
    String UpdateDepartement(Long id, Departement departement);
    String DeleteDepartement(Long id);


}
