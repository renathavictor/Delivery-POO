package aplicacao_console;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
 
public class testeData {
 
    public static void main(String[] args) {
 
        System.out.println("\n----Objetos para datas");
        LocalDate hoje =    LocalDate.now();                            // data curta do computador
        LocalDate natal =   LocalDate.parse("2018-12-25");              // formato obrigatorio
        //LocalDate natal = LocalDate.of(2018,Month.DECEMBER,25);       // alternativa
        LocalDate vesperaAnoNovo = natal.plusWeeks(1).minusDays(1);     // o objeto da variavel natal nao se modifica
        LocalDateTime agora = LocalDateTime.now();                      // data completa do computador
        LocalDateTime papaiNoel = LocalDateTime.parse("2018-12-25T23:59:00");
        //LocalDateTime papaiNoel = LocalDateTime.of(2018,Month.DECEMBER,25,23,59,0); //alternativa 
        
        System.out.println(agora.getDayOfMonth());
         
//        DateTimeFormatter formatador1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("EEEE, dd  MMMM  yyyy");
//        DateTimeFormatter formatador3 = DateTimeFormatter.ofPattern("dd/MM/yyyy '-' HH:mm:ss");
//        System.out.println("hoje= "+hoje.format(formatador1));
//        System.out.println("natal= "+natal.format(formatador1));    
//        System.out.println("vespera de ano novo= "+vesperaAnoNovo.format(formatador2));
//        System.out.println("agora= "+agora.format(formatador3));
//        System.out.println("papai noel= "+papaiNoel.format(formatador3));
// 
//         
//        System.out.println("\n----Acessar partes da data");
//        System.out.println("ano=" + hoje.getYear());
//        System.out.println("mes=" + hoje.getMonthValue());
//        System.out.println("mes=" + hoje.getMonth());
//        System.out.println("dia do mes=" + hoje.getDayOfMonth());
//        System.out.println("dia da semana=" + hoje.getDayOfWeek());
//        System.out.println("dia da semana=" + hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
     
         
//        System.out.println("\n----Diferença de data entre hoje e natal");
//        Period p = Period.between(hoje, natal);
//        int dias = p.getDays();
//        int meses = p.getMonths();
//        int anos = p.getYears();
//        System.out.println("periodo= "+anos+"anos, "+meses+"meses, "+dias+"dias ");
//     
//         
//        System.out.println("\n----Diferença de horario entre meiodia e agora");
//        LocalTime meiodia = LocalTime.parse("12:00:00");
//        //LocalTime meiodia = LocalTime.of(12,0,0);             //alternativa
//        Duration d = Duration.between(meiodia, agora);
//        long horas = d.toHours();
//        long minutos = d.toMinutes();
//        System.out.println("duração em horas=" + horas+"  ou em minutos="+minutos);
// 
//         
//        System.out.println("\n----------------------------------------------");
//        System.out.println("Conversao classe Date (Java 1) para LocalDate");
//        Date dt = new Date();   
//        System.out.println(dt);
//        hoje = dt.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
//        System.out.println(hoje);
//         
//        System.out.println("\nConversao classe GregorianCalendar (java 1.1) para LocalDate");
//        GregorianCalendar c = new GregorianCalendar();
//        System.out.println(c);
//        dt = c.getTime();       //GregorianCalendar para Date   
//        hoje = dt.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
//        System.out.println(hoje);
//        System.out.println("----------------------------------------------");
// 
//        System.out.println("\nData do computador em mseg = "+System.currentTimeMillis());
//        long i = papaiNoel.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        System.out.println("Data do papai noel em mseg = "+i);
 
    }
     
}