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
    public String index(){
        return "Index";
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

    @GetMapping("MonitorDetails/{id}")
    public String monitorDetails(@PathVariable String id, Model model){
        logger.trace("monitorDetails() is called");
        try {
            MonitorForm form = monitorDataService.getMonitorForm(Integer.parseInt(id));
            if (form != null) {
                model.addAttribute("monitor", form);
                return "/MonitorDetails"; // show the monitor data in the form to edit
            } else {
                logger.trace("no data for this id=" + id);
                return "/DataNotFound";
            }
        } catch (NumberFormatException e) {
            logger.trace("the id is missing or not an integer");
            return "monitors/DataNotFound";
        }
    }
}
