package com.example.server2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainController.class)
public class Server2ApplicationTests {
    @MockitoBean//имитация репризитория(мы к тевсту небудем подключатсья к базе данных)имитация базы данных
    private UserRepository userRepository;

    @Autowired//автоматическая инициализация
    private MockMvc mockMvc;

    @Test
    public void testGetUserById() throws Exception {
        User u=new User("23fds","Andrei88r43","Andrei","Orlov",32,2L);
        when(userRepository.findById(2l)).thenReturn(Optional.of(u));//подмена реального запроса на имитацию
        mockMvc.perform(get("/users/2")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(2l)).andExpect(jsonPath("$.username").value("23fds"));//имитация запроса к серверу (сайт)
        verify(userRepository).findById(2l);
    }


}