//package com.example.demo.web;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.domein.Category;
//import com.example.demo.domein.Payment;
//import com.example.demo.domein.User;
//import com.example.demo.repository.CategoryRepository;
//import com.example.demo.repository.PaymentRepository;
//import com.example.demo.repository.UserRepository;
//import com.example.demo.web.form.InputPaymentForm;
//
//@Controller
//@Transactional
//@RequestMapping("/inputPayment")
//public class InputPaymentController {
//	@Autowired UserRepository urepository; 
//	@Autowired CategoryRepository cRepository; 
//	@Autowired PaymentRepository pRepository; 
//	
//	@ModelAttribute
//	public InputPaymentForm SetUpForm(){
//		return new InputPaymentForm();
//	}
//	
//	@RequestMapping("/")
//	public String index(Model model){
//		//動作確認用
//		List<User> user= urepository.load(1);
//		
//		List<Category> category = cRepository.findAll();
//		model.addAttribute("categoryList", category);
//		model.addAttribute("userList", user);
//		return "inputPayment";
//	}
//	
//	@RequestMapping("/payment")
//	public String payment(@Validated InputPaymentForm form,BindingResult result,Model model){
//		if(result.hasErrors()){
//			return index(model);
//		}else{
//			//cRepository.findByCategory();
//			Payment payment = new Payment();
//			payment.setUserId(Integer.parseInt(form.getUserId()));
//			payment.setCategoryId(Integer.parseInt(form.getCategoryId()));
//			payment.setPayment(Integer.parseInt(form.getPayment()));
//			payment.setDate(new Date());
//			pRepository.save(payment);
//		}
//		return index(model);
//	}
//}
