package gestionabscence.DTOs;

public class EtudiantForm {
    private String nom;
    private String prenom;
    private String classe;
    private String date;

    public EtudiantForm() {}

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getClasse() { return classe; }
    public void setClasse(String classe) { this.classe = classe; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
