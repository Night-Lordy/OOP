import java.util.UUID;

public class Client {
    private String clientId;
    private String fullName;
    private String passportData;
    private String phone;
    private String email;
    private boolean isActive;

    public Client (String fullName, String passportData, String phone, String email){
        this.clientId = generateId(8);
        this.fullName = fullName;
        this.passportData = passportData;
        this.phone = phone;
        this.email = email;
        this.isActive = true;
    }

    private String generateId(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }

    public void ChangePhone(String phone){
        this.phone = phone;
    }

    public void ChangeEmail(String email){
        this.email = email;
    }

    public void DeactivateClient() {
        this.isActive = false;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getClientId(){
        return clientId;
    }
}
