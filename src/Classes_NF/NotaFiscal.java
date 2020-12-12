/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_NF;
/**
 *
 * @author Rafaella.almeida.ad.OUROLAC
 */
public class NotaFiscal {
    
    private String numero;
    private String serie;
    private String natureza;
    private String cnpj;
    private Destinatario destinatario;
    private Fatura fatura;
    private Transportador transportador;

    public NotaFiscal(String numero, String serie, String natureza, String cnpj, Destinatario destinatario, Fatura fatura, Transportador transportador) {
        this.numero = numero;
        this.serie = serie;
        this.natureza = natureza;
        this.cnpj = cnpj;
        this.destinatario = destinatario;
        this.fatura = fatura;
        this.transportador = transportador;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Transportador getTransportador() {
        return transportador;
    }

    public void setTransportador(Transportador transportador) {
        this.transportador = transportador;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public Transportador getTansportador() {
        return transportador;
    }

    public void setTansportador(Transportador transportador) {
        this.transportador = transportador;
    }    
}