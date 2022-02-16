package com.epam.spring.library.service.impl;

import com.epam.spring.library.exception.ServiceException;
import com.epam.spring.library.service.PasswordService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

@Component
@ConfigurationProperties(prefix = "config.password")
class PasswordServiceImpl implements PasswordService {
    private String pepper;
    private String saltAlgorithm = "SHA1PRNG";
    private String hashAlgorithm = "PBKDF2WithHmacSHA1";
    private int saltLength = 20;
    private int hashIterations = 1000;
    private int hashLength = 512;

    @Override
    public String hash(String password, String salt) {
        final char[] chars = (password + pepper).toCharArray();
        final byte[] hash;

        PBEKeySpec spec = new PBEKeySpec(chars, salt.getBytes(), hashIterations,
                                         hashLength);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(hashAlgorithm);
            hash = skf.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new ServiceException("Unable to generate hash for password");
        }

        return new String(hash);
    }

    @Override
    public String generateSalt() {
        final byte[] salt = new byte[saltLength];

        try {
            SecureRandom sr = SecureRandom.getInstance(saltAlgorithm);
            sr.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException("Unable to generate password salt");
        }

        return new String(salt);
    }
}
