package gestionabscence.Controllers;

import gestionabscence.DTOs.AbscenceUpdate;
import gestionabscence.DTOs.EtudiantResponse;
import gestionabscence.Entities.Abscence;
import gestionabscence.Entities.Etudiant;
import gestionabscence.Utils.AbscenceService;
import gestionabscence.Utils.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Abscence")
public class AbscenceController {

    private final AbscenceService abscenceService;
    private final EtudiantService etudiantService;

    public AbscenceController(AbscenceService abscenceService, EtudiantService etudiantService) {
        this.abscenceService = abscenceService;
        this.etudiantService = etudiantService;
    }

    // Liste
    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("absences", abscenceService.findAll());
        return "abscence/list";
    }

    // Formulaire ajout
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("abscence", new Abscence());
        model.addAttribute("etudiants", etudiantService.findAll());
        return "abscence/add";
    }



    // Ajouter
    @PostMapping("/add")
    public String add(@ModelAttribute Abscence abscence) {
        abscenceService.ajouterAbsence(abscence);
        return "redirect:/Abscence/all";
    }

    // Formulaire update
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("abs", abscenceService.getAbsencesByEtudiant(id));
        return "abscence/edit";
    }

    // Update
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute AbscenceUpdate dto) {
        abscenceService.updateAbsence(id, dto);
        return "redirect:/Abscence/all";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        abscenceService.deleteAbsence(id);
        return "redirect:/Abscence/all";
    }
}
