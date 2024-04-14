package com.hotel.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getClientsExpectOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getClientExpectOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/clients/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteClientExpectOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/clients/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addClientExpectOK() throws Exception{
        String json = "{\"name\": \"Test Client\", \"email\": \"whatev.com\", \"phone\":\"1234\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void updateClientExpectOK() throws Exception{
        String json =  "{\"id\":2,\"name\": \"changed Client\", \"email\": \"whatev.com\", \"phone\":\"1234\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/clients")       
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}