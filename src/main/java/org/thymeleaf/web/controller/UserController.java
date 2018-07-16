/**
 * 
 */
package org.thymeleaf.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.persistence.model.User;
import org.thymeleaf.persistence.service.UserService;
import org.thymeleaf.web.constant.Action;
import org.thymeleaf.web.constant.Attribute;
import org.thymeleaf.web.constant.Redirect;

/**
 * @author vee
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * @return the service
	 */
	public UserService getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(UserService service) {
		this.service = service;
	}

	@RequestMapping(value = { Action.WELCOME })
	public String indeX(ModelMap model) {
		model.addAttribute("msg", "hello...!");
		return Redirect.HOME_PAGE;
	}

	@RequestMapping(value = { Action.SAVE_USER }, method = RequestMethod.POST)
	public String registerNewUser(@ModelAttribute(value = Attribute.USER) @Valid User user, ModelMap model) {
		service.registeruser(user);
		return Redirect.REDIRECT + Action.WELCOME;

	}

	@RequestMapping(value = { Action.SIGN_IN })
	public String signiN() {
		return Redirect.SIGN_IN_PAGE;

	}

}
