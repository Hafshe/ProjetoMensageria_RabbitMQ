/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_XML;

import Classes_NF.Destinatario;
import Classes_NF.Fatura;
import Classes_NF.NotaFiscal;
import Classes_NF.Transportador;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
/**
 *
 * @author Rafaella.almeida.ad.OUROLAC
 */
public class Receber {
    
    private final static String QUEUE_NAME = "nota_fiscal"; 

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. Stop it manually");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            if (!message.isEmpty()) {
                QuebrarMensagem(message);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }

    public static void QuebrarMensagem(String msg) {
        String[] str = msg.split(";");
       
        Destinatario destinatario = new Destinatario(
                str[4],
                str[5],
                str[6],
                str[7],
                str[8],
                str[9],
                str[10],
                str[11]
        );

        Fatura fatura = new Fatura(
                str[12],
                str[13],
                str[14]
        );

        Transportador transportador = new Transportador(
                str[15],
                str[16],
                str[17],
                str[18],
                str[19],
                str[20],
                str[21],
                str[22],
                str[23]
        );

        NotaFiscal nota_fiscal = new NotaFiscal(str[0], str[1], str[2], str[3], destinatario, fatura, transportador);
        
        CriarXML criarXml = new CriarXML();
               
        //String s = manipulaXml.;
        //manipulaXml.gerarArquivo(transformeEmStringXml(Obj));
        criarXml.gerarArquivo(
                criarXml.transformeEmStringXml(nota_fiscal)
        );
    }
}
