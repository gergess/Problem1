/* Alex Tetervak, Sheridan College, Ontario */
package sheridan.gergess.problem1.data.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import sheridan.gergess.problem1.model.MonitorForm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MonitorDataRepositoryJdbcImpl implements MonitorDataRepositoryJdbc {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public MonitorDataRepositoryJdbcImpl(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate,
            JdbcTemplate jdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public MonitorForm getMonitorForm(int id) {
        String query = "SELECT * FROM monitor WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        MonitorForm form = null;
        params.put("id", id);
        try {
            form = namedParameterJdbcTemplate.queryForObject(query, params, new MonitorFormMapper());
        } catch (DataAccessException e) {
            // the code above throws an exception if the record is not found
        }
        return form;
    }

    @Override
    public List<MonitorForm> getAllMonitorForms() {
        return jdbcTemplate.query("SELECT * FROM monitor", new MonitorFormMapper());
    }

    private static final class MonitorFormMapper implements RowMapper<MonitorForm> {

        @Override
        public MonitorForm mapRow(ResultSet rs, int rowNum) throws SQLException {
            MonitorForm form = new MonitorForm();
            form.setId(rs.getInt("id"));
            form.setInches(rs.getInt("inches"));
            form.setName(rs.getString("name"));
            form.setRefreshRate(rs.getInt("refreshRate"));
            return form;
        }
    }

}
