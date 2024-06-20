
// Package declaration
package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller to handle requests related to Employee
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    // Constructor-based dependency injection
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Handle GET requests for listing employees
    @GetMapping("/list")
    public String getList(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employee", employeeList);
        return "employee/employee-List";
    }

    // Handle GET requests for displaying the employee form
    @GetMapping("/employeeform")
    public String employeForm(Model model){
        Employee theEmployee = new Employee();
        model.addAttribute("employee", theEmployee);
        return "employee/employeeform-list";
    }

    // Handle POST requests for saving an employee
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employee/list";
    }

    // Handle GET requests for displaying the update form
    @GetMapping("/updateform")
    public String updateForm(@RequestParam("employeeId") int employeeId, Model model){
        Employee theEmployee = employeeService.findById(employeeId);
        model.addAttribute("employee", theEmployee);
        return "employee/employeeform-list";
    }

    // Handle GET requests for deleting an employee
    @GetMapping("/deleteform")
    public String deleteForm(@RequestParam("employeeId") int employeeId){
        Employee theEmployee = employeeService.deleteById(employeeId);
        return "redirect:/employee/list";
    }
}
