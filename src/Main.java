import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();
        Operacoes operacoes = new Operacoes(con);
        int opcao = 42; //a resposta pra tudo no universo
        while (opcao != 0) {
            System.out.println("-----MENU-----");
            System.out.println("Para adicionar os itens a lista, digite 1");
            System.out.println("Para atualizar o primeiro item da lista, digite 2");
            System.out.println("Para apagar o segundo item da lista, digite 3");
            System.out.println("Para encerrar o programa, digite 0");
            Scanner scan = new Scanner(System.in);
            opcao = scan.nextInt();
            switch(opcao){
                case 1:
                    operacoes.AdicionaLista();
                    break;
                case 2:
                    operacoes.AtualizaLista();
                    break;
                case 3:
                    operacoes.ApagaLista();
                    break;
            }
        }
    }
}
