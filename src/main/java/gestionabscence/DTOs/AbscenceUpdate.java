package gestionabscence.DTOs;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.util.Date;

public record AbscenceUpdate(
        String module,
        LocalDate date_abscence
) {
}
