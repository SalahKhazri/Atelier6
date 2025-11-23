package gestionabscence.DTOs;

import java.time.LocalDate;

public record EtudiantUpdate(
        String nom,
        String prenom,
        LocalDate date,
        String classe
) {
}
