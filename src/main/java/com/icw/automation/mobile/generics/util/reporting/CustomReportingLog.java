/**
 * 
 */
package com.icw.automation.mobile.generics.util.reporting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.annotations.MarkupIgnore;

/**
 * 
 */
public class CustomReportingLog {
	private List<Object> names = Arrays.asList("Workflow", "Title", "ID Type", "Identifier", "Value", "Action", "Expected Result", "Comments");
    private Object[] favStack = new Object[]{"Java", "C#", "Angular"};
    @MarkupIgnore
    private List<Object> ignored = Arrays.asList("Anshoo/Ignore", "Extent/Ignore", "Klov/Ignore");
    private Map<Object, Object> items = new HashMap<Object, Object>() {
        {
            put("Item1", "Value1");
            put("Item2", "Value2");
            put("Item3", "Value3");
            put("Item4", "Value4");
            
            put("Item5", "Value5");
            put("Item6", "Value6");
            put("Item7", "Value7");
            put("Item8", "Value8");
        }
    };
}
