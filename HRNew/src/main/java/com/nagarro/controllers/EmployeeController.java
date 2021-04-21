package com.nagarro.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.constant.Constants;
import com.nagarro.dto.Employee;
import com.nagarro.services.EmployeeService;

@Controller
@RequestMapping(value = "employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	/**
	 * GET method to get Employee List
	 *
	 * @param model
	 * @param request
	 * @return JSP PAGE response
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getEmployeeList(ModelAndView model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		String username = httpSession.getAttribute("username").toString();
		if (httpSession!=null && username != null) {
//			System.out.println("Not null");
			List<Employee> employees = employeeService.getAllEmployees();
			model.addObject("employees", employees);
			model.setViewName("home");
		} else {
			model.setViewName("redirect:/signin");
		}
		return model;
	}
	
	/**
     * POST method to download all employee data using CSV
     *
     * @param response
     */
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void downloadFile(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=" + Constants.CSV_FILE_NAME);
        ICsvBeanWriter csvBeanWriter = null;
        try {
        	csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
            employeeService.addEmployeeDetailsToFile(csvBeanWriter);
            csvBeanWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
    
    /**
     * POST method to upload FILES and redirect to employeeJSP
     *
     * @param file
     * @param model
     * @return redirect to
     */
    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        employeeService.addAllEmployees(file);
        return "redirect:/employees";
    }
    
    /**
     * POST method to edit employee
     *
     * @param employee
     * @param model
     * @return edit employee JSP page
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editEmployee(@ModelAttribute("employee") Employee employee, Model model) {
    	System.out.println("In editEmployee");
        model.addAttribute("employee", employee);
        return "/editEmployee";
    }
    
    /**
     * POST method to redirect to employee page after editing of employee
     *
     * @param employee
     * @param model
     * @return employee JSP page
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }
}
