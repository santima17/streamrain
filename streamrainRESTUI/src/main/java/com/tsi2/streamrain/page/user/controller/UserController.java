package com.tsi2.streamrain.page.user.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsi2.streamrain.datatypes.user.UserDto;
import com.tsi2.streamrain.services.user.interfaces.IUserService;
import com.tsi2.streamrain.utils.Utils;

@Controller
public class UserController {
	
	@Resource(name="userService")
	IUserService userService;
		
	private static final String USER_PREFIX = "/user/";
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String showRegisterUser () {		
		return USER_PREFIX + "registerUser";
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ValidadorUser());
    }
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public String registerUser(@Valid UserDto userDto, BindingResult result) {
		if (result.hasErrors()) {
			return USER_PREFIX + "registerUser";
		}
		if (userDto.getNickname() != null && (!"".equals(userDto.getNickname()))) {
			if (userService.existsUserXNickName(userDto.getNickname(), "generator1")) {
				//Mostrar error("Already exists a users with that nickname");
				return USER_PREFIX + "registerUser";
			}
		}
		String passEncrptyed = Utils.encryptPassword(userDto.getPassword());
		userDto.setPassword(passEncrptyed);
		userService.saveUser(userDto, "generator1");
		return USER_PREFIX + "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String hello(@RequestParam(value="name", required=false, defaultValue="Pepe") String name, Model model) {
        model.addAttribute("name", name);
        UserDto user = new UserDto();
        user.setNickname("Santi");
        user.setCity("MVD");
        user.setEmail("santi@gmail.com");
        user.setIsBanned(true);
        user.setCountry("URU");
        user.setPassword("pass");
        user.setFacebookUserId("");
        user.setIntegratorId("");
        user.setTwitterUserId("");
        userService.saveUser(user, "generator1");
        return USER_PREFIX + "login";
    }
		
	@ModelAttribute("userDto")
	public UserDto populateForm() {
	     return new UserDto();
	}
	
	@ModelAttribute("countryList")
	public List<String> populateCountryList() {
	  List<String> country = new ArrayList<String>();
	  country.add("Afghanistan");
	  country.add("Albania");
	  country.add("Algeria");
	  country.add("American Samoa");
	  country.add("Andorra");
	  country.add("Angola");
	  country.add("Antigua and Barbuda");
	  country.add("Argentina");
	  country.add("Armenia");
	  country.add("Aruba");
	  country.add("Australia");
	  country.add("Austria");
	  country.add("Azerbaijan");
	  country.add("Bahamas");
	  country.add("Bahrain");
	  country.add("Bangladesh");
	  country.add("Barbados");
	  country.add("Belarus");
	  country.add("Belgium");
	  country.add("Belize");
	  country.add("Benin");
	  country.add("Bermuda");
	  country.add("Bhutan");
	  country.add("Bolivia");
	  country.add("Bosnia and Herzegovina");
	  country.add("Botswana");
	  country.add("Brazil");
	  country.add("British Virgin Islands");
	  country.add("Brunei");
	  country.add("Bulgaria");
	  country.add("Burkina Faso");
	  country.add("Burundi");
	  country.add("Cambodia");
	  country.add("Cameroon");
	  country.add("Canada");
	  country.add("Canary Islands");
	  country.add("Cape Verde");
	  country.add("Cayman Islands");
	  country.add("Central African Republic");
	  country.add("Ceuta and Melilla");
	  country.add("Chad");
	  country.add("Chile");
	  country.add("China");
	  country.add("Colombia");
	  country.add("Comoros");
	  country.add("Congo [DRC]");
	  country.add("Congo [Republic]");
	  country.add("Costa Rica");
	  country.add("Croatia");
	  country.add("Cuba");
	  country.add("Curaçao");
	  country.add("Cyprus");
	  country.add("Czech Republic");
	  country.add("Côte d’Ivoire");
	  country.add("Denmark");
	  country.add("Djibouti");
	  country.add("Dominica");
	  country.add("Dominican Republic");
	  country.add("Ecuador");
	  country.add("Egypt");
	  country.add("El Salvador");
	  country.add("Equatorial Guinea");
	  country.add("Eritrea");
	  country.add("Estonia");
	  country.add("Ethiopia");
	  country.add("Europe");
	  country.add("Faroe Islands");
	  country.add("Fiji");
	  country.add("Finland");
	  country.add("France");
	  country.add("French Guiana");
	  country.add("French Polynesia");
	  country.add("Gabon");
	  country.add("Gambia");
	  country.add("Georgia");
	  country.add("Germany");
	  country.add("Ghana");
	  country.add("Gibraltar");
	  country.add("Greece");
	  country.add("Greenland");
	  country.add("Grenada");
	  country.add("Guadeloupe");
	  country.add("Guam");
	  country.add("Guatemala");
	  country.add("Guernsey");
	  country.add("Guinea");
	  country.add("Guinea-Bissau");
	  country.add("Guyana");
	  country.add("Haiti");
	  country.add("Honduras");
	  country.add("Hong Kong");
	  country.add("Hungary");
	  country.add("Iceland");
	  country.add("India");
	  country.add("Indonesia");
	  country.add("Iran");
	  country.add("Iraq");
	  country.add("Ireland");
	  country.add("Isle of Man");
	  country.add("Israel");
	  country.add("Italy");
	  country.add("Jamaica");
	  country.add("Japan");
	  country.add("Jersey");
	  country.add("Jordan");
	  country.add("Kazakhstan");
	  country.add("Kenya");
	  country.add("Kiribati");
	  country.add("Kuwait");
	  country.add("Kyrgyzstan");
	  country.add("Laos");
	  country.add("Latin America");
	  country.add("Latvia");
	  country.add("Lebanon");
	  country.add("Lesotho");
	  country.add("Liberia");
	  country.add("Libya");
	  country.add("Liechtenstein");
	  country.add("Lithuania");
	  country.add("Luxembourg");
	  country.add("Macau");
	  country.add("Macedonia [FYROM]");
	  country.add("Madagascar");
	  country.add("Malawi");
	  country.add("Malaysia");
	  country.add("Mali");
	  country.add("Malta");
	  country.add("Marshall Islands");
	  country.add("Martinique");
	  country.add("Mauritania");
	  country.add("Mauritius");
	  country.add("Mayotte");
	  country.add("Mexico");
	  country.add("Micronesia");
	  country.add("Moldova");
	  country.add("Monaco");
	  country.add("Mongolia");
	  country.add("Montenegro");
	  country.add("Morocco");
	  country.add("Mozambique");
	  country.add("Myanmar [Burma]");
	  country.add("Namibia");
	  country.add("Nepal");
	  country.add("Netherlands");
	  country.add("New Caledonia");
	  country.add("New Zealand");
	  country.add("Nicaragua");
	  country.add("Niger");
	  country.add("Nigeria");
	  country.add("North Korea");
	  country.add("Northern Mariana Islands");
	  country.add("Norway");
	  country.add("Oman");
	  country.add("Pakistan");
	  country.add("Palau");
	  country.add("Palestine");
	  country.add("Panama");
	  country.add("Papua New Guinea");
	  country.add("Paraguay");
	  country.add("Peru");
	  country.add("Philippines");
	  country.add("Poland");
	  country.add("Portugal");
	  country.add("Puerto Rico");
	  country.add("Qatar");
	  country.add("Romania");
	  country.add("Russia");
	  country.add("Rwanda");
	  country.add("Réunion");
	  country.add("Saint Barthélemy");
	  country.add("Saint Kitts and Nevis");
	  country.add("Saint Lucia");
	  country.add("Saint Martin");
	  country.add("Saint Vincent and the Grenadines");
	  country.add("Samoa");
	  country.add("San Marino");
	  country.add("Saudi Arabia");
	  country.add("Senegal");
	  country.add("Serbia");
	  country.add("Seychelles");
	  country.add("Sierra Leone");
	  country.add("Singapore");
	  country.add("Sint Maarten");
	  country.add("Slovakia");
	  country.add("Slovenia");
	  country.add("Solomon Islands");
	  country.add("Somalia");
	  country.add("South Africa");
	  country.add("South Korea");
	  country.add("South Sudan");
	  country.add("Spain");
	  country.add("Sri Lanka");
	  country.add("Sudan");
	  country.add("Suriname");
	  country.add("Swaziland");
	  country.add("Sweden");
	  country.add("Switzerland");
	  country.add("Syria");
	  country.add("São Tomé and Príncipe");
	  country.add("Taiwan");
	  country.add("Tanzania");
	  country.add("Thailand");
	  country.add("Timor-Leste");
	  country.add("Togo");
	  country.add("Tonga");
	  country.add("Trinidad and Tobago");
	  country.add("Tunisia");
	  country.add("Turkey");
	  country.add("Turks and Caicos Islands");
	  country.add("U.S. Outlying Islands");
	  country.add("U.S. Virgin Islands");
	  country.add("Uganda");
	  country.add("Ukraine");
	  country.add("United Arab Emirates");
	  country.add("United Kingdom");
	  country.add("United States");
	  country.add("Uruguay");
	  country.add("Uzbekistan");
	  country.add("Vanuatu");
	  country.add("Venezuela");
	  country.add("Vietnam");
	  country.add("Western Sahara");        
	  country.add("Yemen");
	  country.add("Zambia");
	  country.add("Zimbabwe");
	  country.add("Åland Islands");
	  return country;
	}
}
