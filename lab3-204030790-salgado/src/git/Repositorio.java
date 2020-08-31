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
public class Repositorio {
    String autor;
    //Arreglo con las modificaciones
    Index index;
    Workspace workspace;
    LocalRepository localRepository;
    RemoteRepository remoteRepository;
    public Repositorio(String autor){
        this.index= new Index();
        this.workspace= new Workspace();
        this.localRepository= new LocalRepository();
        this.remoteRepository= new RemoteRepository();
        this.autor= autor;  
    }
    
}
