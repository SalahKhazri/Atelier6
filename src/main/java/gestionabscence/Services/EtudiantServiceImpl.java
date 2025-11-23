package gestionabscence.Services;

import gestionabscence.DTOs.EtudiantCreate;
import gestionabscence.DTOs.EtudiantResponse;
import gestionabscence.DTOs.EtudiantUpdate;
import gestionabscence.Entities.Departement;
import gestionabscence.Entities.Etudiant;
import gestionabscence.Repositories.DepartementRepo;
import gestionabscence.Repositories.EtudiantRepo;
import gestionabscence.Utils.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepo etudiantRepo;

    @Autowired
    private DepartementRepo departementRepo;



    @Override
    public Etudiant create(EtudiantCreate etudiant) {

        Etudiant etd = new Etudiant();
        etd.setNom(etudiant.nom());
        etd.setPrenom(etudiant.prenom());
        etd.setDate(etudiant.date());
        etd.setClasse(etudiant.classe());
        etudiantRepo.save(etd);
        return etd;
    }

    @Override
    public Etudiant Update(Long id, EtudiantUpdate etudiant) {
        Etudiant etd = etudiantRepo.findById(id).orElse(null);
        if(etd != null) {
            throw new RuntimeException("aucune etudiant avec ce id");
        }
        etd.setNom(etudiant.nom());
        etd.setPrenom(etudiant.prenom());
        etd.setDate(etudiant.date());
        etd.setClasse(etudiant.classe());
        etudiantRepo.save(etd);
        return etd;
    }

    @Override
    public Void delete(Long id) {
        Etudiant etd = etudiantRepo.findById(id).get();
        if(etd.getNom().equals("null")){
            throw new RuntimeException("aucune etudiant avec ce id");

        }

        etudiantRepo.delete(etd);
        return null;
    }

    public EtudiantResponse toResponse(Etudiant etd) {
        return new EtudiantResponse(
                etd.getIdEtudiant(),
                etd.getNom(),
                etd.getPrenom(),
                etd.getDate(),
                etd.getClasse(),
                etd.getDepartement() != null ? etd.getDepartement().getId_departement() : null
        );
    }

    @Override
    public EtudiantResponse findOne(Long id) {
        Etudiant etd = etudiantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        return toResponse(etd);
    }

    @Override
    public List<EtudiantResponse> findAll() {
        return etudiantRepo.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public String affecterDepartement(Long idEtudiant, Long idDepartement) {

        Departement dep = departementRepo.findById(idDepartement)
                .orElseThrow(() -> new RuntimeException("Département introuvable !"));

        Etudiant etd = etudiantRepo.findById(idEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable !"));

        etd.setDepartement(dep);

        etudiantRepo.save(etd);

        return "Département affecté avec succès à l'étudiant " + etd.getNom();
    }
}
