package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	@GetMapping("/form")
	public String contactForm(Model model) {
		
		// ビューにフォームクラスのインスタンスを渡す
		model.addAttribute("contactForm", new ContactForm());
		
		return "contactFormView";
	}
//	
//	@GetMapping("/confirm")
//	public String redirectForm() {
//		return "confirmView";
//	}
//	
//	@PostMapping("/confirm")
//	public String submitForm(RedirectAttributes redirectAttributes,
//								@Validated ContactForm form,
//								BindingResult result) {
//		
//		// バリデーションエラーがあったら終了
//		if (result.hasErrors()) {
//
//			// フォームクラスをビューに受け渡す
//			redirectAttributes.addFlashAttribute("contactForm", form);
//			// バリデーション結果をビューに受け渡す
//			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
//								+ Conventions.getVariableName(form), result);
//			
//			return "redirect:/form";
//			
//		}
//		
//		return "confirmView";
//		
//	}
	
	@PostMapping("/confirm")
	public String submitForm(Model model,
								@Validated ContactForm form,
								BindingResult result) {
		
		// バリデーションエラーがあったら終了
		if (result.hasErrors()) {

			// フォームクラスをビューに受け渡す
			model.addAttribute("contactForm", form);
			// バリデーション結果をビューに受け渡す
			model.addAttribute(BindingResult.MODEL_KEY_PREFIX
								+ Conventions.getVariableName(form), result);
			
			return "contactFormView";
			
		}
		
		return "confirmView";
		
	}
	


}
