package ua.george_nika.lift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.george_nika.lift.exception.NoSolutionException;
import ua.george_nika.lift.model.Situation;
import ua.george_nika.lift.service.SolutionService;
import ua.george_nika.lift.service.StartService;

import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    StartService startService;

    @Autowired
    SolutionService solutionService;

    @RequestMapping("/")
    public String main (){
        if (startService.checkSituation(startService.getStartSituation())){
            return "main";
        }else {
            return "nosolution";
        }
    }

    @RequestMapping("/findSolution")
    public String findSolution (Model model){
        try {
            Situation startSituation = startService.getStartSituation();
            LinkedList<Situation> solution = solutionService.findSolution(startSituation);
            solution.removeLast();
            model.addAttribute("solution", solution);
            return "solution";
        }catch (NoSolutionException ex){
            return "nosolution";
        }
    }
}
