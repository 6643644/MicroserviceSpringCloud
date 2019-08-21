package com.springcloud.resources.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * 針對每次HTTP請求，Spring容器會根據UserRequest bean定義建立一個全新的UserRequest bean例項， 
 * 且該UserRequest bean例項僅在當前HTTP request內有效，因此可以根據需要放心的更改所建例項的內部狀態， 
 * 而其他請求中根據UserRequest bean定義建立的例項，將不會看到這些特定於某個請求的狀態變化。 
 * 當處理請求結束，request作用域的bean例項將被銷燬。
 *
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Component
public class UserRequest {

	private String name;

	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
