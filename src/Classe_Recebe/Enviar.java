/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe_Recebe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 *
 * @author Rafaella.almeida.ad.OUROLAC
 */
public class Enviar {

    private final static String NOME_FILA = "nota_fiscal";

    public static void main(String[] args) throws Exception {
        
        //String[] vs = {"", ""};     
        String mensagem = 
            "000.162.264;"
            + "001;"
            + "Venda Mercadoria/Venda Mercadoria ;"
            + "000.000.000-00;"
            + "Ourolac Industria de Alimentos/SA;"
            + "111.111.111-11;"
            + "Al Contorno, SN-QD 35, LT 10/11;"
            + "Centro;"
            + "75.914-600;"
            + "Rio Verde;"
            + "3614-8270;"
            + "GO;"
            + "000001/1;"
            + "11/12/2020;"
            + "3455,00;"
            + "MPJ Transportes;"
            + "222.222.222-22;"
            + "ABC-1234;"
            + "Rua Presidente Vargas;"
            + "Rio Verde;"
            + "GO;"
            + "12;"
            + "Caixas;"
            + "26,4kg";  
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        
        //tutorial
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare(NOME_FILA, false, false, false, null);
            channel.basicPublish("", NOME_FILA, null, mensagem.getBytes());         
            System.out.println("Enviado.");
        }
    }
}