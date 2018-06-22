import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemoGroupJdbc {

    private JdbcUtil jdbcUtil;

    public MemoGroupJdbc(JdbcUtil jdbcUtil) {
        this.jdbcUtil = jdbcUtil;
    }

    public int createMemoGroup(MemoGroup memoGroup) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = jdbcUtil.connection();
            // ? 表示通配符
            String sql = "insert into memo_group (title, group_id, create_time) values (?,?,?))";
            statement = jdbcUtil.preparedStatement(connection, sql);
            if (statement == null) {
                return 0;
            }
            try {
                statement.setString(1, memoGroup.getTitle());
                statement.setInt(2, memoGroup.getGroupId());
                statement.setDate(3, memoGroup.getCreateTime());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.jdbcUtil.close(null, statement, connection);
        }
        return 0;
    }

    public int modifyMemoGroupName(int id, String name) {
        return 0;
    }

    public static void main(String[] args) {
        JdbcUtil jdbcUtil = new JdbcUtil("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/memo?user=root&password=xyxy&useSSL=true");
        MemoGroupJdbc memoGroupJdbc = new MemoGroupJdbc(jdbcUtil);
        MemoGroup memoGroup = new MemoGroup();
        memoGroup.setTitle("Java便签");
        memoGroup.setGroupId(1);
        memoGroup.setCreateTime(new Date(System.currentTimeMillis()));
        int result = memoGroupJdbc.createMemoGroup(memoGroup);
        System.out.println(result);
    }
}