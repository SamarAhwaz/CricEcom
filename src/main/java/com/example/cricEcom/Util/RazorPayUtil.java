package com.example.cricEcom.Util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class RazorPayUtil {

	public static boolean verifySignature(String orderId, String paymentId, String signature, String secret) {
    try {
        String data = orderId + "|" + paymentId;

        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        mac.init(key);

        byte[] hash = mac.doFinal(data.getBytes());
        String expected = Hex.encodeHexString(hash);

        return expected.equals(signature);
    }
    catch (Exception e) {
        return false;
    }
}
}
