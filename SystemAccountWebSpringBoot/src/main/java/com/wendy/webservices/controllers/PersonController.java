package com.wendy.webservices.controllers;

import com.wendy.domain.dtos.PersonDto;
import com.wendy.domain.service.GetResponse;
import com.wendy.logic.MilesService;
import com.wendy.logic.PersonService;
import com.wendy.logic.PersonTransactionsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Member")
public class PersonController {
    private PersonService personService;
    private MilesService milesService;
    private PersonTransactionsService personTransactionsService;

    @Autowired
    public PersonController(PersonService personService, MilesService milesService, PersonTransactionsService personTransactionsService) {
        this.personService = personService;
        this.milesService = milesService;
        this.personTransactionsService = personTransactionsService;
    }


    @GetMapping("/all")
    @ApiOperation(value="Gets all the members added to the db" ,notes="Returns a list of members")
    @ApiResponses(value={
            @ApiResponse(code=200,message="membes returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<List<PersonDto>>> getAllMembers(){
        List<PersonDto> accountTypeDTOS = personService.getAllMembers();
        GetResponse<List<PersonDto>> respons= new GetResponse<>(true,accountTypeDTOS);
        return new ResponseEntity<>(respons, HttpStatus.OK);
    }

    @GetMapping("/member/{email}")
    @ApiOperation(value="Gets a Member goals" ,notes="Returns one member with the specified email")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member goals returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<PersonDto>> getMember(
            @ApiParam(value = "Email for the user to search",
                    required = true)
            @PathVariable("email") String email){
        PersonDto member = personService.getMember(email);
        GetResponse<PersonDto> response = new GetResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{email}")
    @ApiOperation(value="Delete an member" ,notes="Deletes one member with the specified email")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member deleted"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<PersonDto>> deletePerson(@ApiParam(value = "Email for the person to delete",
            required = true)@PathVariable("email") String email){
        milesService.deleteMiles(email);
        personTransactionsService.deleteMemberTransaction(email);
        PersonDto personDto = personService.deleteMember(email);
       GetResponse<PersonDto> response = new GetResponse<>(true,personDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/add/")
    @ApiOperation(value="Add a new member" ,notes="Adds one member id for the member")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<PersonDto>> addMember(
            @ApiParam(value = "Request Body for the new Member",
                    required = true)
            @RequestBody PersonDto personDto){
        PersonDto member = personService.addMember(personDto);
        milesService.addMiles(personDto);


        GetResponse<PersonDto> response = new GetResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
