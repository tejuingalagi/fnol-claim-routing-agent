package com.synapx.fnol;

import java.util.ArrayList;
import java.util.List;

public class ClaimProcessor {

    public static RoutingResult processClaim(Claim claim) {

        List<String> missingFields = new ArrayList<>();

        if (claim.policyNumber == null) missingFields.add("policyNumber");
        if (claim.policyholderName == null) missingFields.add("policyholderName");
        if (claim.dateOfLoss == null) missingFields.add("dateOfLoss");
        if (claim.description == null) missingFields.add("description");
        if (claim.claimType == null) missingFields.add("claimType");

        RoutingResult result = new RoutingResult();
        result.extractedFields = claim;
        result.missingFields = missingFields;

        return RoutingRules.applyRules(claim, missingFields, result);
    }
}
