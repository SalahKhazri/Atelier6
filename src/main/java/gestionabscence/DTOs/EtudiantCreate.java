package gestionabscence.DTOs;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record EtudiantCreate(

        String nom,
        String prenom,
        LocalDate date,
        String classe

) {
}
