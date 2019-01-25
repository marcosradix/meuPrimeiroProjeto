package br.com.workmade.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

public class PasswordUtils {
	
	public static String gerarBCrypt(String senha) {
		if(StringUtils.isEmpty(senha)) {
			return senha;
		}
		
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(senha);
	}
	
	public static boolean validarSenha(String senha, String senhaEncoded) {
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.matches(senha, senhaEncoded);
	}

}
