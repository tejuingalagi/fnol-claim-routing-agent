# Autonomous Insurance Claims Processing Agent (Lite)

## Overview
This project is a lightweight, rule-based insurance claims processing agent developed as part of the **Synapx Junior Software Engineer assessment**.

The purpose of this project is to demonstrate how FNOL (First Notice of Loss) claim data can be validated and routed to the correct workflow using simple and clear business rules.

The implementation focuses on **clarity, clean logic, and correctness**, keeping the solution easy to understand and extend.

---

## Problem Understanding
In real insurance systems, when a customer submits a claim, the system needs to:
- Check whether all required information is present
- Identify potentially risky or complex claims
- Route the claim to the correct processing team
- Provide a clear explanation for the decision

This project simulates that basic decision-making process.

---

## Tech Stack
- **Programming Language:** Java
- **IDE Used:** Eclipse
- **Type:** Backend logic only
- **Frameworks:** None (Core Java)
- **Database / UI:** Not used
  
---

## Project Structure

- **Claim.java**  
  Represents FNOL claim data

- **ClaimProcessor.java**  
  Validates mandatory fields

- **RoutingRules.java**  
  Applies routing business rules

- **RoutingResult.java**  
  Holds final output

- **Main.java**  
  Application entry point


---

## Input
The input is a sample insurance claim created in `Main.java`, inspired by FNOL (ACORD) forms.

Example fields include:
- Policy Number
- Policyholder Name
- Date of Loss
- Claim Type
- Incident Description
- Estimated Damage

---

## Routing Rules Implemented
The routing logic follows this priority order:

1. **Manual Review**
   - If any mandatory field is missing

2. **Investigation Flag**
   - If the description contains keywords such as:
     - fraud
     - staged
     - inconsistent

3. **Specialist Queue**
   - If the claim type is `injury`

4. **Fast-track**
   - If the estimated damage is less than 25,000

---

## Output
The application produces a structured JSON-style output:

```json
{
  "extractedFields": {},
  "missingFields": [],
  "recommendedRoute": "",
  "reasoning": ""
}
This output clearly explains what decision was made and why.

Test Scenarios Covered
The logic was tested using multiple scenarios:

Low damage claim (Fast-track)

Missing mandatory fields (Manual Review)

Fraud-related keywords in description (Investigation Flag)

Injury claim type (Specialist Queue)

High damage claim (Manual Review)

For submission clarity, one clean example is shown in the code and other scenarios were tested by modifying the input data.

Assumptions
Attachments are assumed to be empty for this lite version

Estimated damage is treated as the initial estimate

PDF parsing is out of scope; FNOL data is simulated using Java objects

How to Run
Open the project in Eclipse

Run Main.java as a Java Application

View the JSON output in the console

Demo Video (Optional)
A short demo video explaining the project flow and logic:
<PASTE VIDEO LINK HERE IF AVAILABLE>

Notes
AI tools were used to help understand the problem statement and improve clarity of explanations.
The final implementation, logic, and understanding are my own.

Author
Tejeshwini Ingalagi


