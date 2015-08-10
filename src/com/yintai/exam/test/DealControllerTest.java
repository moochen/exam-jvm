package com.yintai.exam.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.yintai.exam.entity.DealCurrency;
import com.yintai.exam.entity.DealStatus;
import com.yintai.exam.entity.DealType;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class DealControllerTest {
	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();

    }
    
    @Test
    public void createDealTest(){

        String datajson="{\"id\":1,\"createTime\":\"2015-8-10 15:22:30\",\"status\":\"DealStatus.Success\",\"type\":\"DealType.Pay\",\"amount\":55.5,\"currency\":\"DealCurrency.RMB\",\"customerId\":1,\"customerName\":\"ÕÅÈý\"}";

        try {
            this.mockMvc.perform(get("/deal/add.json","json").contentType(MediaType.APPLICATION_JSON).content( datajson.getBytes())).andExpect(status().isOk());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByStatusTest(){

        String datajson="{\"status\":\"DealStatus.Success\"}";

        try {
            this.mockMvc.perform(
                    get("/deal/query.json").contentType(MediaType.APPLICATION_JSON).content( datajson.getBytes())).andExpect(status().isOk());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
