package com.wendy.webservices.controllers;

import com.wendy.domain.dtos.RewardsDTO;
import com.wendy.domain.service.GetResponse;
import com.wendy.logic.RewardsService;
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
@RequestMapping("/Rewards")
public class RewardsController {
    private RewardsService rewardsService;

    @Autowired
    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the rewards" ,notes="Returns a list of rewards")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Rewards returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<List<RewardsDTO>>> getRewards(){
        List<RewardsDTO> accountTypeDTOS = rewardsService.getAllRewards();
        GetResponse<List<RewardsDTO>> respons= new GetResponse<>(true,accountTypeDTOS);
        return new ResponseEntity<>(respons, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value="Delete an member" ,notes="Deletes one member with the specified email")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Reward deleted"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<RewardsDTO>> deleteRewards(@ApiParam(value = "id for the reward to delete",
            example = "1",
            required = true)@PathVariable("id") Long id){
        RewardsDTO rewardsDTO = rewardsService.deleteReward(id);
        GetResponse<RewardsDTO> response = new GetResponse<>(true,rewardsDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update/{id}/{price}")
    @ApiOperation(value="update a reward" ,notes="Update the reward with the id")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Reward update"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<RewardsDTO>> updateRewards(
            @RequestParam("id") Long id,@RequestParam("price") int price){
        RewardsDTO rewardsDTO = rewardsService.updateReward(id,price);
        GetResponse<RewardsDTO> response = new GetResponse<>(true,rewardsDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/add/")
    @ApiOperation(value="Add a new reward" ,notes="Adds one reward with a generated auto")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Reward added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<RewardsDTO>> addMember(
            @ApiParam(value = "Request Body for the new Member",
                    required = true)
            @RequestBody RewardsDTO rewardsDTO){
        RewardsDTO reward = rewardsService.addReward(rewardsDTO);
        GetResponse<RewardsDTO> response = new GetResponse<>(true,reward);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
