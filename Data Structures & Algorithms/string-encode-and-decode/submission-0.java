class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String element = strs.get(i);
            encoded.append(String.valueOf(element.length()));
            encoded.append("#");
            encoded.append(element);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            String element = str.substring(j + 1, j + 1 + length);
            decoded.add(element);

            i = j + 1 + length;
        }

        return decoded;
    }
}
