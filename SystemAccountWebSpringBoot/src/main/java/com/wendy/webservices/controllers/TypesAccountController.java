package com.wendy.webservices.controllers;

import com.wendy.domain.dtos.MilesDto;
import com.wendy.domain.dtos.TypeAccountDTO;
import com.wendy.domain.service.GetResponse;
import com.wendy.logic.PersonTransactionsService;
import com.wendy.logic.TypeAccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Account_Types")
public class TypesAccountController {
    private TypeAccountService typeAccountService;
    private PersonTransactionsService personTransactionsService;

    @Autowired
    public TypesAccountController(TypeAccountService typeAccountService, PersonTransactionsService personTransactionsService) {
        this.typeAccountService = typeAccountService;
        this.personTransactionsService = personTransactionsService;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the account types added to the db" ,notes="Returns a list of account types")
    @ApiResponses(value={
            @ApiResponse(code=200,message="account types returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<List<TypeAccountDTO>>> getAllGoals(){
        List<TypeAccountDTO> accountTypeDTOS = typeAccountService.getAccountTypes();
        GetResponse<List<TypeAccountDTO>> respons= new GetResponse<>(true,accountTypeDTOS);
        return new ResponseEntity<>(respons, HttpStatus.OK);
    }
}
