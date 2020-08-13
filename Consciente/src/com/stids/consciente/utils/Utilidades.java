package com.stids.consciente.utils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Named
@SessionScoped
public class Utilidades implements Serializable {


	private static final long serialVersionUID = 12123123123L;
	private transient Gson gson;
	private String data;
	private String dataEncrypt;
	private SecretKeySpec secretKey;
    private Cipher cipher;
    private static final int LONGITUD_TAG_AUTENTICACION = 128;
    private static byte[] key;
    String passPhrase="**St1dsS4s2020**";

	@PostConstruct
	public void init() {
		
		try {
			gson = new GsonBuilder().create();
			encryptData();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error" +e.getMessage());
		} 
		
	}

	public String enriptar(Object obj) throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		data = gson.toJson(obj);
		dataEncrypt=encrypt(data);
		return dataEncrypt;
	}
	
	
    public void encryptData() throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {

        secretKey = new SecretKeySpec(passPhrase.getBytes(), "AES");
        key = passPhrase.getBytes("UTF8");
        cipher = Cipher.getInstance(" AES/GCM/NoPadding");
       
    }

	public String encrypt(String str) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

		cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(LONGITUD_TAG_AUTENTICACION, key));
		byte[] utf8 = str.getBytes("UTF8");
		byte[] enc = cipher.doFinal(utf8);
		return new String(Base64.getEncoder().encode(enc), "UTF-8");
	}

	public String decrypt(String str) throws InvalidKeyException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

		cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(LONGITUD_TAG_AUTENTICACION, key));
		byte[] dec = Base64.getDecoder().decode(str.getBytes("UTF-8"));
		return new String(cipher.doFinal(dec), "UTF-8");
	}

}
