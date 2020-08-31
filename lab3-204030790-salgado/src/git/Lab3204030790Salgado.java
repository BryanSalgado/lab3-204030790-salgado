/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git;


/**
 *
 * @author Bryan
 */
public class Lab3204030790Salgado {

    /**
     * @param args the command line arguments
     * El TDA que se aplicará consiste en una diversar clases que representarán las distintas zonas y commmits
     * Existirán 4 clases que representarán las zonas: Workspace, Index, Local Repository y Remote Repository
     * Las clases Local Repository y Remote Repository tendrán acceso a una clase extra llamada Commit
     * Las clases Workspace, Index y Commit tendrán acceso a una clase llamada archivo.
     * Esta última será la contendrá el texto plano en  forma de string
     * Por último existirá una clase llamada Repositorio, está contendra las cuatro zonas
     */
    public static void main(String[] args) {
        Archivo k= new Archivo("Pepa", 20, 4 ,2000, "Bla Bla \nBla");
        Index s= new Index();
        s.setIndex(k);
        Archivo nuevo;
        nuevo= (s.getContenido()).get(0);
        // TODO code application logic here
        System.out.println(nuevo.getNombre());
    }
    
}
 