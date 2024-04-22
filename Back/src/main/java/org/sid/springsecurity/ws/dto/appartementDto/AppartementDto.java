package org.sid.springsecurity.ws.dto.appartementDto;

import org.sid.springsecurity.ws.dto.communDto.ReservationDto;

import java.util.List;

public class AppartementDto {
    private String code;
    private int superficie;
    private String adresse;
    private double loyerMensuel;

    private List<ReservationDto> reservationDtos;

    public List<ReservationDto> getReservationDtos() {
        return reservationDtos;
    }

    public void setReservationDtos(List<ReservationDto> reservationDtos) {
        this.reservationDtos = reservationDtos;
    }

    private CategoriesAppartementDto categoriesAppartementDto;
    private PropAppartemenetDto propAppartemenetDto;

    public PropAppartemenetDto getPropAppartemenetDto() {
        return propAppartemenetDto;
    }

    public void setPropAppartemenetDto(PropAppartemenetDto propAppartemenetDto) {
        this.propAppartemenetDto = propAppartemenetDto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLoyerMensuel() {
        return loyerMensuel;
    }

    public void setLoyerMensuel(double loyerMensuel) {
        this.loyerMensuel = loyerMensuel;
    }


    public CategoriesAppartementDto getCategoriesAppartementDto() {
        return categoriesAppartementDto;
    }

    public void setCategoriesAppartementDto(CategoriesAppartementDto categoriesAppartementDto) {
        this.categoriesAppartementDto = categoriesAppartementDto;
    }
}
