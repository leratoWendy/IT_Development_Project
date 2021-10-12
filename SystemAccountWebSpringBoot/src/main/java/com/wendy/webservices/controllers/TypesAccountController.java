package com.wendy.webservices.controllers;

import com.wendy.domain.dtos.MilesDto;
import com.wendy.domain.dtos.PersonDto;
import com.wendy.domain.dtos.TypeAccountDTO;
import com.wendy.domain.service.GetResponse;
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

    @GetMapping("/getOne/{nmonic}")
    @ApiOperation(value="Gets a account types" ,notes="Returns one account types with the specified email")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Account type returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<TypeAccountDTO>> getAccountTypes(
            @ApiParam(value = "Nmonic for the account type to search",
                    required = true)
            @PathVariable("nmonic") String email){
        TypeAccountDTO member = typeAccountService.getTypeAccount(email);
        GetResponse<TypeAccountDTO> response = new GetResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{nmonic}")
    @ApiOperation(value="Delete an account type" ,notes="Deletes one account with the specified nmonic")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Account type deleted"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<TypeAccountDTO>> deleteAccountType(@ApiParam(value = "Email for the person to delete",
            required = true)@PathVariable("nmonic") String nmonic){
        TypeAccountDTO personDto = typeAccountService.getTypeAccount(nmonic);
        typeAccountService.deleteAccountType(nmonic);
        GetResponse<TypeAccountDTO> response = new GetResponse<>(true,personDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/add")
    @ApiOperation(value="Add an account type" ,notes="Add one account with the specified nmonic")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Account type added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<TypeAccountDTO>> addAccountTYpe(@ApiParam(value = "Account type dto for account type to add",
            required = true)@RequestBody TypeAccountDTO typeAccountDTO){
        TypeAccountDTO personDto = typeAccountService.addTypeAccount(typeAccountDTO);
        GetResponse<TypeAccountDTO> response = new GetResponse<>(true,personDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
