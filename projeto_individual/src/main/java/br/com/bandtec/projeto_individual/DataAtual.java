package br.com.bandtec.projeto_individual;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataAtual {
    Date d;
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public DataAtual(Date d){
        this.d = d;
    }
    public String getDataHora(){
        return formatoData.format(d);
    }
    public String getDiaSemana(){
     String diaSemana = "";
     switch(d.getDay()){
         case 0:
             diaSemana = "Domingo";
             break;
         case 1:
             diaSemana = "Segunda-Feira";
             break;
         case 2:
             diaSemana = "Terça-Feira";
             break;
         case 3:
             diaSemana = "Quarta-Feira";
             break;
         case 4:
             diaSemana = "Quinta-Feira";
             break;
         case 5:
             diaSemana = "Sexta-Feira";
             break;
         case 6:
             diaSemana = "Sabado";
             break;
         default:
             break;
     }
     return diaSemana;
    }
}
