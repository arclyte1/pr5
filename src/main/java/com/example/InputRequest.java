import java.io.Serializable;

public record InputRequest(String text, String divider) implements Serializable {

    public String splitByValues() {
        StringBuilder integers = new StringBuilder();
        StringBuilder floats = new StringBuilder();
        StringBuilder strings = new StringBuilder();

        String[] inputs = this.text().split(this.divider());

        for (String input : inputs) {
            try {
                long number = Long.parseLong(input);
                integers.append(number).append(" ");
            } catch (Exception e) {
                try {
                    double number = Double.parseDouble(input);
                    floats.append(number).append(" ");
                } catch (Exception e2) {
                    strings.append(input).append(" ");
                }
            }
        }

        return String.valueOf(integers) + '\n' + floats + '\n' + strings;
    }
}
