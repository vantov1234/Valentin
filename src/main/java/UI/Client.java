package UI;

public class Client {


    private String firm_name;
    private String firm_town;
    private String firm_addr;
    private String firm_is_reg_vat;
    private String firm_mol;

    public String getFirm_name() {
        return firm_name;
    }

    public String getFirm_town() {
        return firm_town;
    }

    public String getFirm_addr() {
        return firm_addr;
    }

    public String getFirm_is_reg_vat() {
        return firm_is_reg_vat;
    }

    public String getFirm_mol() {
        return firm_mol;
    }


    public Client(String firm_name, String firm_town, String firm_addr, String firm_is_reg_vat, String firm_mol) {
        this.firm_name = firm_name;
        this.firm_town = firm_town;
        this.firm_addr = firm_addr;
        this.firm_is_reg_vat = firm_is_reg_vat;
        this.firm_mol = firm_mol;
    }


}