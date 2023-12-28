package com.lincheng.study.jdk1_8;

import org.apache.commons.lang.RandomStringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SignatureGenerator {

    public static String generateSignature(String urlPath, long timestamp, String openKeyId, String secretKey) throws Exception {
        String random = RandomStringUtils.random(5, true, true);
        System.out.println(random);
        String value = openKeyId + "&" + timestamp + "&" + urlPath;
        String key = secretKey + random;
        return random + getSign(value, key);
    }


    public static String getSign(String value, String key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.US_ASCII), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(value.getBytes(StandardCharsets.US_ASCII));

        StringBuilder result = new StringBuilder();
        for (byte b : hmacBytes) {
            result.append(String.format("%02x", b));
        }
        return Base64.getEncoder().encodeToString(result.toString().getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) throws Exception {

        System.out.println(false || false || true);

        String urlPath = "/open-api/order/purchase-order-infos";
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        String openKeyId = "3A735604474341A6B8BE3B59CD25FC76";
        String secretKey = "1BE03DFEB12A40BB90D38CDB59F529CB";
        String signature = generateSignature(urlPath, timestamp, openKeyId, secretKey);
        System.out.println("Generated Signature: " + signature);
    }
}