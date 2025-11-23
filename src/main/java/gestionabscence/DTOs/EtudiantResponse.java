package gestionabscence.DTOs;

import java.time.LocalDate;

public record EtudiantResponse(
        Long idEtudiant,
        String nom,
        String prenom,
        LocalDate date,
        String classe,
        Long departementId
) {}
