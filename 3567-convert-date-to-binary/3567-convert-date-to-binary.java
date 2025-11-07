class Solution {
    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        String yearBinary = decimalToBinary(year);
        String monthBinary = decimalToBinary(month);
        String dayBinary = decimalToBinary(day);

        return yearBinary + "-" + monthBinary + "-" + dayBinary;
    }

    //helper Decimal to Binary functin
    public String decimalToBinary(int num){
        if(num == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while(num>0){
            int rem = num%2;
            sb.append(rem);
            num /= 2;
        }
        return sb.reverse().toString();
    }
}