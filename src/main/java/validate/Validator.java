package validate;

public class Validator {


    public boolean checkNull(String check, String x, String y, String r) {
        return (check != null && x != null && y != null && r != null) && (!check.trim().equals("") &&!x.trim().equals("") && !y.trim().equals("") && !r.trim().equals(""));
    }
    public boolean checkClean(String check){
        return check.equals("clear");
    }
    private boolean checkValueX(String x) {
        try {
            double newX = Double.parseDouble(x);
            return newX >= -5 && newX <= 5;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    private boolean checkValueY(String y) {
        try {
            double newY = Double.parseDouble(y);
            return newY == -3 || newY == -2 || newY == -1 || newY == 0 || newY == 1 || newY == 2 || newY == 3 || newY == 4 || newY == 5;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    private boolean checkValueR(String r) {
        try {
            double newR = Double.parseDouble(r);
            return newR == 1 || newR == 2 || newR == 3 || newR == 4 || newR == 5;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    public boolean checkValue(String x, String y, String r) {
        return checkValueX(x) && checkValueY(y) && checkValueR(x);
    }

    public String checkResult(String x, String y, String r) {
        double newx = Double.parseDouble(x);
        double newy = Double.parseDouble(y);
        double newr = Double.parseDouble(r);
        if ((newx >= 0 && newy >= 0 && newx * newx + newy * newy <= newr * newr) ||
                (newx <= 0 && newy >= 0 && newx >= -newr && newy <= newr) ||
                (newx >= 0 && newy <= 0 && newy >= newx - newr / 2)) {
            return "<span style='color: green'>TRUE</span>";
        } else {
            return  "<span style='color: red'>FALSE</span>";
        }
    }
}
