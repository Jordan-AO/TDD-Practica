/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd.practica1;



public class Main {

   public static void main(String argv[]) {

    Sujeto objetoA = new Proxy("objetoA");
    Cliente c = new Cliente(objetoA);
    objetoA.status(objetoA);
       System.out.println("Siguiente");
    c.ejecutar();
    objetoA.status(objetoA);

  
    Sujeto objetoB = new SujetoReal("objetoB");
    Cliente d = new Cliente(objetoB);
    
    d.ejecutar();
  }

}
