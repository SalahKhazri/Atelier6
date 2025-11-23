package gestionabscence.Services;

import gestionabscence.Entities.Departement;
import gestionabscence.Repositories.DepartementRepo;
import gestionabscence.Utils.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartementRepo departementRepo;


    @Override
    public String CreateDepartement(Departement departement) {
        departementRepo.save(departement);
        return "departement enregistrer avec succées";
    }

    @Override
    public List<Departement> findAll() {
        return departementRepo.findAll();
    }

    @Override
    public Departement findOne(Long id) {
        return departementRepo.findById(id).orElse(null);
    }

    @Override
    public String UpdateDepartement(Long id, Departement departement) {
        Departement dep =  departementRepo.findById(id).orElse(null);
        if(dep!=null){
            dep.setNomDepartement(departement.getNomDepartement());
            departementRepo.save(dep);
            return "succées";
        }
        return "echoue";
    }

    @Override
    public String DeleteDepartement(Long id) {
        Departement dep =  departementRepo.findById(id).orElse(null);
        if(dep!=null){
            departementRepo.deleteById(id);
            return "succées";
        }
        return "echoue";

    }
}
