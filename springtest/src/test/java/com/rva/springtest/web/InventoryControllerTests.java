package com.rva.springtest.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.rva.springtest.service.SimpleProductManager;
import com.rva.springtest.web.InventoryController;

public class InventoryControllerTests {
	@Test
    public void testHandleRequestView() throws Exception{		
        
		InventoryController controller = new InventoryController();
        controller.setProductManager(new SimpleProductManager());
        
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        //assertEquals("WEB-INF/views/hello.jsp", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}
