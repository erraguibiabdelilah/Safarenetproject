package org.sid.springsecurity.ws.dto.communDto;


public class LocationDto {

    private String ref;
//    private FactureDto facture;
//    private ContratDto contrat;

    public ReservationDto getReservationDto() {
        return reservationDto;
    }

    private ReservationDto reservationDto;
    public void setReservationDto(ReservationDto reservationDto) {
        this.reservationDto = reservationDto;
    }





    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

//    public FactureDto getFacture() {
//        return facture;
//    }
//
//    public void setFacture(FactureDto facture) {
//        this.facture = facture;
//    }

//    public ContratDto getContrat() {
//        return contrat;
//    }
//
//    public void setContrat(ContratDto contrat) {
//        this.contrat = contrat;
//    }
}
