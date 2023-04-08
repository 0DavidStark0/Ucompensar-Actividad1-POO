package poo_2023.actividad1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class POO_Actividad1 {

    final static ArrayList nombres = new ArrayList();
    final static ArrayList notas = new ArrayList();
    
    public static void main(String[] args) {
        double sumaNotas = 0, promedio = 0;
        
        try {
            int cantEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Cuantos estudiantes desea registrar"));
            setNotas(cantEstudiantes);

            for(Object nota: notas){
                sumaNotas += (double)nota;
            }
            promedio = sumaNotas / notas.size();

            System.out.println("El promedio del curso es: " + String.format("%.2f", promedio)+"\n"
                                            + "Los estudiante abajo del promedio son:");

            for(int i = 0; i < nombres.size(); i++){
                if ((double)notas.get(i) < promedio){
                    System.out.println("Nombre: "+ nombres.get(i)
                                        + " Nota: "+notas.get(i));
                }
            }
            System.out.println(notas + " -> " + nombres);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static String setNombre (){
        String nombre;
        
        try {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
            nombres.add(nombre);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    public static double setNotas (int cantEstudiantes){
        double nota;
        
        try {
            for(int i = 0; i < cantEstudiantes; i++){
                setNombre();
                nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nota del estudiante"));

                if(nota >= 1 && nota <= 10){
                    notas.add(nota);
                }else{
                    JOptionPane.showMessageDialog(null, "No se hizo el registro \n Ingrese una nota entre 1 y 10");
                    nombres.remove(i);
                    i -= 1; 
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return 0;
    }
    
}
