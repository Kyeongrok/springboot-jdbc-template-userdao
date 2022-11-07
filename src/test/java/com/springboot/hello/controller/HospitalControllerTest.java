package com.springboot.hello.controller;

import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.Hospital;
import com.springboot.hello.parser.HospitalParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HospitalController.class) // 테스트 대상 클래스
class HospitalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // 가짜 객체
    HospitalDao hospitalDao;

    String line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";

    @Test
    @DisplayName("조회 성공 테스트")
    void getHospitalTest() throws Exception {

        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse(line1);
        given(hospitalDao.findById(0)).willReturn(hospital);

        mockMvc.perform(get("/api/v1/hospital/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.openServiceName").exists())
                .andDo(print());

        verify(hospitalDao).findById(0); // findById가 실행 되었는지 검증 합니다.
    }
}