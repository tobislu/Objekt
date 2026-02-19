package oving4;

public class Partner {
    private String name;
    private Partner partner; //referer til Partner-objektet

    public Partner(String name) { // Etter metoden har kjørt skal getPartner enten være null eller p.getPartner() == q -> q.getPartner() == p
        if (name == null) {
            throw new IllegalArgumentException("Navn må være ulik null");
        }
        this.name = name;
        this.partner = null; // starter uten partner
    }

    

    public String getName(){
        return this.name;
    }

    public Partner getPartner(){
        return this.partner;
    }

    public void setPartner(Partner newPartner) {

        // Hvis samme partner allerede -> gjør ingenting
        if (this.partner == newPartner) {
            return;
        }

        // Hvis jeg har en gammel partner -> koble fra
        if (this.partner != null) {
            Partner oldPartner = this.partner; // lagrer partner som oldPartner, deretter setter egen partner til null (unngå rekusjon)
            this.partner = null;
            oldPartner.setPartner(null);
        }

        // Hvis ny partner ikke er null -> koble sammen
        if (newPartner != null) {

            // Hvis ny partner allerede har partner -> koble fra den
            if (newPartner.partner != null) {
                newPartner.setPartner(null);
            }

            this.partner = newPartner;
            newPartner.partner = this; // oppdaterer partnere symetrisk
        }
    }

    public static void main(String[] args) {
        
    }  

    @Override
    public String toString() {
        if (partner == null) {
            return name + " har ingen partner";
        }
        return name + " er partner med " + partner.name;
    }
}
