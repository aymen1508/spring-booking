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
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getHotelsExpectOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hotels")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getHotelExpectOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hotels/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteHotelExpectOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/hotels/45")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addHotelExpectOK() throws Exception{
        String json = "{\"name\": \"Test Hotel\", \"address\": \"123 Main St\", \"stars\": 2, \"description\": \"a descriptioon\", \"image\": \"src/assets/hotel.jpg\",\"standard_rooms\":60,\"standard_room_price\":100,\"deluxe_rooms\":20,\"deluxe_room_price\":150,\"luxury_rooms\":10,\"luxury_room_price\":300}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void updateHotelExpectOK() throws Exception{
        String json =  "{\"id\": 43,\"name\": \"changed name\",\"address\": \"123 Main St\",\"stars\": 2,\"price\": 0,\"image\": \"src/assets/hotel.jpg\",\"description\": \"a descriptioon\",\"createdAt\": \"2024-03-22T15:58:09.465+00:00\",\"updatedAt\": \"2024-03-22T15:58:09.465+00:00\",\"standard_rooms\":60,\"standard_room_price\":100,\"deluxe_rooms\":20,\"deluxe_room_price\":150,\"luxury_rooms\":10,\"luxury_room_price\":300}";
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}