package pmn.security;

import pmn.models.AppUser;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class Encrypt {

    public String cryptString(String text) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA3-256");
            byte[] hashBytes = digest.digest(
                    text.getBytes(StandardCharsets.UTF_8));
            String sha3Hex = bytesToHex(hashBytes);
            return sha3Hex;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte hashByte : bytes) {
            int intVal = 0xff & hashByte;
            if (intVal < 0x10) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(intVal));
        }
        return sb.toString();
    }

}
