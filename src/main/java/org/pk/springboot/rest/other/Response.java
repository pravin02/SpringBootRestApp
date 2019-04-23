package org.pk.springboot.rest.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Pravin P Patil An Generic Response class having predefined keys
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {

	private boolean status;
	private Object data;
	private String message;

}