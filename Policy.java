/*
Create an Insurance program with a policy class that contains the fields of a policy holder name and policy ID.  
Create methods to get and set these fields.  The driver program needs to be able to set and get the names and IDs of policy holders.  
Also include a method that gets a description of your policy. Make the policy class a Singleton that is thread safe and uses lazy 
loading.  The idea here is to limit concurrency issues by preventing more than one instance of a policy at a time as the back end 
would be connected to a database.  

Test your program by setting a policy (name and ID) then retrieving them from your policy class and printing them to the screen.  
Attempts (by other insurance agents) to instantiate additional  instances of the policy should not be allowed.

Deliverable for this assignment is:  a working solution and a UML class-hierarchy diagram showing your design.

Be sure that your assignment is correctly submitted to Canvas. Check your zip file for completeness and functionality before 
submitting. 
 */

public final class Policy {
    
    private static volatile Policy instance;

    public String holderName;
    public Integer policyID;

    private Policy(String holderName, Integer policyID) {
        this.holderName = holderName;
        this.policyID = policyID;
    }

    public static Policy getHolderName(String holderName) {
        Policy result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Policy.class) {
            if (instance == null) {
                instance = new Policy(holderName);
            }
            return instance;
        }
    }
}

