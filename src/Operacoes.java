import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operacoes {
    private Connection con;
    public Operacoes(Connection con){
        this.con = con;
    }

    public void AdicionaLista() throws SQLException {
        Statement stm = con.createStatement();

        //apagar collums anteriores
        stm.execute("DROP TABLE IF EXISTS produto");

        //adicionar collums
        stm.execute("CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(100) NOT NULL, " +
                "descricao VARCHAR(250), quantidade INT, preco FLOAT, PRIMARY KEY (id)) Engine = InnoDB");
        stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) " +
                "VALUES ('Notebook', 'Marca Samsung', 4, 1500);");
        stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) " +
                "VALUES ('Playstation 5', 'Original Branco', 2, 5500)");
        stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) " +
                "VALUES ('Nintendo Switch', 'Versão de colecionador Pokemon Sword and Shield', 10, 2500)");
        //mostrar estado da lista
        Listar();
        //fechar conncetion
        stm.close();
    }

    public void AtualizaLista() throws SQLException {
        Statement stm = con.createStatement();

        stm.execute("UPDATE produto SET descricao = 'Versão Paraguaia', preco = '100', quantidade = '20'" +
                " WHERE ID = 1");

        //mostrar estado da lista
        Listar();

    }

    public void ApagaLista() throws SQLException {
        //apagar lista
        Statement stm = con.createStatement();

        stm.execute("DELETE FROM produto WHERE ID = 2");

        //mostrar estado da lista
        Listar();
    }

    private void Listar() throws SQLException {
        Statement stm = con.createStatement();
        stm.execute("SELECT * FROM produto");

        ResultSet rst = stm.getResultSet();
        while(rst.next()){
            Integer id = rst.getInt(1);
            String nome = rst.getString(2);
            String descricao = rst.getString(3);
            Integer quantidade = rst.getInt(4);
            Double preco = rst.getDouble(5);
            System.out.println("\n------------");
            System.out.println("ID: " + id);
            System.out.println("------------");
            System.out.println("NOME: " + nome);
            System.out.println("------------");
            System.out.println("DESCRIÇÃO: " + descricao);
            System.out.println("------------");
            System.out.println("QUANTIDADE: " + quantidade);
            System.out.println("------------");
            System.out.println("PREÇO: " + preco);
            System.out.println("------------");
        }
    }
}
