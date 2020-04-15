package sheridan.gergess.problem1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import sheridan.gergess.problem1.data.MonitorDataService;
import sheridan.gergess.problem1.model.MonitorForm;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping(value={"/", "/Index"})
    public ModelAndView index(){
        return listMonitors();
    }

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private MonitorDataService monitorDataService;

    public HomeController(
            @Qualifier("monitorDataServiceJdbcImpl") MonitorDataService monitorDataService){
        this.monitorDataService = monitorDataService;
    }


    @GetMapping("/ListMonitors")
    public ModelAndView listMonitors() {
        logger.trace("listMonitors() is called");
        List<MonitorForm> list = monitorDataService.getAllMonitorForms();
        return new ModelAndView("/ListMonitors",
                "monitors", list);
    }

}
