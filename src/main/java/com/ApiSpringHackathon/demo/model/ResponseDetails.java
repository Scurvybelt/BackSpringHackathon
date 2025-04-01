package com.ApiSpringHackathon.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FacturasTimbradas")

public class ResponseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String status;
    private String message;
    private String messageDetail;
    private int httpStatus;
    private String data;
    private String uuid;

    public String getCadenaTimbrado() {
        return cadenaTimbrado;
    }

    public void setCadenaTimbrado(String cadenaTimbrado) {
        this.cadenaTimbrado = cadenaTimbrado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(String fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getSelloCFDI() {
        return selloCFDI;
    }

    public void setSelloCFDI(String selloCFDI) {
        this.selloCFDI = selloCFDI;
    }

    public String getSelloSAT() {
        return selloSAT;
    }

    public void setSelloSAT(String selloSAT) {
        this.selloSAT = selloSAT;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private String qrCode;
    private String cadenaTimbrado;
    private String fechaTimbrado;
    private String selloCFDI;
    private String selloSAT;

        // Getters and setters

}
