package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.RentService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rent")
@CrossOrigin
public class RentController {

    @Autowired
    RentService rentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveRent(@ModelAttribute RentDTO rentDTO){
        rentService.saveRent(rentDTO);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRent(@RequestBody RentDTO rentDTO){
        rentService.updateRent(rentDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(path = "/{rentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRent(@PathVariable String rentId){
        return new ResponseUtil(200,"Ok",rentService.searchRent(rentId));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRent(){
        return new ResponseUtil(200,"Ok",rentService.getAllRent());
    }
}
