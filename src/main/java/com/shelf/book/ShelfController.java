
package com.shelf.book;

import army.*;

import ninja.turtle.NinjaTurtle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ShelfController {

    @RequestMapping("/")
    @ResponseBody
    public String home(){
        String htmlStr = "";
        htmlStr += "<a href=\"/shelf\">shelf</a>&emsp;<a href=\"army\">army</a>&emsp;<a href=\"jimi\">jimi</a>&emsp;<a href=\"tmnt\">ninja turtles</a>";

        return htmlStr;
    }

    @GetMapping("/shelf")
    @ResponseBody
    public String shelf(@RequestParam(name="name", required=false, defaultValue="medici") String name, Model model){
        model.addAttribute("name", name);

        //create java vars
        Library lib = new Library();

        //print to html
        String outStr = "";
        for(Novel n: lib.getLibraryAsList()){
            outStr += n.getTitle().toUpperCase() + " by " + n.getAuthor() + "<br>\"" + n.getText() + "\"<br><br>";
        }
        outStr += "<a href=\"/\">home</a>";
        return outStr;
    }

    @GetMapping("/army")
    @ResponseBody
    public String army(){
        //create java vars
        Unit charlieCo = new Company("Charlie");
        Unit platoon2 = charlieCo.getSubUnits().get(1);
        Unit bravoSquad = platoon2.getSubUnits().get(1);

        //print to html
        String outStr = "";
        outStr += charlieCo.lineUp().replaceAll("\n", "<br>").replaceAll("\t", "&emsp;");
        outStr += "<br><br><a href=\"/\">home</a><br>";

        return outStr;
    }

    @GetMapping("/jimi")
    @ResponseBody
    public String jimi(){
        return "<img src=\"/resources/tank/jimi.jpg\" ></img><br><a href=\"/\">home</a>";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(HttpServletRequest request){
        //get name param
        String name = request.getParameter("name");
        if(name == null){ name = "World"; }

        return "<h1>Hello " + name + "!</h1><br><a href=\"/\">home</a>";
    }

    @RequestMapping(value = "/tmnt", method = RequestMethod.GET)
    public String tmntform(){
        return "ninjaTurtleForm";
    }

    @RequestMapping(value = "/tmnt", method = RequestMethod.POST)
    public String tmnt(HttpServletRequest request, Model model){
        //get name param
        String name = request.getParameter("name");

        //name attr
        model.addAttribute("artist", name);

        //create nt based on name
        NinjaTurtle nt = new NinjaTurtle(name);

        //get individual attributes
        model.addAttribute("ntName", nt.getName());
        model.addAttribute("ntColor", nt.getColor());
        model.addAttribute("ntWeapon", nt.getWeapon());

        model.addAttribute("ntMasterPiece", nt.getMp());

        return "ninjaTurtle"; //ninjaTurtle.html
    }
}
