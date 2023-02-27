class Exercide45_underflow {
    boolean underflow(String str, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (num < 0) {
                return false;
            }
            if (str.charAt(i) != '-') {
                num ++;
            } else {
                num--;
            }
        }
        return true;
    }
}