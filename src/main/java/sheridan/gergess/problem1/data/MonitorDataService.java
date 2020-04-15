package sheridan.gergess.problem1.data;

import sheridan.gergess.problem1.model.MonitorForm;

import java.util.List;

public interface MonitorDataService {

    List<MonitorForm> getAllMonitorForms();

    MonitorForm getMonitorForm(int id);
}
