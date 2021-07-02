package com.digital.wallet.controllers;

import com.digital.wallet.modelRequests.RegisterRequest;
import com.digital.wallet.models.Customer;
import com.digital.wallet.models.Wallet;
import com.digital.wallet.repositories.CustomerRepository;
import com.digital.wallet.services.ConfirmationTokenService;
import com.digital.wallet.services.RegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc()
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private CustomerRepository customerRepo;

    @Test
    public void shouldRegisterNewUser() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:9090/api/v1/register")
                .content(asJsonString(new RegisterRequest("Rob",
                                "Carl", "carl@gmail.com", "robocall",
                                4567)
                ))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
//                .andExpect(status().isOk());
        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        System.out.println(result.getResponse());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
    @Test
    public void shouldFailToRegisterNewUserWithExistingEmail() throws Exception {
        Wallet mockWallet = new Wallet(0);
        RegisterRequest mockReq = new RegisterRequest("Rob",
                "Carl", "quincy@gmail.com", "robocall",
                4567);
        Customer mockCustomer = new Customer("Rob",
                "Quincy", "quincy@gmail.com","quincy",
                Arrays.asList(mockWallet));
        customerRepo.save(mockCustomer);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:9090/api/v1/register")
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockReq))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());

    }
    @Test
    public void shouldFailToRegisterNewUserWithMissingEmail() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("http://localhost:9090/api/v1/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

//    @Test
//    public void shouldConfirmRegisteredUser() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("http://localhost:9090/api/v1/registration/confirm")
//                .content(asJsonString(new RegisterRequest("Rob",
//                        "Carl", "carl@gmail.com", "robcarl",
//                        4567)
//                ))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
