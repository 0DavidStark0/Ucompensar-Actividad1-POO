package poo_2023.actividad1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class POO_2023Actividad1 {

    public static void main(String[] args) {
        
        ArrayList nombres = new ArrayList();
        ArrayList notas = new ArrayList();
        int bandera = 0, cont = 0;
        double totalNotas = 0, promedio = 0;
        
        while (bandera == 0){
            try {
                System.out.println(nombres);
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
                double nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del estudiante "+nombre));

                if(nota >= 1 && nota <= 10){
                    setNombres(nombre, nombres);
                    SetNotas(nota, notas);
                }else{
                    JOptionPane.showMessageDialog(null,"El registro no fue creado \n"
                                                    + "Ingrese una nota entre 1 y 10");
                }
                bandera = JOptionPane.showConfirmDialog(null, "Desea continuar","Desea continuar", JOptionPane.YES_NO_OPTION);
//              
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
                bandera = JOptionPane.showConfirmDialog(null, "Desea continuar","Desea continuar" , JOptionPane.YES_NO_OPTION);
            }
        }
        
        for(Object nota : notas){
            totalNotas += (double)nota;
        }
        promedio = totalNotas / notas.size();
        System.out.println("El promedio del curso es: "+String.format("%.2f", promedio));
        
        for(int i = 0; i < nombres.size(); i++){
            
            if ((double)notas.get(i) < promedio){
                System.out.println("Nombre: "+ nombres.get(i)
                                    + " Nota: "+notas.get(i));
            }
        }
    }
    
    public static ArrayList setNombres (String nombre, ArrayList nombres){
        try {
             nombres.add(nombre);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        return nombres;
    }
    
    public static ArrayList SetNotas (double nota,ArrayList notas ){
        try {
            notas.add(nota);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        return notas;
    }
    
}
