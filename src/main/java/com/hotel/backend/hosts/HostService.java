package com.hotel.backend.hosts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostService {

    @Autowired
    HostRepository hostRepository;

    public List<Host> getHosts(){
        return hostRepository.findAll();
    }

    public Host getHost(Long id){
        return hostRepository.findById(id).get();
    }

    public Host createHost(Host host) {
        return hostRepository.save(host);
    }

    public Host deleteHost(Long id) {
        Host host = hostRepository.findById(id).get();
        hostRepository.deleteById(id);
        return host; 
    }
    
}
