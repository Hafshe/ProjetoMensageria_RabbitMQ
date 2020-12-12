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
public class Fatura {

    private String numero;
    private String vencimento;
    private String valor;

    public Fatura(String numero, String vencimento, String valor) {
        this.numero = numero;
        this.vencimento = vencimento;
        this.valor = valor;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}