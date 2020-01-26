package com.udacity.pricing;

import com.netflix.discovery.converters.Auto;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PricingServiceApplicationTests {

	@MockBean
	PriceRepository mockRepository;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() {

		Price price = new Price("INR", BigDecimal.valueOf(2311.11), Long.valueOf(999));

		Mockito.when(mockRepository.findByVehicleId(999)).thenReturn(price);
	}

	@Test
	public void testFindByVehicleIdMock() {
		assertEquals("INR", mockRepository.findByVehicleId(999).getCurrency());
	}


}
