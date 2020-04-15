/* Alex Tetervak, Sheridan College, Ontario */
package sheridan.gergess.problem1.data.jdbc;

import org.springframework.stereotype.Service;
import sheridan.gergess.problem1.data.MonitorDataService;
import sheridan.gergess.problem1.model.MonitorForm;

import java.util.List;

@Service
public class MonitorDataServiceJdbcImpl implements MonitorDataService {

    MonitorDataRepositoryJdbc monitorDataRepository;

    public MonitorDataServiceJdbcImpl(MonitorDataRepositoryJdbc repository){
        this.monitorDataRepository = repository;
    }

    public MonitorForm getMonitorForm(int id){
        return monitorDataRepository.getMonitorForm(id);
    }

    public List<MonitorForm> getAllMonitorForms(){
        return monitorDataRepository.getAllMonitorForms();
    }
}
