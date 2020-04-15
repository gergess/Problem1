/* Alex Tetervak, Sheridan College, Ontario */

package sheridan.gergess.problem1.data.jdbc;

import sheridan.gergess.problem1.model.MonitorForm;

import java.util.List;

public interface MonitorDataRepositoryJdbc {
    MonitorForm getMonitorForm(int id);
    List<MonitorForm> getAllMonitorForms();
}
