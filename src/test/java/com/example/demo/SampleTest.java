package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.jupiter.api.Test;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeesController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
@ContextConfiguration(classes= EmployeeModel.class)

public class SampleTest {
//
//        @Autowired
//        private MockMvc mockMvc;
//
//        @MockBean
//        private EmployeesController employeesController;
//
//
//        private ObjectMapper objectMapper;
//
//        // basic simple test case
//        @Test
//        public void isTrueTest(){
//            assertTrue("Statement is true",true);
//        }
//
//        private void assertTrue(String statement_is_true, boolean b) {
//        }
//
//        @BeforeClass
//        public static void beforeClass() {
//            System.out.println("Before Class");
//        }
//
//        @Before
//        public void before() {
//            System.out.println("Before Test Case");
//        }
//
//    @Ignore
//    @Test
//    public void getAllEmployee() throws Exception {
//        System.out.println("Test");
//        this.mockMvc
//                .perform(
//                        get("/api/getAllEmployee")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }

}
