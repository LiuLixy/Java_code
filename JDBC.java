import java.sql.*;

public class JdbcDemo {
    public static void jdbcStep() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            // 连接数据库
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/scott?user=root&password=xyxy&useSSL=true");
            // 创建命令
            statement = connection.prepareStatement(
                    "select deptno, ename, sal from emp where deptno=?"
            );
            // 查询
            resultSet = ((PreparedStatement) statement).executeQuery(
                    "select deptno, ename, sal from emp where deptno=20"
            );
            while (resultSet.next()) {
                int deptno = resultSet.getInt("deptno");
                String ename = resultSet.getString("ename");
                float sal = resultSet.getFloat("sal");

                String row = String.format(
                        "deptno = %d, ename = %s, sal = %f",
                        deptno, ename, sal
                );
                System.out.println(row);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        jdbcStep();
    }
}