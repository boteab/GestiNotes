package gestinotes_v2;


/**
 *
 * @author usager
 */
public class EtudiantDifficulte extends Etudiant implements Facture{
    private String troubleDiag;
    private int coteT;
    public  EtudiantDifficulte(String codePermanent, String nom, String prenom, int anneeNaissance, double note, int coteT, String troubleDiag){
        super(codePermanent,nom,prenom,anneeNaissance,note);
        this.coteT = coteT;
        this.troubleDiag = troubleDiag;
    }

    public int getCoteT(){
        return coteT;
    }

    @Override
    public boolean isSucces(){
        final int SEUIL_REUSSITE = 50;
        boolean message1 = true;
        boolean message2 = false;
        if(coteT <= 5 && getNote() >= SEUIL_REUSSITE)
            return message1;
        else
            return message2;
    }

    @Override
    public String toString(){
        return super.toString() + " - Trouble diagnostiqué: " + troubleDiag + " - Cote de trouble: " + coteT;
    }

    @Override
    public double facturer(){
        double factureAnnuelle;
        factureAnnuelle = MONTANT + (coteT*(MONTANT * TAUX));
        return factureAnnuelle;
    }

    //Test dans un main
    public static void main(String[]args){
        EtudiantDifficulte unEtuDiff = new EtudiantDifficulte("API123", "aa", "aa", 2001, 50, 5,"aaa");

        System.out.println("Code permanent: "+unEtuDiff.getCodePermanent());
        System.out.println("Nom: " +unEtuDiff.getNom());
        System.out.println("Prénom: " +unEtuDiff.getPrenom());
        System.out.println("Année de naissance :" +unEtuDiff.getAnneeNaissance());
        System.out.println("Note: "+unEtuDiff.getNote());
        System.out.println("Trouble: "+unEtuDiff.troubleDiag);
        System.out.println("Cote T: "+unEtuDiff.getCoteT());
        try{
            System.out.println("Facture :" +unEtuDiff.facturer());
            System.out.println("Succès: "+unEtuDiff.isSucces());
            System.out.println("Note littérale: "+unEtuDiff.noteLitterale());
            System.out.println("Informations de l'élève: "+unEtuDiff.getCoteT());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
