package com.hotel.backend.hosts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/hosts")
public class HostController {
    @Autowired
    HostService hostService;

    @GetMapping
    public ResponseEntity<List<Host>> getHosts(){
        return new ResponseEntity<List<Host>>(hostService.getHosts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> getHost(@PathVariable Long id){
        return new ResponseEntity<Host>(hostService.getHost(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Host> createHost(@RequestBody Host host) {
        return new ResponseEntity<>(hostService.createHost(host), HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Host> deleteHost(@PathVariable Long id){
        return new ResponseEntity<Host>(hostService.deleteHost(id), HttpStatus.OK);
    }
    

    @PutMapping
    public ResponseEntity<Host> updateHost(@RequestBody Host host){
        return new ResponseEntity<Host>(hostService.createHost(host), HttpStatus.OK);
    }


}
