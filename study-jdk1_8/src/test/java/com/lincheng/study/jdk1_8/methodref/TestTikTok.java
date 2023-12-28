package com.lincheng.study.jdk1_8.methodref;


import org.junit.Test;

import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @description:
 * @author: linCheng
 * @create: 2023-07-14 10:14
 **/
public class TestTikTok {
    //d762c16ba014ad3b0b92548df37b85bb0451a23abd0da4617c5bd03bdd68165e
    //8124eeb58fa1581f0cf565941b038392a91e0edc/api/orders/searchapp_key695vkplogo1omtimestamp16893149618124eeb58fa1581f0cf565941b038392a91e0edc
    @Test
    public void getSign() throws Exception {
        String path = "/api/orders/search";
        TreeMap<String, String> queries = new TreeMap<>();
        queries.put("app_key", "695vkplogo1om");
        queries.put("timestamp", "1689314961");
        String secret = "8124eeb58fa1581f0cf565941b038392a91e0edc";
        try {
            String signature = generateSHA256(path, queries, secret);
            System.out.println("Generated Signature: " + signature);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }


    public String generateSHA256(String path, TreeMap<String, String> queries, String secret)
            throws NoSuchAlgorithmException, InvalidKeyException {
        List<String> keys = new ArrayList<>(queries.keySet());
        Collections.sort(keys);
        StringBuilder inputBuilder = new StringBuilder(path);
        for (String key : keys) {
            inputBuilder.append(key).append(queries.get(key));
        }
        String input = secret + inputBuilder.toString() + secret;
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.US_ASCII), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(input.getBytes(StandardCharsets.US_ASCII));
        return bytesToHex(hmacBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

}
