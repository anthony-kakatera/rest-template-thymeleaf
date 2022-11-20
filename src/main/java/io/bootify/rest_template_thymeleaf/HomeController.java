package io.bootify.rest_template_thymeleaf;

import io.bootify.rest_template_thymeleaf.domain.UniversitiesDTO;
import io.bootify.rest_template_thymeleaf.domain.UserDTO;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/userForm")
    public String addUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "home/addUser";
    }

    @GetMapping("/getUsers")
    public String allUsers(Model model) {
        String uri = "http://universities.hipolabs.com/search?country=United+States";
        RestTemplate restTemplate = new RestTemplate();

        UniversitiesDTO[] universitiesDTO = restTemplate.getForObject(uri, UniversitiesDTO[].class);

        model.addAttribute("universities", universitiesDTO);

        return "home/allUsers";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") UserDTO userDTO){

        String uri = "https://reqres.in/api/users";
        //Rest template
        RestTemplate restTemplate = new RestTemplate();

        //header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //json object
        JSONObject jsonObject = new JSONObject();

        //add to json object
        jsonObject.put("name", userDTO.getName());
        jsonObject.put("job", userDTO.getJob());

        //Http entity to send request
        HttpEntity<String> request =
                new HttpEntity<String>(jsonObject.toString(), headers);

        //sending request and getting response entity
        ResponseEntity<String> response = restTemplate.postForEntity( uri, request , String.class );

        return "redirect:/";
    }
}
