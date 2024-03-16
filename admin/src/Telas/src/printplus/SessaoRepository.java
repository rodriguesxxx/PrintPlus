/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printplus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessaoRepository {
            
    private Statement st;
    
    public SessaoRepository() {
        try {
            Connection conexao = Conexao.getConexao();
            st = conexao.createStatement();
        } catch(Exception e) {
            //
        }
    }
    
    public List<SessaoDTO> selectAll() {
        String SELECT_SQL = "SELECT * FROM sessions";
        List<SessaoDTO> sessao = new ArrayList<>();
        try {
           ResultSet rt = st.executeQuery(SELECT_SQL);
           while(rt.next()) {
                sessao.add(new SessaoDTO(rt.getString("session_id"), rt.getString("data"), rt.getString("qtd_arquivos")));
           }
           return sessao;
        } catch (Exception e) {
            return null;
        }
    }
    
    public void update(String session_id, String novoId, String data, int qtdArquivos) {
        String UPDATE_SQL = String.format("UPDATE sessions SET session_id = '%s', data = '%s', qtd_arquivos = '%d'  WHERE session_id = '%s'",
            session_id,
            novoId,
            data,
            qtdArquivos);
        try {
            st.executeUpdate(UPDATE_SQL);
        } catch(Exception e) {
            
        }
    }
    
     public void delete(String session_id) {
        String UPDATE_SQL = "DELETE FROM sessions WHERE session_id = '"+session_id+"'";
        try {
            st.execute(UPDATE_SQL);
        } catch(Exception e) {
            
        }
    }
    
}
