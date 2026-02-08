package com.synapx.fnol;

public class Main {

    public static void main(String[] args) {

        Claim claim = new Claim();
        claim.policyNumber = "POL12345";
        claim.policyholderName = "Tejeshwini Ingalagi";
        claim.dateOfLoss = "2026-01-10";
        claim.description = "Minor accident at traffic signal";
        claim.estimatedDamage = 18000;
        claim.claimType = "auto";

        RoutingResult result = ClaimProcessor.processClaim(claim);

//        System.out.println("Recommended Route: " + result.recommendedRoute);
//        System.out.println("Reason: " + result.reasoning);
//        System.out.println("Missing Fields: " + result.missingFields);
        
        System.out.println("{");
        System.out.println("  \"extractedFields\": {");
        System.out.println("    \"policyNumber\": \"" + result.extractedFields.policyNumber + "\",");
        System.out.println("    \"policyholderName\": \"" + result.extractedFields.policyholderName + "\",");
        System.out.println("    \"dateOfLoss\": \"" + result.extractedFields.dateOfLoss + "\",");
        System.out.println("    \"claimType\": \"" + result.extractedFields.claimType + "\",");
        System.out.println("    \"estimatedDamage\": " + result.extractedFields.estimatedDamage);
        System.out.println("  },");
        System.out.println("  \"missingFields\": " + result.missingFields + ",");
        System.out.println("  \"recommendedRoute\": \"" + result.recommendedRoute + "\",");
        System.out.println("  \"reasoning\": \"" + result.reasoning + "\"");
        System.out.println("}");

    }
}

