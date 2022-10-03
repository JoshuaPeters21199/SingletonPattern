 public class Main {
    public static void main(String[] args) {
        Policy policy = Policy.getInstance("Josh Peters", 10778268);
        System.out.println(policy.getHolderName());
        System.out.println(policy.getPolicyID());

        policy.setHolderName("James Peters");
        System.out.println(policy.getHolderName());

        policy.setPolicyID(10776892);
        System.out.println(policy.getPolicyID());

        System.out.println(policy.getDescription());
    }
 }