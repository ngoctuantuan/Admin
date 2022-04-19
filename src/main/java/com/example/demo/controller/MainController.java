package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.AdminTuanEntity;
import com.example.demo.mapper.CreateMapper;
import com.example.demo.model.CreateModel;
import com.example.demo.model.DeleteModel;
import com.example.demo.model.EditModel;
import com.example.demo.model.SearchModel;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice.Return;

@Controller
@RequestMapping("/")
@Slf4j
public class MainController {
	
	@Autowired
	CreateMapper createMapper;
	
	
	@GetMapping("admin")
	public String CreateModel(@ModelAttribute CreateModel createModel, Model model) {
		
		return "CreateUser";
	}
	@PostMapping("createUser")
	public String createUser(CreateModel createModel, Model model ) {
		log.info("{}", createModel);
	createMapper.createUser(createModel);
	
		return "Login";
	}
	 
	@PostMapping("checkLogin")
	public String checkLogin(CreateModel createModel, Model model ) {
		log.info("{}", createModel);
		int result = createMapper.checkLogin(createModel);
		
		log.info("{}", result);
		
		if(result == 0) {
			return "Login";
		}else {
			
			List<AdminTuanEntity> listTuan = createMapper.getAllUser();
			log.info("{}", listTuan);
			model.addAttribute("listUser", listTuan);
			model.addAttribute("deleteModel", new DeleteModel());
			model.addAttribute("searchModel",new SearchModel());
			return"Success";
		}
	
	}
	
	@PostMapping("do-delete")
	public String doDelete(@ModelAttribute DeleteModel deleteModel	, Model model) {
		createMapper.deleteUser(deleteModel);
		List<AdminTuanEntity> listTuan = createMapper.getAllUser();
		model.addAttribute("listUser", listTuan);
		model.addAttribute("createModel", new CreateModel());
		model.addAttribute("searchModel",new SearchModel());
		
		return "Success";
	}
	
	@PostMapping("edit")
	public String edit(@ModelAttribute EditModel editModel, Model model) {
		return "Edit";
	}
	
	@PostMapping("doEdit")
	public String doEdit(@ModelAttribute EditModel editModel, Model model ) {
		createMapper.edit(editModel);
		
		List<AdminTuanEntity> tuandasua = createMapper.getAllUser();
		model.addAttribute("listUser", tuandasua);
		model.addAttribute("createModel", new CreateModel());
		model.addAttribute("searchModel",new SearchModel());
	
		return"Success";
	}

	
	@PostMapping("search")
	public String searchuser(@ModelAttribute SearchModel searchModel, Model model) {
		
		log.info("----------{}", searchModel);
		List<AdminTuanEntity> listsearch = createMapper.searchuser(searchModel);
		
		model.addAttribute("listUser", listsearch);
		
		return "Success";
			
		}	
}
		
		


	


