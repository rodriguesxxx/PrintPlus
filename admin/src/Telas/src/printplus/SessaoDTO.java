/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printplus;

/**
 *
 * @author rodriguesxxx
 */
public class SessaoDTO {
    
    public String session_id;
    public String data;
    public String qtdArquivos;

    public SessaoDTO() {}

    public SessaoDTO(String session_id, String data, String qtdArquivos) {
        this.session_id = session_id;
        this.data = data;
        this.qtdArquivos = qtdArquivos;
    }
    
}
