package by.internetbanking.controller;

import by.internetbanking.entity.Person;
import by.internetbanking.repository.PersonRepository;
import by.internetbanking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping(value = "/mvc")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "repo", method = RequestMethod.GET)
    public String perexodVrepositiry (ModelMap model) {
        Iterable<Person> people = personRepository.findAll();
        model.addAttribute("adminList", people);
        System.out.println("u");
        return ("admin");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello (ModelMap model) {
        System.out.println("1");
        return ("home");
    }
//    @RequestMapping(value = "home", method = RequestMethod.GET)
//    public String hello2 (ModelMap model) {
//        System.out.println("1");
//        return (""); }


    @RequestMapping(value = "home", method = RequestMethod.POST)
    public String hello3 (ModelMap model) {
                  String login = model.getAttribute("login", login);
    String password = model.getAttribute("password", password);

        if ("admin".equals(login) && "admin".equals(password)) {
       return ("admin");
    } else if ("user".equals(login) && "user".equals(password)) {
            return ("user");
    } else {
       return ("/index.html");
    }}

    @RequestMapping(value = "admin", method = RequestMethod.POST)
    public String read(ModelMap model) {
        List<Person> people = personService.readAllPersons();
        model.addAttribute("adminList", people);
        System.out.println("u");
        return ("admin");
    }

    @RequestMapping(value = "admin2", method = RequestMethod.GET)
    public String read2(ModelMap model) {
        List<Person> people = personService.readAllPersons();
        model.addAttribute("adminList", people);
        System.out.println("u");
        return ("admin");
    }


    @GetMapping(value = "updatePerson")
    public ModelAndView update() {

        return new ModelAndView("updatePersonPage");

    }

    /* It updates model object. */
    @RequestMapping(value = "updatePerson", method = RequestMethod.POST)
    public String update2(//@ModelAttribute("updatePerson") Person person,
                          @RequestParam(name = "personID") String updateId,
                          @RequestParam(name = "personName") String updateName,
                          @RequestParam(name = "personAge") String updateAge) {
        int personID = Integer.parseInt(updateId);
        int personAge = Integer.parseInt(updateAge);
        Person person = new Person();
        person.setName(updateName);
        person.setAge(personAge);
        person.setId(personID);
        personService.updatePerson(person);

        return "redirect:/admin2";
    }


//    @RequestMapping(value = "addPersonPage", method = RequestMethod.GET)
//    public ModelAndView createSave2(@ModelAttribute("addPerson") Person person) {
//        personService.createPerson(person);
//        return new ModelAndView("redirect:/addPersonPage");//will redirect to viewemp request mapping
//    }

    @RequestMapping(value = "addPerson", method = RequestMethod.GET)
    public ModelAndView addPersonFirstStep() {
//        ModelAndView model = new ModelAndView();
//        Person person = new Person(name, age);
        //  personService.createPerson(pe);
        //model.addObject("adminList", person);
        return new ModelAndView("addPersonPage.jsp");
    }

    @RequestMapping(value = "addPerson", method = RequestMethod.POST)
    public ModelAndView addPersonSecondStep(//@RequestParam(name = "personID") String updateId,
                                            @RequestParam(name = "personName") String name,
                                            @RequestParam(name = "personAge") String age) {
//        ModelAndView model = new ModelAndView();
//        Person person = new Person(name, age);
        personService.createPerson(name, age);
        //model.addObject("adminList", person);
        return new ModelAndView("redirect:/admin2");
    }

    /* It deletes record for the given id in URL and redirects to /viewemp */
    @RequestMapping(value = "deletePerson", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(name = "deletePersonID") int deletePersonId) {

        personService.deletePersonById(deletePersonId);
        return new ModelAndView("redirect:/admin2");
    }


    /**
     * this is test method for testing my aspects method AOP
     *
     * @author Ivan III
     */
    @RequestMapping(value = "/as", method = RequestMethod.GET)
    public String testBaseAOP(ModelMap model) {
        System.out.println("u");
        List<Person> people = personService.readAllPersons();
        model.addAttribute("adminList", people);
        return "admin";
    }
}


//
//    @RequestMapping(value="/getUser",method = RequestMethod.GET)
//    @ResponseBody
//    public User getUser(){
//        User u = new User();
//        //Here my dao method is activated and I wil get some userobject
//        return u;
//    }
//
//    @RequestMapping(value="/updatePSWD",method = RequestMethod.GET)
//    public String updatePswd(){
//        //update your user password
//        return "redirect:/getUser";
//    }


//    /* It provides list of employees in model object */
//    @RequestMapping("/viewemp")
//    public String viewemp(new ModelAndView m) {
//        List<Person> list = personService.readAllPersons();
//        m.addAttribute("list", list);
//        return "viewemp";
//    }
//    /* It displays object data into form for the given id.
//     * The @PathVariable puts URL data into variable.*/
//
//    @RequestMapping(value = "/updatePerson/{id}")
//    public String edit(@PathVariable int id, Person person) {
//        Person person1 = personService.readPersonById(id);
//        person.addAttribute("command", person1);
//        return "empeditform";
//    }