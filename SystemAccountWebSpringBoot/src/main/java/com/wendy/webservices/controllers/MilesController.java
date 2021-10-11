package com.wendy.webservices.controllers;

import com.wendy.domain.dtos.MilesDto;
import com.wendy.domain.service.GetResponse;
import com.wendy.logic.MilesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Miles")
public class MilesController {
    private MilesService milesService;

    @Autowired
    public MilesController(MilesService milesService) {
        this.milesService = milesService;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the miles added to the db" ,notes="Returns a list of miles")
    @ApiResponses(value={
            @ApiResponse(code=200,message="goals returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<List<MilesDto>>> getAllGoals(){
        List<MilesDto> accountTypeDTOS = milesService.getAllMiles();
        GetResponse<List<MilesDto>> respons= new GetResponse<>(true,accountTypeDTOS);
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
    public ResponseEntity<GetResponse<MilesDto>> getMemberMiles(
            @ApiParam(value = "Email for the user to search the miles",
                    required = true)
            @PathVariable("email") String email){
        MilesDto member = milesService.getMemberMiles(email);
        GetResponse<MilesDto> response = new GetResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
