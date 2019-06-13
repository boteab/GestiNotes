package gestinotes_v2;

/**
        *
        * @author usager
        */
public class EtudiantAdaptation extends Etudiant {
    private String historiqueIncident;
    private int coteS;
    public  EtudiantAdaptation(String codePermanent, String nom, String prenom, int anneeNaissance, double note, int coteS, String historiqueIncident){
        super(codePermanent,nom,prenom,anneeNaissance,note);
        this.coteS = coteS;
        this.historiqueIncident = historiqueIncident;
    }

    @Override
    public boolean isSucces(){
        final int SEUIL_REUSSITE = 55;
        boolean message1 = true;
        boolean message2 = false;
        if(coteS <= 2 && getNote()>= SEUIL_REUSSITE)
            return message1;
        else
            return message2;
    }
    @Override
    public String toString(){
        return super.toString() + " - l'historique des incidents: " + historiqueIncident + " - Sévérité des incidents : " + coteS;
    }
    @Override
    public double facturer(){
        double factureAnnuelle;
        factureAnnuelle = MONTANT + (coteS*(MONTANT * (2*TAUX)));
        return factureAnnuelle;
    }

    //Test avec un main
    public static void main(String[]args){
        EtudiantAdaptation unEtuAdap = new EtudiantAdaptation("API123", "aa", "aa", 2001, 55, 4,"aaa");

        try{
            System.out.println("Facture :" +unEtuAdap.facturer());
            System.out.println("Succès: "+unEtuAdap.isSucces());
            System.out.println("Informations de l'élève: "+unEtuAdap.toString());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

