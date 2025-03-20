import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
class Main {
 public static void main(String[] args) throws SQLException {
    read();
    update();
    delete();
 }
 public static void read() throws SQLException {
    String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.joqtppeleaprqaajarfa&password=[YOUR-PASSWORD]";
    Connection c = DriverManager.getConnection(url);
    String sql = "SELECT * FROM contas";
    PreparedStatement stm = c.prepareStatement (sql);
    ResultSet rs = stm.executeQuery();
    while (rs.next()) {
        long nro = rs.getLong("nro_conta");
        BigDecimal balance = rs.getBigDecimal("saldo");
        System.out.println("Conta número: " + nro + " tem saldo de R$ " + saldo);
    }
    c.close();
   }
 }

 public static void update() throws SQLException {
    System.out.print("Número de uma conta já existente: ");
    long nro = Long.parseLong(System.console().readLine());
    System.out.print("Novo saldo para esta conta: ");
    BigDecimal saldo = new BigDecimal(System.console().readLine());

    String url = System.getenv("URL");
    String username = System.getenv("USERNAME");
    String password = System.getenv("PASSWORD");

    Connection c = DriverManager.getConnection(url, username, password);
    String sql = "UPDATE contas SET saldo=? WHERE nro_conta=?";
    PreparedStatement prepstm = c.prepareStatement(sql);
    prepstm.setBigDecimal(1, saldo);
    prepstm.setLong(2, nro);

    int ret = prepstm.executeUpdate();
    System.out.println("Saldo atualizado! Registros alterados: " + ret);

    c.close();
}

public static void create() throws SQLException {
    System.out.print("Número para a nova conta: ");
    long nro = Long.parseLong(System.console().readLine());
    System.out.print("Saldo inicial: ");
    BigDecimal saldo = new BigDecimal(System.console().readLine());

    String url = System.getenv("URL");
    String username = System.getenv("USERNAME");
    String password = System.getenv("PASSWORD");

    Connection c = DriverManager.getConnection(url, username, password);
    String sql = "INSERT INTO contas (nro_conta, saldo) VALUES (?, ?)";
    PreparedStatement prepstm = c.prepareStatement(sql);
    prepstm.setLong(1, nro);
    prepstm.setBigDecimal(2, saldo);

    int ret = prepstm.executeUpdate();
    System.out.println("Conta criada com sucesso! Registros inseridos: " + ret);
    
    c.close();
}

public static void delete() throws SQLException {
    System.out.print("Número da conta a ser deletada: ");
    long nro = Long.parseLong(System.console().readLine());

    String url = System.getenv("URL");
    String username = System.getenv("USERNAME");
    String password = System.getenv("PASSWORD");

    Connection c = DriverManager.getConnection(url, username, password);
    String sql = "DELETE FROM contas WHERE nro_conta=?";
    PreparedStatement prepstm = c.prepareStatement(sql);
    prepstm.setLong(1, nro);

    int ret = prepstm.executeUpdate();
    System.out.println("Conta removida! Registros apagados: " + ret);

    c.close();
}


