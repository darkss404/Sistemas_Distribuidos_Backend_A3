package principal;

import visao.FrmTelaPrincipal;
import dao.Conexao;
import java.sql.Connection;

public class Principal {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();

        Connection conn = conexao.conectar();

        FrmTelaPrincipal telaPrincipal = new FrmTelaPrincipal();
        telaPrincipal.setVisible(true);
    }
}
