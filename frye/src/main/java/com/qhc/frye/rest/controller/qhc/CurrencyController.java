/**
 * 
 */
package com.qhc.frye.rest.controller.qhc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qhc.frye.rest.controller.entity.Currency;
import com.qhc.frye.rest.controller.entity.Incoterm;
import com.qhc.frye.rest.controller.entity.Price;
import com.qhc.frye.service.CurrencyService;
import com.qhc.frye.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author wang@dxc.com
 *
 */
@RestController
@Api(value = "Currency and Incoterm management in Frye", description = "币种管理")
public class CurrencyController {
	

	@Autowired
	private CurrencyService currencyService;
	

	@ApiOperation(value = "保存或修改币种",notes="保存或修改币种")
	@PutMapping(value = "currency")
	@ResponseStatus(HttpStatus.OK)
	public void putCurrency(@RequestBody(required = true) @Valid List<Currency> currency) {
		currencyService.saveCurrency(currency);
	}
	
	@ApiOperation(value = "获取币种map",notes="获取币种map")
	@GetMapping(value = "currency")
	@ResponseStatus(HttpStatus.OK)
	public Map<String,String> getCurrency() {
		Map<String,String> currencies = new HashMap<String,String>();
		List<Currency> curList = currencyService.getCurrency();
		for(Currency cur:curList) {
			currencies.put(cur.getCode(),cur.getName());
		}
		return currencies;
	}
	
	@ApiOperation(value = "修改国际贸易条件",notes="修改国际贸易条件")
	@PutMapping(value = "currency/incoterms")
	@ResponseStatus(HttpStatus.OK)
	public void putIncoterm(@RequestBody(required = true) @Valid List<Incoterm> incoterm) {
		currencyService.saveIncoterm(incoterm);
	}
	@ApiOperation(value = "查询国际贸易条件",notes="查询国际贸易条件")
	@GetMapping(value = "currency/incoterms")
	@ResponseStatus(HttpStatus.OK)
	public Map<String,String> getIncoterms() {
		return currencyService.getIncoterms();
	}
	
	@ApiOperation(value = "新增价格",notes="新增价格")
	@PutMapping(value = "currency/price")
	@ResponseStatus(HttpStatus.OK)
	public void putPrice(@RequestBody(required = true) @Valid List<Price> price) {
		currencyService.savePrice(price);
	}

}
