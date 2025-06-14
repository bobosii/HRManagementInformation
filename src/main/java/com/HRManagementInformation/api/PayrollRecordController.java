package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IPayrollRecordsService;
import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.entities.PayrollRecord;
import com.HRManagementInformation.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/payroll")
public class PayrollRecordController {

    private final IPayrollRecordsService payrollService;
    private final IUserService userService;

    @Autowired
    public PayrollRecordController(IPayrollRecordsService payrollService, IUserService userService) {
        this.payrollService = payrollService;
        this.userService = userService;
    }

    // ✅ Listeleme + form gösterimi
    @GetMapping
    public String showPayrollPage(Model model) {
        model.addAttribute("payrollRecords", payrollService.getAll());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("payrollRecord", new PayrollRecord());
        return "payroll";
    }

    // ✅ Yeni kayıt ekleme
    @PostMapping("/save")
    public String savePayroll(@RequestParam("userId") int userId,
                              @RequestParam("payroll_date") Date payrollDate,
                              @RequestParam("base_salary") double baseSalary,
                              @RequestParam("bonuses") double bonuses,
                              @RequestParam("deductions") double deductions) {
        User user = userService.get(userId);
        PayrollRecord record = new PayrollRecord();
        record.setUser(user);
        record.setPayroll_date(payrollDate);
        record.setBase_salary(baseSalary);
        record.setBonuses(bonuses);
        record.setDeductions(deductions);
        record.setNetSalary(baseSalary + bonuses - deductions);

        payrollService.save(record);
        return "redirect:/payroll";
    }

    // ✅ Kayıt silme
    @GetMapping("/delete/{id}")
    public String deletePayroll(@PathVariable int id) {
        payrollService.delete(id);
        return "redirect:/payroll";
    }

    // ✅ Kayıt düzenleme formu
    @GetMapping("/edit/{id}")
    public String editPayrollForm(@PathVariable int id, Model model) {
        PayrollRecord record = payrollService.get(id);
        model.addAttribute("payrollRecord", record);
        model.addAttribute("users", userService.getAll());
        return "payroll-edit";
    }

    // ✅ Güncelleme işlemi
    @PostMapping("/update")
    public String updatePayroll(@RequestParam("id") int id,
                                @RequestParam("userId") int userId,
                                @RequestParam("payroll_date") Date payrollDate,
                                @RequestParam("base_salary") double baseSalary,
                                @RequestParam("bonuses") double bonuses,
                                @RequestParam("deductions") double deductions) {

        PayrollRecord existing = payrollService.get(id);
        existing.setUser(userService.get(userId));
        existing.setPayroll_date(payrollDate);
        existing.setBase_salary(baseSalary);
        existing.setBonuses(bonuses);
        existing.setDeductions(deductions);
        existing.setNetSalary(baseSalary + bonuses - deductions);

        payrollService.update(existing);
        return "redirect:/payroll";
    }
}
