/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git;

import java.util.ArrayList;
import java.util.Scanner;


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
    @SuppressWarnings("null")
    public static void main(String[] args) {

        System.out.println("### SIMULACION GIT ###\n");
        int menu;
        menu = 1;
        int repo;
        repo = 0;
        int fecha;
        fecha=0;
        int rM = 0;
        int rDia = 0;
        int rMes = 0;
        int rAno = 0;
        String rAutor;
        String rNombre;
        String rContenido;
        Archivo arch;
        ArrayList<String> lista;
        int rLista=0;
        Repositorio repositorio = null;
        Scanner respuesta= new Scanner(System.in);
        while(menu==1){
            if(repo ==0){
                System.out.println("Para empezar es necesario crear un repositorio.\n");
                System.out.println("Desea realizarlo\n");
                System.out.println("1.Si         0.No\n");
                rM= respuesta.nextInt();
                if(rM != 1){
                    System.out.println("Simulacion terminada\n");
                    menu=0;
                }
                else{
                    System.out.println("Favor de ingresar un nombre para el nuevo repositorio:\n");
                    rNombre= respuesta.next();
                    System.out.println("Favor de ingresar un autor para el nuevo repositorio:\n");
                    rAutor= respuesta.next();
                    repositorio= new Repositorio(rNombre, rAutor);
                    System.out.println("GitInit completado.\n");
                    repo=1;
                }
            }
            if(menu !=0 && repo ==1){
                System.out.println("Escoja una operacion:\n");
                System.out.println("0.Agregar archivo a workspace\n");
                System.out.println("1.add\n");
                System.out.println("2.commit\n");
                System.out.println("3.pull\n");
                System.out.println("4.push\n");
                System.out.println("5.status\n");
                System.out.println("6.log\n");
                System.out.println("7.Salir\n");
                rM= respuesta.nextInt();
                if(fecha ==0 && rM != 7){
                    System.out.println("Ingrese dia:\n");
                    rDia= respuesta.nextInt();
                    System.out.println("Ingrese mes:\n");
                    rMes= respuesta.nextInt();
                    System.out.println("Ingrese ano:\n");
                    rAno= respuesta.nextInt();
                    fecha=1;
                }
                switch (rM) {
                    case 0:
                        System.out.println("Favor de ingresar un nombre para el nuevo archivo:\n");
                        rNombre= respuesta.next();
                        System.out.println("A continuacion escriba el contenido de su archivo:\n");
                        rContenido= respuesta.next();
                        arch= new Archivo(rNombre, rDia, rMes, rAno, rContenido);
                        repositorio.agregarArchivo(arch);
                        break;
                    case 1:
                        System.out.println("Favor de ingresar la cantidad de archivos a pasar al Index:\n");
                        rLista= respuesta.nextInt();
                        lista= new ArrayList<>();
                        for(int i=0; i<rLista; i++){
                            System.out.println("Favor de ingresar la cantidad de archivos a pasar al Index:\n");
                            rNombre= respuesta.next();
                            lista.add(rNombre);
                        }
                        repositorio.add(lista);
                        System.out.println("GitAdd completado.\n");
                        break;
                    case 2:
                        System.out.println("Favor de ingresar un mensaje para el nuevo commit:\n");
                        rNombre= respuesta.next();
                        repositorio.newCommit(rNombre, rDia, rMes, rAno);
                        System.out.println("GitCommit completado.\n");
                        break;
                    case 3:
                        repositorio.pull();
                        System.out.println("GitPull completado.\n");
                        break;
                    case 4:
                        repositorio.push();
                        System.out.println("GitPush completado.\n");
                        break;
                    case 5:
                        repositorio.status();
                        break;
                    case 6:
                        repositorio.log();
                        break;
                    default:
                        menu=0;
                        System.out.println("Simulacion terminada\n");
                        break;
                }
            }
        }
    }
    
}
 