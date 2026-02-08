package com.synapx.fnol;

import java.util.List;

public class RoutingRules {

    public static RoutingResult applyRules(
            Claim claim,
            List<String> missingFields,
            RoutingResult result) {

        if (!missingFields.isEmpty()) {
            result.recommendedRoute = "Manual Review";
            result.reasoning = "Mandatory fields are missing.";
            return result;
        }

        if (claim.description != null &&
                (claim.description.toLowerCase().contains("fraud")
                        || claim.description.toLowerCase().contains("staged")
                        || claim.description.toLowerCase().contains("inconsistent"))) {

            result.recommendedRoute = "Investigation Flag";
            result.reasoning = "Claim description indicates possible fraud.";
            return result;
        }

        if ("injury".equalsIgnoreCase(claim.claimType)) {
            result.recommendedRoute = "Specialist Queue";
            result.reasoning = "Claim involves injury.";
            return result;
        }

        if (claim.estimatedDamage < 25000) {
            result.recommendedRoute = "Fast-track";
            result.reasoning = "Estimated damage is below 25,000.";
            return result;
        }

        result.recommendedRoute = "Manual Review";
        result.reasoning = "Claim requires further evaluation.";
        return result;
    }
}
