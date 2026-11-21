class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;

        while(read < chars.length) {
            char current = chars[read];
            int count = 0;

            while(read < chars.length && chars[read] == current) {
                count++;
                read++;
            }

            chars[write++] = current;

            if(count > 1) {
                String num = String.valueOf(count);

                for(int j = 0; j < num.length(); j++) {
                    chars[write++] = num.charAt(j);
                }
            }
        }

        return write;
    }
}