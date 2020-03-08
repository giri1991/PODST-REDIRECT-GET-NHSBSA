package com.nhs.test;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {
	
  private FormModel formModel = new FormModel();

  @PostMapping("/form-page")
  public String handlePostRequest(@Valid @ModelAttribute("formModel") FormModel formModel, BindingResult bindingResult, RedirectAttributes attr) {
	  this.formModel = formModel;
	  if (bindingResult.hasErrors()) {
		  attr.addFlashAttribute("formModel", bindingResult);
		  //	attr.addFlashAttribute("formModel", formModel);
          return "redirect:/form-page";
      }
	  
      return "redirect:/form-page";
  }

  @GetMapping("/form-page")
  public String handleGetRequest(Model model) {
      model.addAttribute("formModel", formModel);
      return "form-view";
  }
}