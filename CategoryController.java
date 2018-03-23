package com.niit;

import java.util.List;

//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
 @RequestMapping("/Category")
	public String showCategory(Model m)
	{
	 

	 List<Category> list=categoryDAO.listCategories();
	 m.addAttribute("categoryList",list);

	return "Category";
	
		
	}
 
 @RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
  public String addCategory(@RequestParam("catname")String catname,@RequestParam("catdesc")String catDesc,Model m)
 {
	Category category=new Category();
	category.setCategoryName(catname);
	category.setCategoryDesc(catDesc);
	
	categoryDAO.addCategory(category);
	
	
	List<Category> list=categoryDAO.listCategories();
	m.addAttribute("categoryList",list);
	
			
	return "redirect:/Category";
 }
 @RequestMapping(value="/deleteCategory/{categoryId}")
 public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m )
 {
	 
	 Category category=(Category)categoryDAO.getCategory(categoryId);
	 categoryDAO.deleteCategory(category);
	 
	 List<Category> list=categoryDAO.listCategories();
		m.addAttribute("categoryList",list);
		
				
		return "redirect:/Category";
	 
 }

 @RequestMapping(value="/editCategory/{categoryId}")
 public String editCategory(@PathVariable("categoryId")int categoryId, Model m)
 {
	 System.out.println("edit process");
	 Category category=(Category)categoryDAO.getCategory(categoryId);
	 List<Category> list=categoryDAO.listCategories();
		m.addAttribute("categoryList",list);
		m.addAttribute("categoryInfo",category);
		return "UpdateCategory";
 }
 @RequestMapping(value="/UpdateCategory", method=RequestMethod.POST)
 public String updateCategory(@RequestParam("catname")String catname,@RequestParam("catdesc")String catDesc,@RequestParam("catid")int categoryId,Model m)
 {
	 System.out.println("update process success");
	 Category category=(Category)categoryDAO.getCategory(categoryId);
	 category.setCategoryName(catname);
		category.setCategoryDesc(catDesc);
		
		categoryDAO.updateCategory(category);
		
		
		List<Category> list=categoryDAO.listCategories();
		m.addAttribute("categoryList",list);
		
				
		return "redirect:/Category";
 }
 }

