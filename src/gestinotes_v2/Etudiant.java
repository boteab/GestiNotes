package gestinotes_v2;

/**
 *
 * @authors :  Apostu Robert et Mario Huaracha
 */
public class Etudiant implements Facture{
    //attributs
    private String codePermanent;
    private String nom;
    private String prenom;
    private int anneeNaissance;
    private double note ;

    //Accesseurs
    public String getCodePermanent(){
        return codePermanent;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public int getAnneeNaissance(){
        return anneeNaissance;
    }

    public double getNote(){
        return note;
    }

    //Mutateurs
    public void setCodePermanent(String unCodePermanent){
        codePermanent = unCodePermanent;
    }

    public void setNom(String unNom){
        nom = unNom;
    }

    public void setPrenom(String unPrenom){
        prenom = unPrenom;
    }

    public void setAnneeNaissance(int uneAnneeNaissance)throws Exception{
        anneeNaissance = uneAnneeNaissance;
        if(anneeNaissance<2009)
            throw new Exception("Attention! Votre enfant a plus que 10 ans.");
    }

    public void setNote(double uneNote)throws Exception{
        note = uneNote;
        if (note>0 && note<100)
            throw new Exception("Attention! Note invalide.");
    }

    //constructeurs
    public Etudiant (String unCodePermanent,String unNom, String unPrenom, int uneAnneeNaissance, double uneNote ){
        codePermanent = unCodePermanent;
        nom = unNom;
        prenom = unPrenom;
        anneeNaissance = uneAnneeNaissance;
        note = uneNote;
    }

    public Etudiant(){
    }

    //Methodes
    //Retourne si c'est un succes ou non
    public boolean isSucces(){
        final int SEUIL_REUSSITE = 60;
        return (note >= SEUIL_REUSSITE);
    }

    //Retourne la note littérale d'un étudiant
    public char noteLitterale(){
        final int LIMITE1 = 0;
        final int LIMITE2 = 40;
        final int LIMITE3 = 60;
        final int LIMITE4 = 80;
        final int LIMITE5 = 100;
        try{
            if ( (note >= LIMITE1) && (note <= LIMITE2) )
                return 'D';
            else
            if ( (note >LIMITE2) && (note <= LIMITE3) )
                return 'C';
            else
            if ( (note > LIMITE3) && (note <= LIMITE4) )
                return 'B';
            else
            if ( (note >LIMITE4) && (note <= LIMITE5) )
                return 'A';
            else
                return ' '; // car exige un return
        }catch(Exception e){
            System.out.println(e.getMessage());
        }return ' ';
    }
    //Retourne les informations d'un eleve
    public String toString(){
        String informations;
        informations = "\nCode permanent: " + codePermanent + " - Nom: " + nom + " - Prenom: " + prenom + " - Annee de naissance: " + anneeNaissance + " - Note: " + note ;
        return informations;
    }

    @Override
    public double facturer(){
        return MONTANT;
    }

    //Test avec un main
    public static void main (String[] args){
        Etudiant unEtudiant = new Etudiant("AA", "aa", "aa", 9999, 80);
        //Affichage des attributs
        System.out.println("Code permanent: " + unEtudiant.getCodePermanent());
        System.out.println("Nom: " +unEtudiant.getNom());
        System.out.println("Prenom: " +unEtudiant.getPrenom());
        System.out.println("Année de naissance: " +unEtudiant.getAnneeNaissance());
        System.out.println("Note: " +unEtudiant.getNote());

        //Affichage des méthodes
        System.out.println("Succès:" + unEtudiant.isSucces());
        System.out.println("Note littérale:" + unEtudiant.noteLitterale());
        System.out.println("Informations de l'élève:" + unEtudiant.toString());
    }
}