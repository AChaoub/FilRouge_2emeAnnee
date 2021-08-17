package com.Achaoub.filRouge.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class ClientLoginRequest {

	private String email;
	private String password;
}
