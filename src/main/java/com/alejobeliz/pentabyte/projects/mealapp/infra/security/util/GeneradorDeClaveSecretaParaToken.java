package com.alejobeliz.pentabyte.projects.mealapp.infra.security.util;

import java.security.SecureRandom;
import java.util.Base64;

public class GeneradorDeClaveSecretaParaToken {

     public void generadorDeFirmas() {
            // Generar una clave secreta de 256 bits (32 bytes)
            SecureRandom secureRandom = new SecureRandom();
            byte[] key = new byte[32];
            secureRandom.nextBytes(key);

            // Codificar en Base64 para una representación legible
            String secretKey = Base64.getEncoder().encodeToString(key);
            System.out.println("Clave secreta: " + secretKey);
        }
    }

