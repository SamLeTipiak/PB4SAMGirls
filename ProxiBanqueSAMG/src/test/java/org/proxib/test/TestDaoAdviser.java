package org.proxib.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxib.config.ApplicationConfig;
import org.proxib.model.Adviser;
import org.proxib.service.IAdviserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class TestDaoAdviser {

	@Autowired
	IAdviserService adviserService;

	
	
	Adviser ad1 = new Adviser("El", "Castador");




	@Test
	public void testServiceAddAdviser() {
		try {
			int sizeBefore = adviserService.findAll().size();
			
			adviserService.persist(ad1);
			assertEquals(sizeBefore + 1, adviserService.findAll().size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testServiceReadAdviser() {
		try {
			assertEquals("El",
					adviserService.findAll().get(adviserService.findAll().size() - 1).getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testServiceUpdateAdviser(){
		
	
		try {
			ad1=adviserService.findAll().get(adviserService.findAll().size()-1);
			ad1.setFirstName("Elo");
			adviserService.merge(ad1);
			assertEquals("Elo", adviserService.findById(ad1.getId()).getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testServiceDeleteAdviser() {
		try {
			int sizeBefore = adviserService.findAll().size();
			adviserService.remove(adviserService.findAll().get(adviserService.findAll().size() - 1).getId());
			assertEquals(sizeBefore - 1, adviserService.findAll().size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
