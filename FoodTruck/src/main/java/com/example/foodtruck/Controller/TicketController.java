package com.example.foodtruck.Controller;

import com.example.foodtruck.DTO.TicketDTO;
import com.example.foodtruck.Service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/Api/v1/ticket")
public class TicketController {
    private final TicketService ticketService;
    @GetMapping("/get")
    public ResponseEntity GetAllTicket(){
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getAllOrder());
    }
    @PostMapping("/add")
    public  ResponseEntity AddTicket(@RequestBody @Valid TicketDTO ticketDTO){
        ticketService.addTicket(ticketDTO);
        return ResponseEntity.status(HttpStatus.OK).body("added Ticket");
    }
    @PutMapping("/put")
    public ResponseEntity UpdateTicket(@PathVariable Integer id, @RequestBody @Valid TicketDTO ticketDTO){
        ticketService.updateTicket(id, ticketDTO);
        return ResponseEntity.status(HttpStatus.OK).body("update Ticket");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteTicket(@PathVariable Integer id){
        ticketService.deleteTicket(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete Ticket");
    }
}
