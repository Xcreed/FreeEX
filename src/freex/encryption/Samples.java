package freex.encryption;

import java.util.*;
import java.io.*;

public class Samples {
	public Samples (){
		//encrypt();
		decrypt("hIwDochtfW1edk4BBAC+VZdVUWrQ15pEdURb3vB+cNBohklMjibYlGJZfgOwOC7hEfSXK5tgavnsbYHByNKBnPbs2lFleersDfysN+66yeRyICrlY3dAC98nop4bRbokNrilIvIz7g5d2qCsWFKprXHGPET3/rTFlf/wAxcI3e7/miQexdDMghqksfAEw9JRAV2Yxh3g2kaU0VaI/Q0G17xBh9c0wJjI2K6T5iVpg4BLVRYm8yAW7N3X7BDsSCo9WCfEiNQ2CNIJEqccHkiHugPtz1vKreFLH+Xk8Diz09ry=cKJK");
	}
	public void signSample(){
		// text to be signed
		String		text = "GnuPG Java Wrapper API";
		// PGP passphrase
		String		passPhrase = "_abcdefghijk_";
		boolean		result;

		GnuPG pgp = new GnuPG ();

		result = pgp.sign (text, passPhrase);
		if (result)
		{
			System.out.println ("Result:\n" + pgp.gpg_result + "\n\n");
		}
		else
		{
			System.out.println ("Error signing:" + pgp.gpg_err + "\n\n");
		}
	}
	
	public void clearSigning(){
		// text to be clear signed
		String		text = "GnuPG Java Wrapper API";
		// PGP passphrase
		String		passPhrase = "_abcdefghijk_";
		boolean		result;

		GnuPG pgp = new GnuPG ();

		result = pgp.clearSign (text, passPhrase);
		if (result)
		{
			System.out.println ("Result:\n" + pgp.gpg_result + "\n\n");
		}
		else
		{
			System.out.println ("Error clear signing:" + pgp.gpg_err + "\n\n");
		}
	}
	
	public void signAndEncrypt(){
		// text to be signed and encrypted
		String		text = "GnuPG Java Wrapper API";
		//// The ID of PGP key (use gpg --list-keys to get the key ID)
		String		keyID = "0A6F9ECF";	
		// PGP passphrase
		String		passPhrase = "_abcdefgijk_";
		boolean		result;

		GnuPG pgp = new GnuPG ();

		result = pgp.signAndEncrypt (text, keyID, passPhrase);
		if (result)
		{
			System.out.println ("Result:\n" + pgp.gpg_result + "\n\n");
		}
		else
		{
			System.out.println ("Error encrypting and signing:" + pgp.gpg_err + "\n\n");
		}

	}
	
	public void encrypt(){
		// text to be encrypted
		String		text = "GnuPG Java Wrapper API";
		// The ID of PGP key (use gpg --list-keys to get the key ID)
		String		keyID = "0A6F9ECF"; 
		boolean		result;

		GnuPG pgp = new GnuPG ();

		result = pgp.encrypt (text, keyID);
		if (result)
		{
			System.out.println ("Result:\n" + pgp.gpg_result + "\n\n");
		}
		else
		{
			System.out.println ("Error encrypting:" + pgp.gpg_err + "\n\n");
		}
	}
	
	public void decrypt(String text){
		// text: text to be decryped
		// PGP passphrase
		String		passPhrase = "_abcdefghijk_";
		boolean		result;

		GnuPG pgp = new GnuPG ();

		result = pgp.decrypt (text, passPhrase);
		if (result)
		{
			System.out.println ("Result:\n" + pgp.gpg_result + "\n\n");
		}
		else
		{
			System.out.println ("Error decrypting:" + pgp.gpg_err + "\n\n");
		}
	}
}
