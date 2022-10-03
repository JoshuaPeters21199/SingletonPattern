// Singleton class
public final class Policy {
    
    private static volatile Policy instance;

    public String holderName;
    public Integer policyID;

    private Policy(String holderName, Integer policyID) {
        this.holderName = holderName;
        this.policyID = policyID;
    }

    public static Policy getInstance(String holderName, Integer policyID) {
        Policy result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Policy.class) {
            if (instance == null) {
                instance = new Policy(holderName, policyID);
            }
            return instance;
        }
    }

    public String getHolderName() {
        return holderName;
    }

    public Integer getPolicyID() {
        return policyID;
    }

    public void setHolderName(String newHolderName) {
        this.holderName = newHolderName;
    }

    public void setPolicyID(Integer newPolicyID) {
        this.policyID = newPolicyID;
    }

    public String getDescription() {
        String description = "Policy Description: \nThis policy is a legal contract between you and us. \nA coverage applies only when a premium for it is \nshown on the Policy Declarations. If more than one \nauto is insured...";
        return description;
    }
}

