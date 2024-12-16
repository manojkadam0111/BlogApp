package com.app.BlogApp.paylods;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min=4 , message = "UserName must be min 4 Character !!!")
	private String name;
	@Email(message = "Email is not Valid !!!")
	private String email;
	@NotEmpty
	@Size(min = 5,max = 15,message = "Password must be min of 3 chars and max of 15 chars !!")
	private String password;
	@NotEmpty
	private String about;
}
