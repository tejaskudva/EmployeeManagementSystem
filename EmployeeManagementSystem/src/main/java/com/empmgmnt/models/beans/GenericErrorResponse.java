package com.empmgmnt.models.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericErrorResponse {

	private Integer errorCode;
	private String errorDescription;

}
