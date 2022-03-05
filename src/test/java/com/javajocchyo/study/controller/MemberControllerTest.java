package com.javajocchyo.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javajocchyo.study.dto.MemberDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//fake-double : mock, stub ,

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    ObjectMapper om;

    @Test
    void testPathVariable() throws Exception {
        //given
        String name = "SHIN";
        //when
        ResultActions resultActions = mvc.perform(get("/study/path-varialbe" + "/" + name));
        //then
        resultActions.andDo(print()).andExpect(status().isOk());

    }


    @Test
    void testServletRequest() throws Exception {
        String name = "iksoo";
        ResultActions resultActions = mvc.perform(get("/study/servlet-param" + "?name=" + name));
        resultActions.andDo(print()).andExpect(status().isOk());


    }

    @Test
    void requestParam() throws Exception {
        String name = null;
        ResultActions resultActions = mvc.perform(get("/study/request-param" + "?name=" + name));
        resultActions.andDo(print()).andExpect(status().isOk());


    }


    @Test
    void testmodelAttribute() throws Exception {
        String name = "shin";
        String email = "shin@daum.net";
        int age = 33;

        ResultActions resultActions = mvc.perform(get("/study/model-attribute" + "?name=" + name + "&email=" + email + "&age=" + age));
        resultActions.andDo(print()).andExpect(status().isOk());

    }



    @Test
    void testRequestBodyString() throws Exception {
                 String content = "도애훔ㄹ과 백두산이!";

        ResultActions resultActions = mvc.perform(post("/study/request-body/string").content(content));
        resultActions.andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testRequestBodyObject() throws Exception {

        String name = "shin";
        String email = "shin@daum.net";
        int age = 33;

        MemberDto dto = new MemberDto();
        dto.setAge(age);
        dto.setName(name);
        dto.setEmail(email);

        String content = om.writeValueAsString(dto);


        ResultActions resultActions = mvc.perform(post("/study/request-body/object").content(content).contentType(MediaType.APPLICATION_JSON));
        resultActions.andDo(print()).andExpect(status().isOk());

    }



    @Test
    void testRequestBodyParam() throws Exception {

        String name = "shin";
        String email = "shin@daum.net";
        int age = 33;

       String content = "name="+name+"&email="+email+"&age="+age;



        ResultActions resultActions = mvc.perform(post("/study/request-body/param").content(content).contentType(MediaType.APPLICATION_FORM_URLENCODED));
        resultActions.andDo(print()).andExpect(status().isOk());

    }
}