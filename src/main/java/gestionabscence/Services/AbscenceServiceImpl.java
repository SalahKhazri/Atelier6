package gestionabscence.Services;

import gestionabscence.DTOs.AbscenceUpdate;
import gestionabscence.DTOs.EtudiantResponse;
import gestionabscence.Entities.Abscence;
import gestionabscence.Entities.Etudiant;
import gestionabscence.Repositories.AbscenceRepo;
import gestionabscence.Repositories.EtudiantRepo;
import gestionabscence.Utils.AbscenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbscenceServiceImpl implements AbscenceService {

    @Autowired
    private AbscenceRepo abscenceRepo;

    @Override
    public List<Abscence> findAll() {
        return abscenceRepo.findAll();
    }

    @Override
    public String ajouterAbsence(Abscence abscence) {
        abscenceRepo.save(abscence);
        return "success";
    }

    @Override
    public List<Abscence> getAbsencesByEtudiant(Long idEtudiant) {
        return abscenceRepo.findByEtudiantIdEtudiant(idEtudiant);
    }

    @Override
    public Abscence updateAbsence(Long idAbsence, AbscenceUpdate dto) {
        Abscence abs = abscenceRepo.findById(idAbsence)
                .orElseThrow(() -> new RuntimeException("Absence introuvable"));

        abs.setModule(dto.module());
        abs.setDate_abscence(dto.date_abscence());

        return abscenceRepo.save(abs);
    }

    @Override
    public String deleteAbsence(Long id) {
        abscenceRepo.deleteById(id);
        return "success";
    }

    @Override
    public Etudiant convertir(EtudiantResponse etudiant){
        Etudiant etd = new  Etudiant();
        etd.setIdEtudiant(etudiant.idEtudiant());
        etd.setNom(etudiant.nom());
        etd.setPrenom(etudiant.prenom());
        etd.setDate(etudiant.date());
        etd.setClasse(etudiant.classe());
        return etd;
    }
}
