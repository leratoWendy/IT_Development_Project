package com.wendy.webservices.controllers;

import com.wendy.domain.dtos.PersonTransactionsDTO;
import com.wendy.domain.service.GetResponse;
import com.wendy.logic.PersonService;
import com.wendy.logic.PersonTransactionsService;
import com.wendy.logic.TypeAccountService;
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
@RequestMapping("/transactions")
public class PersonTransactionsController {
    private PersonService personService;
    private PersonTransactionsService personTransactionsService;
    private TypeAccountService typeAccountService;

    @Autowired
    public PersonTransactionsController(PersonService personService, PersonTransactionsService personTransactionsService, TypeAccountService typeAccountService) {
        this.personService = personService;
        this.personTransactionsService = personTransactionsService;
        this.typeAccountService = typeAccountService;
    }


    @GetMapping("/member/{email}")
    @ApiOperation(value="Gets a Member transactions" ,notes="Returns a list of transactions for the member with the specified email")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member transtions returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<List<PersonTransactionsDTO>>> getMemberTransactions(
            @ApiParam(value = "Email for the user to get transactions",
                    required = true)
            @PathVariable("email") String email){
        List<PersonTransactionsDTO> member = personTransactionsService.getmemberTransaction(email);
        GetResponse<List<PersonTransactionsDTO>> response = new GetResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/add/")
    @ApiOperation(value="Add a new transaction" ,notes="Adds one transaction for the user")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Transaction added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<PersonTransactionsDTO>> addMember(
            @ApiParam(value = "Request Body for the new Member",
                    required = true)
            @RequestBody PersonTransactionsDTO personDto){
        PersonTransactionsDTO member = personTransactionsService.addTransaction(personDto);
        GetResponse<PersonTransactionsDTO> response = new GetResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
