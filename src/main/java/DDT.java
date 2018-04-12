import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;


@RunWith(Parameterized.class)
public class DDT {

    String firm_name;
    String firm_town;
    String firm_addr;
    String firm_is_reg_vat;
    String firm_mol;

    @Parameterized.Parameters
    public String[][] testData() {
        String[][] testData = {
                {"Ivan Ivanov", "Sofia", "Sofia", "No", "No"},
                {"Ivan Georgiev", "Sofia", "Sofia", "No", "No"},
                {"Petar Petrov", "Sofia", "Sofia", "No", "No"},
        };

        for (String[] entry : testData) {
            System.out.println("entry: " + Arrays.toString(entry));
        }

        return testData;

    }
    public DDT(String firm_name, String firm_town, String firm_addr, String firm_is_reg_vat, String firm_mol) {
        this.firm_name = firm_name;
        this.firm_town = firm_town;
        this.firm_addr = firm_addr;
        this.firm_is_reg_vat = firm_is_reg_vat;
        this.firm_mol = firm_mol;
    }

}
